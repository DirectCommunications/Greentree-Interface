/*
 * Copyright (C) 2013 Direct Communications
 * 
 * Licensed under the BSD License.
 */

package com.greentree.schema;

import com.jadeworld.jade.entitymanager.EntityAccess;
import com.jadeworld.jade.persistence.DbProperty;
import com.jadeworld.jade.persistence.Entity;
import com.jadeworld.jade.persistence.ManyToMany;
import com.jadeworld.jade.persistence.ManyToOne;
import com.jadeworld.jade.persistence.OneToMany;
import com.jadeworld.jade.persistence.ReferenceRelationshipType;
import com.jadeworld.jade.persistence.ReferenceUpdateMode;

@Entity()
public class SOPackingSlip extends SODocument {

    @SuppressWarnings("unchecked")
    @DbProperty()
    @OneToMany(relationshipType = ReferenceRelationshipType.PARENT,
            updateMode = ReferenceUpdateMode.AUTOMATIC,
            inverse = "mySOPickingDocument")
    public SOPSINLineItemByStockLocDict<SOPSINLineItem> getAllPackedLineItems() {
        return (SOPSINLineItemByStockLocDict<SOPSINLineItem>) EntityAccess.getReferenceProperty(this, "allPackedLineItems");
    }

    @SuppressWarnings("unchecked")
    @DbProperty()
    @OneToMany(relationshipType = ReferenceRelationshipType.PARENT,
            updateMode = ReferenceUpdateMode.AUTOMATIC,
            inverse = "mySOPickingDocument")
    public SOPSINLineItemByStockLocDict<SOPSINLineItem> getAllPickedLineItems() {
        return (SOPSINLineItemByStockLocDict<SOPSINLineItem>) EntityAccess.getReferenceProperty(this, "allPickedLineItems");
    }

    @SuppressWarnings("unchecked")
    @DbProperty()
    @ManyToMany(relationshipType = ReferenceRelationshipType.PEER,
            updateMode = ReferenceUpdateMode.MANUAL,
            inverses = {"allGeneratedPackingSlips"})
    public SODocumentByReferenceDict<SODocument> getAllSourceSalesOrders() {
        return (SODocumentByReferenceDict<SODocument>) EntityAccess.getReferenceProperty(this, "allSourceSalesOrders");
    }

    @DbProperty(length = 30)
    public String getCustomerOrderNumber() {
        return EntityAccess.getStringProperty(this, "customerOrderNumber");
    }

    public void setCustomerOrderNumber(String customerOrderNumber) {
        EntityAccess.setStringProperty(this, "customerOrderNumber", customerOrderNumber);
    }

    @DbProperty()
    @ManyToOne(relationshipType = ReferenceRelationshipType.PEER,
            updateMode = ReferenceUpdateMode.MANUAL,
            inverses = {"allSOPackingSlips", "allSOPackingSlipsUnconfirmed"})
    public Customer getMyCustomer() {
        return (Customer) EntityAccess.getReferenceProperty(this, "myCustomer");
    }

    public void setMyCustomer(Customer myCustomer) {
        EntityAccess.setReferenceProperty(this, "myCustomer", myCustomer);
    }

    @DbProperty()
    public String getPickingStatus() {
        return EntityAccess.getSLOBProperty(this, "pickingStatus");
    }

    public void setPickingStatus(String pickingStatus) {
        EntityAccess.setSLOBProperty(this, "pickingStatus", pickingStatus);
    }

    @DbProperty(length = 30)
    public String getSalesOrderReference() {
        return EntityAccess.getStringProperty(this, "salesOrderReference");
    }

    public void setSalesOrderReference(String salesOrderReference) {
        EntityAccess.setStringProperty(this, "salesOrderReference",
                salesOrderReference);
    }
}