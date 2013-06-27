(ns au.com.directcommunications.greentree.system
  "Namespace for building up the system to connect to Greentree."
  (:import (com.jadeworld.jade.entitymanager
            EntityManager EntityManagerFactory Persistence)
           (java.util Properties)
           (com.greentree.schema POControl SOControl)))

(defn system
  "Returns a new instance of the whole application."
  [options]
  (merge {:multiuser "true"
          :schema "GreenTreeSchema"
          :application "GTODBCService"
          :entity-manager-factory (atom nil)
          :entity-manager (atom nil)} options))

(defn construct-properties
  "Given a map, returns a Java properties instance for setting up the connection options to Greentree."
  [system]
  (doto (Properties.)
    (.setProperty "jade.database.multiuser" (:multiuser system))
    (.setProperty "jade.database.schema" (:schema system))
    (.setProperty "jade.database.application" (:application system))
    (.setProperty "jade.database.path" (:server-database-path system))
    (.setProperty "jade.database.configuration" (:configuration system))
    (.setProperty "jade.database.username" (:username system))
    (.setProperty "jade.database.password" (:password system))))

(defn cleanup-connection
  "Takes the system map, and cleans up any connection on it."
  [system]
  (do
    (if @(:entity-manager system)
     (do
       (.close @(:entity-manager system))
       (reset! (:entity-manager system) nil)))
    (if @(:entity-manager-factory system)
      (do
        (.close @(:entity-manager-factory system))
        (reset! (:entity-manager-factory system) nil)))))

(defn start
  "Performs side effects to initialise the system, get resources, and
  start it running. Returns an updated instance of the system."
  [system]
  (let [emf (Persistence/createEntityManagerFactory
             (str (:schema system) "PU")
             (construct-properties system))
        em (.createEntityManager emf)
        purchase-order-control (.firstInstance em POControl)
        purchase-order-lookup (.getAllPOPurchaseOrders purchase-order-control)
        sales-order-control (.firstInstance em SOControl)
        sales-order-lookup (.getAllSOSalesOrders sales-order-control)]
    (cleanup-connection system)
    (reset! (:entity-manager-factory system) emf)
    (reset! (:entity-manager system) em)
    (merge system {:purchase-order-control purchase-order-control
                   :purchase-order-lookup purchase-order-lookup
                   :sales-order-control sales-order-control
                   :sales-order-lookup sales-order-lookup})))

(defn stop
  "Performs side effects to shut down the system and release its resources. Returns an updated instance of the system."
  [system]
  (cleanup-connection system))
