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
}