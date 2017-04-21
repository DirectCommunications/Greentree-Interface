/*
 * Copyright (C) 2013 Direct Communications
 *
 * Licensed under the MIT License.
 */

package com.greentree.schema;

import com.jadeworld.jade.entitymanager.EntityAccess;
import com.jadeworld.jade.persistence.DbProperty;
import com.jadeworld.jade.persistence.Entity;
import com.jadeworld.jade.persistence.ManyToOne;
import com.jadeworld.jade.persistence.ReferenceRelationshipType;
import com.jadeworld.jade.persistence.ReferenceUpdateMode;

@Entity()
public class SOSOINLineItem extends SOSOLineItem {

    @DbProperty()
    @ManyToOne(relationshipType = ReferenceRelationshipType.CHILD,
            updateMode = ReferenceUpdateMode.MANUAL,
            inverses = {"allINLineItems", "allINLineItemsByItemLocation"})
    public SODocument getMySalesOrder() {
        return (SODocument) EntityAccess.getReferenceProperty(this, "mySalesOrder");
    }

    public void setMySalesOrder(SODocument mySalesOrder) {
        EntityAccess.setReferenceProperty(this, "mySalesOrder", mySalesOrder);
    }

    @DbProperty(type = "Decimal", length = 14, scale = 4)
    public java.math.BigDecimal getQtyBackordered() {
        return EntityAccess.getDecimalProperty(this, "qtyBackordered");
    }

    public void setQtyBackordered(java.math.BigDecimal qtyBackordered) {
        EntityAccess.setDecimalProperty(this, "qtyBackordered", qtyBackordered);
    }

    @DbProperty(type = "Decimal", length = 14, scale = 4)
    public java.math.BigDecimal getQtyCommitted() {
        return EntityAccess.getDecimalProperty(this, "qtyCommitted");
    }

    public void setQtyCommitted(java.math.BigDecimal qtyCommitted) {
        EntityAccess.setDecimalProperty(this, "qtyCommitted", qtyCommitted);
    }

    @DbProperty(type = "Decimal", length = 14, scale = 4)
    public java.math.BigDecimal getQtyLinking() {
        return EntityAccess.getDecimalProperty(this, "qtyLinking");
    }

    public void setQtyLinking(java.math.BigDecimal qtyLinking) {
        EntityAccess.setDecimalProperty(this, "qtyLinking", qtyLinking);
    }
}