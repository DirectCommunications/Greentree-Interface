(ns au.com.directcommunications.greentree.purchase-order-test
  "Unit tests for Greentree purchase order interface."
  (:require [midje.sweet :refer :all]
            [au.com.directcommunications.greentree.purchase-order :as purchase-order]
            [user :as dev-env]))

(def valid-po "1")
(def invalid-po "1a112")
(def sopo-link-po "15097")
(def sopo-link-with-none "15087")
;;; Greentree works to 4 decimal places
(def sopo-link-po-first-line {:linked-quantity 7.0000M :sales-order "50058"})
(def sopo-with-some-linked "15084")
(def sopo-with-some-link-first-line {:linked-quantity 2.0000M :sales-order "50055"})

(defn sopo-link-lines
  "Just a test helper function, given a purchase order, returns the
  sequence of SOPO link lines, if any."
  [purchase-order]
  (-> purchase-order
      (:lines)
      (first)
      (:sales-orders)))

(with-state-changes [(around :contents (do (dev-env/go) ?form (dev-env/stop)))]
  (fact "Lookup purchase order via number."
    (purchase-order/get-purchase-order
     (:purchase-order-lookup dev-env/system) valid-po) => truthy)
  (fact "Invalid purchase order number should return nil."
    (purchase-order/get-purchase-order
     (:purchase-order-lookup dev-env/system) invalid-po) => falsey)
  (fact "Purchase order lines should have sales order linked."
    (empty? (:lines (purchase-order/get-purchase-order
                     (:purchase-order-lookup dev-env/system) sopo-link-po))) => falsey)
  (fact "Expected SOPOLink line."
    (first (sopo-link-lines (purchase-order/get-purchase-order
                             (:purchase-order-lookup dev-env/system) sopo-link-po)))
    => (contains sopo-link-po-first-line))
  (fact "Should be no SOPO linking."
    (empty? (sopo-link-lines (purchase-order/get-purchase-order
                             (:purchase-order-lookup dev-env/system) sopo-link-with-none)))
    => truthy)
  (fact "Purchase order only has some lines SO linked."
    (first (sopo-link-lines (purchase-order/get-purchase-order
                             (:purchase-order-lookup dev-env/system) sopo-with-some-linked)))
    => (contains sopo-with-some-link-first-line)))
