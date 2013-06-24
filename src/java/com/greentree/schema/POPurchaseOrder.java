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
import com.jadeworld.jade.persistence.ReferenceRelationshipType;
import com.jadeworld.jade.persistence.ReferenceUpdateMode;

@Entity()
public class POPurchaseOrder extends PODocument {

    @DbField(type = "Date")
    public java.util.Calendar expectedDate;
    @DbField()
    public boolean isOutstanding;

    public java.util.Calendar getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(java.util.Calendar expectedDate) {
        this.expectedDate = expectedDate;
    }

    public boolean getIsOutstanding() {
        return isOutstanding;
    }

    public void setIsOutstanding(boolean isOutstanding) {
        this.isOutstanding = isOutstanding;
    }

    @DbProperty()
    @ManyToOne(relationshipType = ReferenceRelationshipType.PEER,
            updateMode = ReferenceUpdateMode.MANUAL,
            inverses = {"allPOPurchaseOrders"})
    public Supplier getMySupplier() {
        return (Supplier) EntityAccess.getReferenceProperty(this, "mySupplier");
    }

    public void setMySupplier(Supplier mySupplier) {
        EntityAccess.setReferenceProperty(this, "mySupplier", mySupplier);
    }
}