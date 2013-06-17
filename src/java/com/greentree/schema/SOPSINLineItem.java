/*
 * Copyright (C) 2013 Direct Communications
 * 
 * Licensed under the BSD License.
 */

package com.greentree.schema;

import com.jadeworld.jade.entitymanager.EntityAccess;
import com.jadeworld.jade.persistence.DbProperty;
import com.jadeworld.jade.persistence.Entity;
import com.jadeworld.jade.persistence.ManyToOne;
import com.jadeworld.jade.persistence.ReferenceRelationshipType;
import com.jadeworld.jade.persistence.ReferenceUpdateMode;

@Entity()
public class SOPSINLineItem extends LineItem {

    @DbProperty()
    public boolean getIsPacked() {
        return EntityAccess.getBooleanProperty(this, "isPacked");
    }

    public void setIsPacked(boolean isPacked) {
        EntityAccess.setBooleanProperty(this, "isPacked", isPacked);
    }

    @DbProperty()
    public boolean getIsPicked() {
        return EntityAccess.getBooleanProperty(this, "isPicked");
    }

    public void setIsPicked(boolean isPicked) {
        EntityAccess.setBooleanProperty(this, "isPicked", isPicked);
    }

    @DbProperty()
    public boolean getIsPrintInPS() {
        return EntityAccess.getBooleanProperty(this, "isPrintInPS");
    }

    public void setIsPrintInPS(boolean isPrintInPS) {
        EntityAccess.setBooleanProperty(this, "isPrintInPS", isPrintInPS);
    }

    @DbProperty()
    @ManyToOne(relationshipType = ReferenceRelationshipType.PEER,
            updateMode = ReferenceUpdateMode.MANUAL,
            inverses = {"allSOPSLineItems"})
    public SOSOINLineItem getMySOSOLineItem() {
        return (SOSOINLineItem) EntityAccess.getReferenceProperty(this, "mySOSOLineItem");
    }

    public void setMySOSOLineItem(SOSOINLineItem mySOSOLineItem) {
        EntityAccess.setReferenceProperty(this, "mySOSOLineItem", mySOSOLineItem);
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
    public java.math.BigDecimal getQtyPicked() {
        return EntityAccess.getDecimalProperty(this, "qtyPicked");
    }

    public void setQtyPicked(java.math.BigDecimal qtyPicked) {
        EntityAccess.setDecimalProperty(this, "qtyPicked", qtyPicked);
    }

    @DbProperty(type = "Decimal", length = 14, scale = 4)
    public java.math.BigDecimal getStockingQty() {
        return EntityAccess.getDecimalProperty(this, "stockingQty");
    }

    public void setStockingQty(java.math.BigDecimal stockingQty) {
        EntityAccess.setDecimalProperty(this, "stockingQty", stockingQty);
    }

    @DbProperty(type = "Decimal", length = 14, scale = 4)
    public java.math.BigDecimal getUnitCost() {
        return EntityAccess.getDecimalProperty(this, "unitCost");
    }

    public void setUnitCost(java.math.BigDecimal unitCost) {
        EntityAccess.setDecimalProperty(this, "unitCost", unitCost);
    }
}