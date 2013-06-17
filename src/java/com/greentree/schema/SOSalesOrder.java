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
import com.jadeworld.jade.persistence.OneToMany;
import com.jadeworld.jade.persistence.ReferenceRelationshipType;
import com.jadeworld.jade.persistence.ReferenceUpdateMode;

@Entity()
public class SOSalesOrder extends SODocument {

    @SuppressWarnings("unchecked")
    @DbProperty()
    @OneToMany(relationshipType = ReferenceRelationshipType.PARENT,
            updateMode = ReferenceUpdateMode.AUTOMATIC, inverse = "mySalesOrder")
    public LineItemArray<LineItem> getAllINLineItems() {
        return (LineItemArray<LineItem>) EntityAccess.getReferenceProperty(this, "allINLineItems");
    }

    @DbProperty(length = 30)
    public String getCustomerOrderNumber() {
        return EntityAccess.getStringProperty(this, "customerOrderNumber");
    }

    public void setCustomerOrderNumber(String customerOrderNumber) {
        EntityAccess.setStringProperty(this, "customerOrderNumber", customerOrderNumber);
    }

    @DbProperty()
    public boolean getIsPackingSlipped() {
        return EntityAccess.getBooleanProperty(this, "isPackingSlipped");
    }

    public void setIsPackingSlipped(boolean isPackingSlipped) {
        EntityAccess.setBooleanProperty(this, "isPackingSlipped", isPackingSlipped);
    }

    @DbProperty()
    @ManyToOne(relationshipType = ReferenceRelationshipType.PEER,
            updateMode = ReferenceUpdateMode.MANUAL,
            inverses = {"allSOSalesOrders", "allSalesOrdersByOrderNumber"})
    public Customer getMyCustomer() {
        return (Customer) EntityAccess.getReferenceProperty(this, "myCustomer");
    }

    public void setMyCustomer(Customer myCustomer) {
        EntityAccess.setReferenceProperty(this, "myCustomer", myCustomer);
    }
}