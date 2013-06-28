(ns au.com.directcommunications.greentree.sales-order-test
  "Sales order unit tests."
  (:require [midje.sweet :refer :all]
            [au.com.directcommunications.greentree.sales-order :as sales-order]
            [user :as dev-env]))

(def valid-so "50004")
(def invalid-so "-1232")

(with-state-changes [(around :contents (do ( dev-env/go) ?form (dev-env/stop)))]
  (fact "Lookup sales order via number."
    (sales-order/get-sales-order
     (:sales-order-lookup dev-env/system) valid-so) => truthy)
  (fact "Invalid sales order number should return nil."
    (sales-order/get-sales-order
     (:sales-order-lookup dev-env/system) invalid-so) => falsey))
