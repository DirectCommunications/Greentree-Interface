/*
 * Copyright (C) 2013 Direct Communications
 *
 * Licensed under the MIT License.
 */
package com.greentree.schema;

import com.jadeworld.jade.entitymanager.EntityAccess;
import com.jadeworld.jade.persistence.DbProperty;
import com.jadeworld.jade.persistence.DbField;
import com.jadeworld.jade.persistence.Entity;
import com.jadeworld.jade.persistence.Lob;
import com.jadeworld.jade.persistence.OneToMany;
import com.jadeworld.jade.persistence.ReferenceRelationshipType;
import com.jadeworld.jade.persistence.ReferenceUpdateMode;

@Entity()
public abstract class SODocument extends com.jadeworld.jade.rootschema.Object {

    @Lob()
    @DbField()
    public String additionalDeliveryText;
    @Lob()
    @DbField()
    public String address1;
    @Lob()
    @DbField()
    public String address2;
    @Lob()
    @DbField()
    public String address3;
    @Lob()
    @DbField()
    public String addressName;
    @DbField(type = "Date")
    public java.util.Calendar datePrinted;
    @DbField(type = "Date")
    public java.util.Calendar documentDate;
    @Lob()
    @DbField()
    public String faxNo;
    @Lob()
    @DbField()
    public String phoneNo;
    @Lob()
    @DbField()
    public String postCode;
    @DbField(length = 23)
    public String reference;
    @Lob()
    @DbField()
    public String standardText;

    public String getAdditionalDeliveryText() {
        return additionalDeliveryText.trim();
    }

    public void setAdditionalDeliveryText(String additionalDeliveryText) {
        this.additionalDeliveryText = additionalDeliveryText.trim();
    }

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

    public String getAddressName() {
        return addressName.trim();
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName.trim();
    }

    @SuppressWarnings("unchecked")
    @DbProperty()
    @OneToMany(relationshipType = ReferenceRelationshipType.PEER,
            updateMode = ReferenceUpdateMode.AUTOMATIC,
            inverse = "mySODocument")
    public LineItemArray<LineItem> getAllLineItems() {
        return (LineItemArray<LineItem>) EntityAccess.getReferenceProperty(this, "allLineItems");
    }

    public java.util.Calendar getDatePrinted() {
        return datePrinted;
    }

    public void setDatePrinted(java.util.Calendar datePrinted) {
        this.datePrinted = datePrinted;
    }

    public java.util.Calendar getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(java.util.Calendar documentDate) {
        this.documentDate = documentDate;
    }

    @DbProperty()
    public String getEmail() {
        return EntityAccess.getSLOBProperty(this, "email").trim();
    }

    public void setEmail(String email) {
        EntityAccess.setSLOBProperty(this, "email", email.trim());
    }

    public String getFaxNo() {
        return faxNo.trim();
    }

    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo.trim();
    }

    public String getPhoneNo() {
        return phoneNo.trim();
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo.trim();
    }

    public String getPostCode() {
        return postCode.trim();
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode.trim();
    }

    public String getReference() {
        return reference.trim();
    }

    public void setReference(String reference) {
        this.reference = reference.trim();
    }

    public String getStandardText() {
        return standardText.trim();
    }

    public void setStandardText(String standardText) {
        this.standardText = standardText.trim();
    }

    @DbProperty()
    public boolean getIsPrinted() {
        return EntityAccess.getBooleanProperty(this, "isPrinted");
    }

    public void setIsPrinted(boolean isPrinted) {
        EntityAccess.setBooleanProperty(this, "isPrinted", isPrinted);
    }
}
