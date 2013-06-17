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
import com.jadeworld.jade.persistence.Lob;
import com.jadeworld.jade.persistence.ManyToOne;
import com.jadeworld.jade.persistence.ReferenceRelationshipType;
import com.jadeworld.jade.persistence.ReferenceUpdateMode;

@Entity()
public class POReleaseSOLinkInfo extends com.jadeworld.jade.rootschema.Object {

    @DbField(length = 20)
    public String customerCode;

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }
    
    @Lob()
    @DbField()
    public String customerName;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    @DbField(type = "Date")
    public java.util.Calendar date;

    public java.util.Calendar getDate() {
        return date;
    }

    public void setDate(java.util.Calendar date) {
        this.date = date;
    }

    @DbProperty()
    @ManyToOne(relationshipType = ReferenceRelationshipType.CHILD, updateMode = ReferenceUpdateMode.MANUAL, inverses = {"allPOReleaseSOLinkInfos"})
    public POPurchaseOrder getMyPurchaseOrder() {
        return (POPurchaseOrder) EntityAccess.getReferenceProperty(this, "myPurchaseOrder");
    }

    public void setMyPurchaseOrder(POPurchaseOrder myPurchaseOrder) {
        EntityAccess.setReferenceProperty(this, "myPurchaseOrder", myPurchaseOrder);
    }
    
    @DbField(length = 30)
    public String packingSlipNumber;

    public String getPackingSlipNumber() {
        return packingSlipNumber;
    }

    public void setPackingSlipNumber(String packingSlipNumber) {
        this.packingSlipNumber = packingSlipNumber;
    }
}