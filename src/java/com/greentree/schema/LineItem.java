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
public class LineItem extends com.jadeworld.jade.rootschema.Object {

    @SuppressWarnings("unchecked")
    @DbProperty()
    @OneToMany()
    public RPRTTextLineDict<RPRTTextLine> getAllLinesOfText() {
        return (RPRTTextLineDict<RPRTTextLine>) EntityAccess.getReferenceProperty(this, "allLinesOfText");
    }

    @SuppressWarnings("unchecked")
    @DbProperty()
    @OneToMany(relationshipType=ReferenceRelationshipType.PEER,updateMode=ReferenceUpdateMode.MAN_AUTO,inverse="myLineItem")
    public  INSerialLotLineItemArray<INSerialLotLineItem> getAllSerialLotLineItems() {
        return (INSerialLotLineItemArray<INSerialLotLineItem>) EntityAccess.getReferenceProperty(this, "allSerialLotLineItems");
    }
    
    @DbProperty(type = "Decimal", length = 14, scale = 2)
    public java.math.BigDecimal getFcAmount() {
        return EntityAccess.getDecimalProperty(this, "fcAmount");
    }

    public void setFcAmount(java.math.BigDecimal fcAmount) {
        EntityAccess.setDecimalProperty(this, "fcAmount", fcAmount);
    }

    @DbProperty(type = "Decimal", length = 14, scale = 2)
    public java.math.BigDecimal getFcDiscount() {
        return EntityAccess.getDecimalProperty(this, "fcDiscount");
    }

    public void setFcDiscount(java.math.BigDecimal fcDiscount) {
        EntityAccess.setDecimalProperty(this, "fcDiscount", fcDiscount);
    }

    @DbProperty(type = "Decimal", length = 14, scale = 2)
    public java.math.BigDecimal getFcTaxAmount() {
        return EntityAccess.getDecimalProperty(this, "fcTaxAmount");
    }

    public void setFcTaxAmount(java.math.BigDecimal fcTaxAmount) {
        EntityAccess.setDecimalProperty(this, "fcTaxAmount", fcTaxAmount);
    }

    @DbProperty()
    public String getLineItemType() {
        return EntityAccess.getSLOBProperty(this, "lineItemType");
    }

    public void setLineItemType(String lineItemType) {
        EntityAccess.setSLOBProperty(this, "lineItemType", lineItemType);
    }

    @DbProperty()
    public int getLineNumber() {
        return EntityAccess.getIntegerProperty(this, "lineNumber");
    }

    public void setLineNumber(int lineNumber) {
        EntityAccess.setIntegerProperty(this, "lineNumber", lineNumber);
    }

    @DbProperty(type = "Decimal", length = 12, scale = 4)
    public java.math.BigDecimal getQuantity() {
        return EntityAccess.getDecimalProperty(this, "quantity");
    }

    public void setQuantity(java.math.BigDecimal quantity) {
        EntityAccess.setDecimalProperty(this, "quantity", quantity);
    }

    @DbProperty()
    public String getSerialLotInfoDisplay() {
        return EntityAccess.getSLOBProperty(this, "serialLotInfoDisplay");
    }

    public void setSerialLotInfoDisplay(String serialLotInfoDisplay) {
        EntityAccess.setSLOBProperty(this, "serialLotInfoDisplay", serialLotInfoDisplay);
    }

    @DbProperty()
    public String getSoPackingslipRef() {
        return EntityAccess.getSLOBProperty(this, "soPackingslipRef");
    }

    public void setSoPackingslipRef(String soPackingslipRef) {
        EntityAccess.setSLOBProperty(this, "soPackingslipRef", soPackingslipRef);
    }

    @DbProperty()
    public String getStandardText() {
        return EntityAccess.getSLOBProperty(this, "standardText");
    }

    public void setStandardText(String standardText) {
        EntityAccess.setSLOBProperty(this, "standardText", standardText);
    }
}