/*
 * Copyright (C) 2013 Direct Communications
 * 
 * Licensed under the BSD License.
 */

package com.greentree.schema;

import com.jadeworld.jade.entitymanager.EntityAccess;
import com.jadeworld.jade.persistence.DbField;
import com.jadeworld.jade.persistence.DbProperty;
import com.jadeworld.jade.persistence.Entity;
import com.jadeworld.jade.persistence.ManyToOne;
import com.jadeworld.jade.persistence.OneToMany;
import com.jadeworld.jade.persistence.ReferenceRelationshipType;
import com.jadeworld.jade.persistence.ReferenceUpdateMode;

@Entity()
public class INSerialLotLineItem extends com.jadeworld.jade.rootschema.Object {

    @SuppressWarnings("unchecked")
    @DbProperty()
    @OneToMany()
    public RPRTTextLineDict<RPRTTextLine> getAllLinesOfText() {
        return (RPRTTextLineDict<RPRTTextLine>) EntityAccess.getReferenceProperty(this, "allLinesOfText");
    }

    @DbProperty()
    @ManyToOne(relationshipType = ReferenceRelationshipType.PEER, updateMode = ReferenceUpdateMode.MAN_AUTO, inverses = {"allSerialLotLineItems"})
    public LineItem getMyLineItem() {
        return (LineItem) EntityAccess.getReferenceProperty(this, "myLineItem");
    }

    public void setMyLineItem(LineItem myLineItem) {
        EntityAccess.setReferenceProperty(this, "myLineItem", myLineItem);
    }

    @DbProperty()
    @ManyToOne(relationshipType = ReferenceRelationshipType.PEER, updateMode = ReferenceUpdateMode.MAN_AUTO, inverses = {"allLineItems"})
    public INSerialLot getMySerialLot() {
        return (INSerialLot) EntityAccess.getReferenceProperty(this, "mySerialLot");
    }

    public void setMySerialLot(INSerialLot mySerialLot) {
        EntityAccess.setReferenceProperty(this, "mySerialLot", mySerialLot);
    }
    
    @DbField(type = "Decimal", length = 14, scale = 4)
    public java.math.BigDecimal quantity;

    public java.math.BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(java.math.BigDecimal quantity) {
        this.quantity = quantity;
    }
}