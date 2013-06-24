(ns com.directcommunications.greentree.purchase-order
  "Namespace for handling Greentree purchase orders."
  (:import (com.greentree.schema POPurchaseOrder
                                 POPOINLineItem
                                 POPOGLLineItem
                                 POPOJCLineItem)))

(defn get-purchase-order
  "Given a purchase order number, returns the purchase order it relates to. Otherwise nil."
  [purchase-order-lookup purchase-order-number]
  (.getAtKey purchase-order-lookup (str purchase-order-number)))


(defprotocol PurchaseOrderLine
  (quantity [this] "Return the quantity.")
  (part-number [this] "Return string of the part number.")
  (description [this] "Return a string of the description.")
  (sales-orders [this] "Return a sequence of linked sales orders for the line.")
  (job-reference [this] "Return a string that represents the job."))

(extend-protocol PurchaseOrderLine
  com.greentree.schema.POPOINLineItem
  (quantity [this] (.getQuantity this))
  (part-number [this] (.codeString this)))
