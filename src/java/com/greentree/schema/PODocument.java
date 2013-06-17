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
import com.jadeworld.jade.persistence.ManyToOne;
import com.jadeworld.jade.persistence.OneToMany;
import com.jadeworld.jade.persistence.ReferenceRelationshipType;
import com.jadeworld.jade.persistence.ReferenceUpdateMode;

@Entity()
public class PODocument extends com.jadeworld.jade.rootschema.Object {

    @SuppressWarnings("unchecked")
    @DbProperty()
    @OneToMany(relationshipType = ReferenceRelationshipType.PEER,
            updateMode = ReferenceUpdateMode.AUTOMATIC,
            inverse = "myPODocument")
    public LineItemArray<LineItem> getAllLineItems() {
        return (LineItemArray<LineItem>) EntityAccess.getReferenceProperty(this, "allLineItems");
    }

    @SuppressWarnings("unchecked")
    @DbProperty()
    @OneToMany(relationshipType = ReferenceRelationshipType.PEER, 
            updateMode = ReferenceUpdateMode.AUTOMATIC, 
            inverse = "myPODocument")
    public LineItemDictByUniqueKey<LineItem> getAllLineItemsByUniqueKey() {
        return (LineItemDictByUniqueKey<LineItem>) EntityAccess.getReferenceProperty(this, "allLineItemsByUniqueKey");
    }
    @DbField(type = "Date")
    public java.util.Calendar documentDate;

    public java.util.Calendar getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(java.util.Calendar documentDate) {
        this.documentDate = documentDate;
    }
    @DbField(type = "Decimal", length = 12, scale = 2)
    public java.math.BigDecimal fcDiscount;

    public java.math.BigDecimal getFcDiscount() {
        return fcDiscount;
    }

    public void setFcDiscount(java.math.BigDecimal fcDiscount) {
        this.fcDiscount = fcDiscount;
    }
    @DbField(type = "Decimal", length = 12, scale = 2)
    public java.math.BigDecimal fcNetAmount;

    public java.math.BigDecimal getFcNetAmount() {
        return fcNetAmount;
    }

    public void setFcNetAmount(java.math.BigDecimal fcNetAmount) {
        this.fcNetAmount = fcNetAmount;
    }
    @DbField(type = "Decimal", length = 12, scale = 2)
    public java.math.BigDecimal fcTaxAmount;

    public java.math.BigDecimal getFcTaxAmount() {
        return fcTaxAmount;
    }

    public void setFcTaxAmount(java.math.BigDecimal fcTaxAmount) {
        this.fcTaxAmount = fcTaxAmount;
    }
    @DbField()
    public boolean isPrinted;

    public boolean getIsPrinted() {
        return isPrinted;
    }

    public void setIsPrinted(boolean isPrinted) {
        this.isPrinted = isPrinted;
    }

    @DbProperty()
    @ManyToOne(relationshipType = ReferenceRelationshipType.PEER,
            updateMode = ReferenceUpdateMode.MANUAL,
            inverses = {"allPODocuments"})
    public POStatusDefinition getMyStatus() {
        return (POStatusDefinition) EntityAccess.getReferenceProperty(this, "myStatus");
    }

    public void setMyStatus(POStatusDefinition myStatus) {
        EntityAccess.setReferenceProperty(this, "myStatus", myStatus);
    }
    @DbField(length = 20)
    public String reference;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
    @Lob()
    @DbField()
    public String standardText;

    public String getStandardText() {
        return standardText;
    }

    public void setStandardText(String standardText) {
        this.standardText = standardText;
    }
}