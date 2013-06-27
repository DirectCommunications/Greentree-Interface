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
import com.jadeworld.jade.persistence.Lob;
import com.jadeworld.jade.persistence.ManyToOne;
import com.jadeworld.jade.persistence.ReferenceRelationshipType;
import com.jadeworld.jade.persistence.ReferenceUpdateMode;

@Entity()
public class LineItem extends com.jadeworld.jade.rootschema.Object {

    @Lob()
    @DbField()
    public String codeDescription;
    @Lob()
    @DbField()
    public String codeString;
    @DbField(type = "Decimal", length = 14, scale = 2)
    public java.math.BigDecimal lcAmount;
    @DbField(type = "Decimal", length = 14, scale = 2)
    public java.math.BigDecimal lcTaxAmount;
    @DbField(type = "Decimal", length = 12, scale = 4)
    public java.math.BigDecimal quantity;
    @DbField(type = "Decimal", length = 14, scale = 4)
    public java.math.BigDecimal unitPrice;

    public String getCodeDescription() {
        return codeDescription.trim();
    }

    public void setCodeDescription(String codeDescription) {
        this.codeDescription = codeDescription.trim();
    }

    public String getCodeString() {
        return codeString.trim();
    }

    public void setCodeString(String codeString) {
        this.codeString = codeString.trim();
    }

    public java.math.BigDecimal getLcAmount() {
        return lcAmount;
    }

    public void setLcAmount(java.math.BigDecimal lcAmount) {
        this.lcAmount = lcAmount;
    }

    public java.math.BigDecimal getLcTaxAmount() {
        return lcTaxAmount;
    }

    public void setLcTaxAmount(java.math.BigDecimal lcTaxAmount) {
        this.lcTaxAmount = lcTaxAmount;
    }

    public PODocument getMyPODocument() {
        return (PODocument) EntityAccess.sendMsgGetReference(this, "getMyPODocument");
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
        return quantity;
    }

    public void setQuantity(java.math.BigDecimal quantity) {
        this.quantity = quantity;
    }

    public java.math.BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(java.math.BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    @DbProperty()
    public String getStandardText() {
        return EntityAccess.getSLOBProperty(this, "standardText").trim();
    }

    public void setStandardText(String standardText) {
        EntityAccess.setSLOBProperty(this, "standardText", standardText.trim());
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

    @Override
    public String toString() {
        String result = "Line: " + this.getLineNumber() + " ";
        result += "Qty: " + this.getQuantity() + " ";
        result += "Code: " + this.getCodeString() + " ";
        result += "Code Description: " + this.getCodeDescription() + " ";
        result += "Price: " + this.getUnitPrice() + " ";
        result += "Total Tax: " + this.getLcTaxAmount() + " ";
        result += "Total: " + this.getLcAmount() + " ";
        if (!this.getStandardText().isEmpty()) {
            result += "Narration: " + this.getStandardText();
        }

        return result;
    }
}
