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

    public String getReference() {
        return reference.trim();
    }

    public void setReference(String reference) {
        this.reference = reference.trim();
    }

    @DbProperty()
    public String getAdditionalDeliveryText() {
        return EntityAccess.getSLOBProperty(this, "additionalDeliveryText").trim();
    }

    public void setAdditionalDeliveryText(String additionalDeliveryText) {
        EntityAccess.setSLOBProperty(this, "additionalDeliveryText",
                additionalDeliveryText);
    }

    @DbProperty()
    public String getAddress1() {
        return EntityAccess.getSLOBProperty(this, "address1").trim();
    }

    public void setAddress1(String address1) {
        EntityAccess.setSLOBProperty(this, "address1", address1.trim());
    }

    @DbProperty()
    public String getAddress2() {
        return EntityAccess.getSLOBProperty(this, "address2").trim();
    }

    public void setAddress2(String address2) {
        EntityAccess.setSLOBProperty(this, "address2", address2.trim());
    }

    @DbProperty()
    public String getAddress3() {
        return EntityAccess.getSLOBProperty(this, "address3").trim();
    }

    public void setAddress3(String address3) {
        EntityAccess.setSLOBProperty(this, "address3", address3.trim());
    }

    @DbProperty()
    public String getAddressName() {
        return EntityAccess.getSLOBProperty(this, "addressName").trim();
    }

    public void setAddressName(String addressName) {
        EntityAccess.setSLOBProperty(this, "addressName", addressName.trim());
    }

    @DbProperty()
    public String getAddressNumber() {
        return EntityAccess.getSLOBProperty(this, "addressNumber").trim();
    }

    public void setAddressNumber(String addressNumber) {
        EntityAccess.setSLOBProperty(this, "addressNumber", addressNumber.trim());
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
        return EntityAccess.getSLOBProperty(this, "email").trim();
    }

    public void setEmail(String email) {
        EntityAccess.setSLOBProperty(this, "email", email.trim());
    }

    @DbProperty()
    public String getFaxNo() {
        return EntityAccess.getSLOBProperty(this, "faxNo").trim();
    }

    public void setFaxNo(String faxNo) {
        EntityAccess.setSLOBProperty(this, "faxNo", faxNo.trim());
    }

    @DbProperty()
    public boolean getIsPrinted() {
        return EntityAccess.getBooleanProperty(this, "isPrinted");
    }

    public void setIsPrinted(boolean isPrinted) {
        EntityAccess.setBooleanProperty(this, "isPrinted", isPrinted);
    }
}
