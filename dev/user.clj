(ns user
  (:require [clojure.pprint :refer (pprint)]
            [clojure.repl :refer :all]
            [clojure.tools.namespace.repl :refer (refresh refresh-all)]
            [au.com.directcommunications.greentree.system :as system]
            [au.com.directcommunications.greentree.purchase-order :as purchase-order]
            [config :as dev-config]))

(def system nil)

(defn init
  "Starts the current development system."
  []
  (alter-var-root #'system
                  (constantly (system/system dev-config/defaults))))

(defn start
  "Starts the current development system."
  []
  (alter-var-root #'system system/start))

(defn stop
  "Shuts down and destroys the current development system."
  []
  (alter-var-root #'system
                  (fn [s] (when s (system/stop s)))))

(defn go
  "Initalises the current development system and starts it running."
  []
  (init)
  (start))

(defn reset
  "Reset and reload everything."
  []
  (stop)
  (refresh :after 'user/go))
