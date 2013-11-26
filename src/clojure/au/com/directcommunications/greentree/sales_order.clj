(ns au.com.directcommunications.greentree.sales-order
  "Namespace for handling Greentree sales orders."
  (:import (com.greentree.schema SOSalesOrder
                                 SOSOINLineItem
                                 SOSOGLLineItem
                                 SOSOTOLineItem)))

(defprotocol SalesOrderLine
  (quantity [this] "Return the quantity of items")
  (part-number [this] "Return the part number, or code of the item")
  (description [this] "Return the description of the line")
  (narration [this] "Return the narration for that line.")
  (unit-price [this] "Return the unit price of that item")
  (tax [this] "Return the total tax for the line.")
  (total [this] "Return the line total."))

(extend-protocol SalesOrderLine
  com.greentree.schema.SOSOTOLineItem
  (quantity [this] nil)
  (part-number [this] nil)
  (description [this] (.getStandardText this))
  (narration [this] nil)
  (unit-price [this] nil)
  (tax [this] nil)
  (total [this] nil)

  com.greentree.schema.SOSOGLLineItem
  (quantity [this] (.getQuantity this))
  (part-number [this] (.getCodeDescription this))
  (description [this] (.getStandardText this))
  (narration [this] nil)
  (unit-price [this] (.getUnitPrice this))
  (tax [this] (.getLcTaxAmount this))
  (total [this] (.getLcAmount this))

  com.greentree.schema.LineItem
  (quantity [this] (.getQuantity this))
  (part-number [this] (.getCodeString this))
  (description [this] (.getCodeDescription this))
  (narration [this] (.getStandardText this))
  (unit-price [this] (.getUnitPrice this))
  (tax [this] (.getLcTaxAmount this))
  (total [this] (.getLcAmount this)))

(defn transform-line
  "Takes a single sales order line, and returns a map that represents it."
  [line]
  {:quantity (quantity line)
   :part-number (part-number line)
   :description (description line)
   :narration (narration line)
   :unit-price (unit-price line)
   :tax (tax line)
   :total (total line)})

(defn transform-sales-order
  "Takes a purchase order and returns a map."
  [sales-order]
  {:sales-order-number (.getReference sales-order)
   :date (.getDocumentDate sales-order)
   :customer (.getMyCustomer sales-order)
   :public-notes (.getStandardText sales-order)
   :lines (map transform-line (.getAllLineItems sales-order))})

(defn get-sales-order
  "Given a sales-order number, return the sales order it relates
  to. Otherwise nil."
  [sales-order-lookup sales-order-number]
  (if-let [sales-order (.getAtKey sales-order-lookup
                                  (str sales-order-number))]
    (transform-sales-order sales-order)))
