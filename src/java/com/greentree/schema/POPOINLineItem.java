/*
 * Copyright (C) 2013 Direct Communications
 * 
 * Licensed under the BSD License.
 */

package com.greentree.schema;

import com.jadeworld.jade.persistence.DbField;
import com.jadeworld.jade.persistence.DbProperty;
import com.jadeworld.jade.persistence.Entity;
import com.jadeworld.jade.persistence.ReferenceRelationshipType;
import com.jadeworld.jade.persistence.ReferenceUpdateMode;
import com.jadeworld.jade.entitymanager.EntityAccess;
import com.jadeworld.jade.persistence.ManyToOne;

@Entity()
public class POPOINLineItem extends POPOLineItem {

    @DbField(type = "Decimal", length = 14, scale = 4)
    public java.math.BigDecimal allocatedQty;

    public java.math.BigDecimal getAllocatedQty() {
        return allocatedQty;
    }

    public void setAllocatedQty(java.math.BigDecimal allocatedQty) {
        this.allocatedQty = allocatedQty;
    }

    @DbProperty()
    @ManyToOne(relationshipType = ReferenceRelationshipType.PEER, updateMode = ReferenceUpdateMode.MANUAL, inverses = {"allPOLineItems"})
    public StockItem getMyStockItem() {
        return (StockItem) EntityAccess.getReferenceProperty(this, "myStockItem");
    }

    public void setMyStockItem(StockItem myStockItem) {
        EntityAccess.setReferenceProperty(this, "myStockItem", myStockItem);
    }
}