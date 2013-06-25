(ns com.directcommunications.greentree.purchase-order
  "Namespace for handling Greentree purchase orders."
  (:import (com.greentree.schema POPurchaseOrder
                                 POPOINLineItem
                                 POPOGLLineItem
                                 POPOJCLineItem)))

(defn transform-sopo-link
  "Takes a Greentree SOPOLink and transforms it into a map."
  [sopo-link]
  (if (> (.getLinkedSOQty sopo-link) 0)
    {:linked-quantity (.getLinkedSOQty sopo-link)
     :sales-order (.getReference (.getMySOLineItem sopo-link))}
    {:allocated-quantity (.getReleasedSOQty sopo-link)
     :sales-order (.getReference (.getMySOLineItem sopo-link))}))

(defprotocol PurchaseOrderLine
  (quantity [this] "Return the quantity.")
  (part-number [this] "Return string of the part number.")
  (description [this] "Return a string of the description.")
  (sales-orders [this] "Return a sequence of linked sales orders for the line.")
  (job-reference [this] "Return a string that represents the job."))

(extend-protocol PurchaseOrderLine
  com.greentree.schema.POPOINLineItem
  (quantity [this] (.getQuantity this))
  (part-number [this] (.codeString this))
  (description [this] (.codeDescription this))
  (sales-orders [this] (map transform-sopo-link (.getAllSOPOLinks this)))
  (job-reference [this] nil)

  com.greentree.schema.POPOJCLineItem
  (quantity [this] nil)
  (part-number [this] nil)
  (description [this] (.getStandardText this))
  (sales-orders [this] '())
  (job-reference [this] (.getCodeDescription this))

  com.greentree.schema.POPOGLLineItem
  (quantity [this] (.getQuantity this))
  (part-number [this] nil)
  (description [this] (.getStandardText this))
  (sales-orders [this] nil)
  (job-reference [this] nil))

(defn transform-line
  "Takes a purchase order line from Greentree, and returns a map of that
  line."
  [line]
  {:quantity (quantity line)
   :part-number (part-number line)
   :description (description line)
   :sales-orders (sales-orders line)
   :job-reference (job-reference line)})

(defn transform-purchase-order
  "Takes a purchase order, and returns a map."
  [purchase-order]
  {:purchase-order-number (.getReference purchase-order)
   :date (.getDocumentDate purchase-order)
   :supplier (.getName (.getMySupplier purchase-order))
   :lines (map transform-line (.getAllLineItems purchase-order))})

(defn get-purchase-order
  "Given a purchase order number, returns the purchase order it relates
  to. Otherwise nil."
  [purchase-order-lookup purchase-order-number]
  (if-let [purchase-order (.getAtKey purchase-order-lookup
                                     (str purchase-order-number))]
    (transform-purchase-order purchase-order)))
