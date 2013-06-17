(ns greentree-interface.core
  (:import com.jadeworld.jade.entitymanager.Persistence com.greentree.schema.Customer))

(def emf (Persistence/createEntityManagerFactory "GreenTreeSchemaPU"))

(def em (.createEntityManager emf))

(def test-customer (.firstInstance em Customer))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))
