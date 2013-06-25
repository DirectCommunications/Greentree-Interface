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
import com.jadeworld.jade.persistence.OneToMany;
import com.jadeworld.jade.persistence.ReferenceRelationshipType;
import com.jadeworld.jade.persistence.ReferenceUpdateMode;

@Entity()
public class Supplier extends com.jadeworld.jade.rootschema.Object {

    @DbField(length = 50)
    public String address1;
    @DbField(length = 50)
    public String address2;
    @DbField(length = 50)
    public String address3;
    @DbField(length = 12)
    public String code;
    @DbField(length = 50)
    public String fax;
    @DbField(length = 50)
    public String name;
    @DbField(length = 50)
    public String phone;
    @Lob()
    @DbField()
    public String purchaseOrderRecipientAddress;

    public String getAddress1() {
        return address1.trim();
    }

    public void setAddress1(String address1) {
        this.address1 = address1.trim();
    }

    public String getAddress2() {
        return address2.trim();
    }

    public void setAddress2(String address2) {
        this.address2 = address2.trim();
    }

    public String getAddress3() {
        return address3.trim();
    }

    public void setAddress3(String address3) {
        this.address3 = address3.trim();
    }

    @SuppressWarnings("unchecked")
    @DbProperty()
    @OneToMany(relationshipType = ReferenceRelationshipType.PEER,
            updateMode = ReferenceUpdateMode.AUTOMATIC,
            inverse = "mySupplier")
    public POByReferenceDict<PODocument> getAllPOPurchaseOrders() {
        return (POByReferenceDict<PODocument>) EntityAccess.getReferenceProperty(this, "allPOPurchaseOrders");
    }

    public String getCode() {
        return code.trim();
    }

    public void setCode(String code) {
        this.code = code.trim();
    }

    public String getFax() {
        return fax.trim();
    }

    public void setFax(String fax) {
        this.fax = fax.trim();
    }

    @Override
    public String getName() {
        return name.trim();
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public String getPhone() {
        return phone.trim();
    }

    public void setPhone(String phone) {
        this.phone = phone.trim();
    }

    public String getPurchaseOrderRecipientAddress() {
        return purchaseOrderRecipientAddress.trim();
    }

    public void setPurchaseOrderRecipientAddress(String purchaseOrderRecipientAddress) {
        this.purchaseOrderRecipientAddress = purchaseOrderRecipientAddress.trim();
    }

    @Override
    public String toString() {
        return "Name: " + this.name.trim();
    }
}
