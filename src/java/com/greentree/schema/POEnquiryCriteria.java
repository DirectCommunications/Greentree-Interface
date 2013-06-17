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
import com.jadeworld.jade.persistence.ManyToMany;
import com.jadeworld.jade.persistence.ManyToOne;
import com.jadeworld.jade.persistence.ReferenceRelationshipType;
import com.jadeworld.jade.persistence.ReferenceUpdateMode;

@Entity()
public class POEnquiryCriteria extends com.jadeworld.jade.rootschema.Object {

    @SuppressWarnings("unchecked")
    @DbProperty()
    @ManyToMany(relationshipType = ReferenceRelationshipType.PEER,
            updateMode = ReferenceUpdateMode.MAN_AUTO,
            inverses = {"allPOEnquiryCriterias"})
    public StatusDefinitionDict<StatusDefinition> getAllStatuses() {
        return (StatusDefinitionDict<StatusDefinition>) EntityAccess.getReferenceProperty(this, "allStatuses");
    }
    @DbField(type = "Date")
    public java.util.Calendar expectedDateFrom;

    public java.util.Calendar getExpectedDateFrom() {
        return expectedDateFrom;
    }

    public void setExpectedDateFrom(java.util.Calendar expectedDateFrom) {
        this.expectedDateFrom = expectedDateFrom;
    }
    @DbField(type = "Date")
    public java.util.Calendar expectedDateTo;

    public java.util.Calendar getExpectedDateTo() {
        return expectedDateTo;
    }

    public void setExpectedDateTo(java.util.Calendar expectedDateTo) {
        this.expectedDateTo = expectedDateTo;
    }
    @DbField()
    public int focusOn;

    public int getFocusOn() {
        return focusOn;
    }

    public void setFocusOn(int focusOn) {
        this.focusOn = focusOn;
    }

    @DbProperty()
    @ManyToOne(relationshipType = ReferenceRelationshipType.PEER,
            updateMode = ReferenceUpdateMode.MANUAL, 
            inverses = {"allEnquiryCriterias"})
    public POControl getMyPOControl() {
        return (POControl) EntityAccess.getReferenceProperty(this, "myPOControl");
    }

    public void setMyPOControl(POControl myPOControl) {
        EntityAccess.setReferenceProperty(this, "myPOControl", myPOControl);
    }
    @Lob()
    @DbField()
    public String poReferenceFrom;

    public String getPoReferenceFrom() {
        return poReferenceFrom;
    }

    public void setPoReferenceFrom(String poReferenceFrom) {
        this.poReferenceFrom = poReferenceFrom;
    }
    @Lob()
    @DbField()
    public String poReferenceTo;

    public String getPoReferenceTo() {
        return poReferenceTo;
    }

    public void setPoReferenceTo(String poReferenceTo) {
        this.poReferenceTo = poReferenceTo;
    }
    @DbField(length = 20)
    public String reference;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
    @DbField()
    public int searchBy;

    public int getSearchBy() {
        return searchBy;
    }

    public void setSearchBy(int searchBy) {
        this.searchBy = searchBy;
    }
    @Lob()
    @DbField()
    public String supplierFrom;

    public String getSupplierFrom() {
        return supplierFrom;
    }

    public void setSupplierFrom(String supplierFrom) {
        this.supplierFrom = supplierFrom;
    }
    @Lob()
    @DbField()
    public String supplierTo;

    public String getSupplierTo() {
        return supplierTo;
    }

    public void setSupplierTo(String supplierTo) {
        this.supplierTo = supplierTo;
    }
}