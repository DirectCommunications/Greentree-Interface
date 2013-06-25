/*
 * Copyright (C) 2013 Direct Communications
 *
 * Licensed under the BSD License.
 */

package com.greentree.schema;

import com.jadeworld.jade.persistence.DbField;
import com.jadeworld.jade.persistence.DbProperty;
import com.jadeworld.jade.persistence.Entity;
import com.jadeworld.jade.persistence.OneToMany;
import com.jadeworld.jade.persistence.ReferenceRelationshipType;
import com.jadeworld.jade.persistence.ReferenceUpdateMode;
import com.jadeworld.jade.entitymanager.EntityAccess;

@Entity()
public class POPOINLineItem extends POPOLineItem {

    @DbField(type = "Decimal", length = 14, scale = 4)
    public java.math.BigDecimal allocatedQty;

    @SuppressWarnings("unchecked")
    @DbProperty()
    @OneToMany(relationshipType = ReferenceRelationshipType.PEER,
            updateMode = ReferenceUpdateMode.MAN_AUTO,
            inverse = "myPOLineItem")
    public SOPOLinkArray<SOPOLink> getAllSOPOLinks() {
        return (SOPOLinkArray<SOPOLink>) EntityAccess.getReferenceProperty(this, "allSOPOLinks");
    }

    public java.math.BigDecimal getAllocatedQty() {
        return allocatedQty;
    }

    public void setAllocatedQty(java.math.BigDecimal allocatedQty) {
        this.allocatedQty = allocatedQty;
    }

    public String getDescription() {
        return EntityAccess.sendMsgGetString(this, "getDescription").trim();
    }

    @Override
    public String toString() {
        return this.getQuantity().toString() + " x "
                + this.codeString + " - "
                + this.codeDescription;
    }
}
