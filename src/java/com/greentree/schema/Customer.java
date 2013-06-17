/*
 * Copyright (C) 2013 Direct Communications
 * 
 * Licensed under the BSD License.
 */

package com.greentree.schema;

import com.jadeworld.jade.entitymanager.EntityAccess;
import com.jadeworld.jade.persistence.DbProperty;
import com.jadeworld.jade.persistence.Entity;
import com.jadeworld.jade.persistence.OneToMany;
import com.jadeworld.jade.persistence.ReferenceRelationshipType;
import com.jadeworld.jade.persistence.ReferenceUpdateMode;

@Entity()
public class Customer extends com.jadeworld.jade.rootschema.Object {

    @DbProperty(length = 50)
    public String getAddress1() {
        return EntityAccess.getStringProperty(this, "address1");
    }

    public void setAddress1(String address1) {
        EntityAccess.setStringProperty(this, "address1", address1);
    }

    @DbProperty(length = 50)
    public String getAddress2() {
        return EntityAccess.getStringProperty(this, "address2");
    }

    public void setAddress2(String address2) {
        EntityAccess.setStringProperty(this, "address2", address2);
    }

    @DbProperty(length = 50)
    public String getAddress3() {
        return EntityAccess.getStringProperty(this, "address3");
    }

    public void setAddress3(String address3) {
        EntityAccess.setStringProperty(this, "address3", address3);
    }

    // We are working with interop with JADE, no way of knowing type.
    @SuppressWarnings("unchecked")
    @DbProperty()
    @OneToMany(relationshipType = ReferenceRelationshipType.PEER,
            updateMode = ReferenceUpdateMode.AUTOMATIC, inverse = "myCustomer")
    public SODocumentByReferenceDict<SODocument> getAllSOSalesOrders() {
        return (SODocumentByReferenceDict<SODocument>) EntityAccess.getReferenceProperty(this, "allSOSalesOrders");
    }

    @DbProperty(length = 12)
    public String getCode() {
        return EntityAccess.getStringProperty(this, "code");
    }

    public void setCode(String code) {
        EntityAccess.setStringProperty(this, "code", code);
    }

    @Override
    @DbProperty(length = 50)
    public String getName() {
        return EntityAccess.getStringProperty(this, "name");
    }

    public void setName(String name) {
        EntityAccess.setStringProperty(this, "name", name);
    }

    @DbProperty(type = "Decimal", length = 14, scale = 2)
    public java.math.BigDecimal getSalesOrderTotal() {
        return EntityAccess.getDecimalProperty(this, "salesOrderTotal");
    }

    public void setSalesOrderTotal(java.math.BigDecimal salesOrderTotal) {
        EntityAccess.setDecimalProperty(this, "salesOrderTotal", salesOrderTotal);
    }
}
