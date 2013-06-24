/*
 * Copyright (C) 2013 Direct Communications
 *
 * Licensed under the BSD License.
 */

package com.greentree.schema;

import com.jadeworld.jade.entitymanager.EntityAccess;
import com.jadeworld.jade.persistence.DbProperty;
import com.jadeworld.jade.persistence.DbField;
import com.jadeworld.jade.persistence.Entity;
import com.jadeworld.jade.persistence.OneToMany;
import com.jadeworld.jade.persistence.ReferenceRelationshipType;
import com.jadeworld.jade.persistence.ReferenceUpdateMode;

@Entity()
public abstract class SODocument extends com.jadeworld.jade.rootschema.Object {

    @DbField(length = 23)
    public String reference;

    @DbProperty()
    public String getAdditionalDeliveryText() {
        return EntityAccess.getSLOBProperty(this, "additionalDeliveryText");
    }

    public void setAdditionalDeliveryText(String additionalDeliveryText) {
        EntityAccess.setSLOBProperty(this, "additionalDeliveryText",
                additionalDeliveryText);
    }

    @DbProperty()
    public String getAddress1() {
        return EntityAccess.getSLOBProperty(this, "address1");
    }

    public void setAddress1(String address1) {
        EntityAccess.setSLOBProperty(this, "address1", address1);
    }

    @DbProperty()
    public String getAddress2() {
        return EntityAccess.getSLOBProperty(this, "address2");
    }

    public void setAddress2(String address2) {
        EntityAccess.setSLOBProperty(this, "address2", address2);
    }

    @DbProperty()
    public String getAddress3() {
        return EntityAccess.getSLOBProperty(this, "address3");
    }

    public void setAddress3(String address3) {
        EntityAccess.setSLOBProperty(this, "address3", address3);
    }

    @DbProperty()
    public String getAddressName() {
        return EntityAccess.getSLOBProperty(this, "addressName");
    }

    public void setAddressName(String addressName) {
        EntityAccess.setSLOBProperty(this, "addressName", addressName);
    }

    @DbProperty()
    public String getAddressNumber() {
        return EntityAccess.getSLOBProperty(this, "addressNumber");
    }

    public void setAddressNumber(String addressNumber) {
        EntityAccess.setSLOBProperty(this, "addressNumber", addressNumber);
    }

    @SuppressWarnings("unchecked")
    @DbProperty()
    @OneToMany(relationshipType = ReferenceRelationshipType.PEER,
            updateMode = ReferenceUpdateMode.AUTOMATIC,
            inverse = "mySODocument")
    public LineItemArray<LineItem> getAllLineItems() {
        return (LineItemArray<LineItem>) EntityAccess.getReferenceProperty(this, "allLineItems");
    }

    @DbProperty(type = "Date")
    public java.util.Calendar getDatePrinted() {
        return EntityAccess.getDateProperty(this, "datePrinted");
    }

    public void setDatePrinted(java.util.Calendar datePrinted) {
        EntityAccess.setDateProperty(this, "datePrinted", datePrinted);
    }

    @DbProperty(type = "Date")
    public java.util.Calendar getDocumentDate() {
        return EntityAccess.getDateProperty(this, "documentDate");
    }

    public void setDocumentDate(java.util.Calendar documentDate) {
        EntityAccess.setDateProperty(this, "documentDate", documentDate);
    }

    @DbProperty()
    public String getEmail() {
        return EntityAccess.getSLOBProperty(this, "email");
    }

    public void setEmail(String email) {
        EntityAccess.setSLOBProperty(this, "email", email);
    }

    @DbProperty()
    public String getFaxNo() {
        return EntityAccess.getSLOBProperty(this, "faxNo");
    }

    public void setFaxNo(String faxNo) {
        EntityAccess.setSLOBProperty(this, "faxNo", faxNo);
    }

    @DbProperty()
    public boolean getIsPrinted() {
        return EntityAccess.getBooleanProperty(this, "isPrinted");
    }

    public void setIsPrinted(boolean isPrinted) {
        EntityAccess.setBooleanProperty(this, "isPrinted", isPrinted);
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}