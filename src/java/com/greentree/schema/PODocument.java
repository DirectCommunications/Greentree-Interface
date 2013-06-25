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
public class PODocument extends com.jadeworld.jade.rootschema.Object {

    @DbField(type = "Date")
    public java.util.Calendar documentDate;
    @DbField(type = "Decimal", length = 12, scale = 2)
    public java.math.BigDecimal fcDiscount;
    @DbField(type = "Decimal", length = 12, scale = 2)
    public java.math.BigDecimal fcNetAmount;
    @DbField(type = "Decimal", length = 12, scale = 2)
    public java.math.BigDecimal fcTaxAmount;
    @DbField(length = 20)
    public String reference;
    @DbField()
    public boolean isPrinted;
    @Lob()
    @DbField()
    public String standardText;

    public java.util.Calendar getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(java.util.Calendar documentDate) {
        this.documentDate = documentDate;
    }

    public java.math.BigDecimal getFcDiscount() {
        return fcDiscount;
    }

    public void setFcDiscount(java.math.BigDecimal fcDiscount) {
        this.fcDiscount = fcDiscount;
    }

    public java.math.BigDecimal getFcNetAmount() {
        return fcNetAmount;
    }

    public void setFcNetAmount(java.math.BigDecimal fcNetAmount) {
        this.fcNetAmount = fcNetAmount;
    }

    public java.math.BigDecimal getFcTaxAmount() {
        return fcTaxAmount;
    }

    public void setFcTaxAmount(java.math.BigDecimal fcTaxAmount) {
        this.fcTaxAmount = fcTaxAmount;
    }

    public boolean getIsPrinted() {
        return isPrinted;
    }

    public void setIsPrinted(boolean isPrinted) {
        this.isPrinted = isPrinted;
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

    @SuppressWarnings("unchecked")
    @DbProperty()
    @OneToMany(relationshipType = ReferenceRelationshipType.PEER,
            updateMode = ReferenceUpdateMode.AUTOMATIC,
            inverse = "myPODocument")
    public LineItemArray<LineItem> getAllLineItems() {
        return (LineItemArray<LineItem>) EntityAccess.getReferenceProperty(this, "allLineItems");
    }
}
