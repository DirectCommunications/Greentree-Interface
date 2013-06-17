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
import com.jadeworld.jade.persistence.OneToMany;
import com.jadeworld.jade.persistence.ReferenceRelationshipType;
import com.jadeworld.jade.persistence.ReferenceUpdateMode;

@Entity()
public class Supplier extends com.jadeworld.jade.rootschema.Object {

    @DbField(length = 50)
    public String address1;

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }
    @DbField(length = 50)
    public String address2;

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @DbField(length = 50)
    public String address3;

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    @SuppressWarnings("unchecked")
    @DbProperty()
    @OneToMany(relationshipType = ReferenceRelationshipType.PEER, updateMode = ReferenceUpdateMode.AUTOMATIC, inverse = "myOutstandingSupplier")
    public POByExpectedDateDict<POPurchaseOrder> getAllOutstandingPOs() {
        return (POByExpectedDateDict<POPurchaseOrder>) EntityAccess.getReferenceProperty(this, "allOutstandingPOs");
    }

    @SuppressWarnings("unchecked")
    @DbProperty()
    @OneToMany(relationshipType = ReferenceRelationshipType.PEER, updateMode = ReferenceUpdateMode.AUTOMATIC, inverse = "mySupplier")
    public LineItemSet<LineItem> getAllPOLineItems() {
        return (LineItemSet<LineItem>) EntityAccess.getReferenceProperty(this, "allPOLineItems");
    }

    @SuppressWarnings("unchecked")
    @DbProperty()
    @OneToMany(relationshipType = ReferenceRelationshipType.PEER, updateMode = ReferenceUpdateMode.AUTOMATIC, inverse = "mySupplier")
    public POByReferenceDict<PODocument> getAllPOPurchaseOrders() {
        return (POByReferenceDict<PODocument>) EntityAccess.getReferenceProperty(this, "allPOPurchaseOrders");
    }

    @DbField(length = 12)
    public String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}