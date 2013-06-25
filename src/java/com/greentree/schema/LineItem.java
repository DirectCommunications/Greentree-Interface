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

@Entity()
public class LineItem extends com.jadeworld.jade.rootschema.Object {

    @Lob()
    @DbField()
    public String codeDescription;
    @Lob()
    @DbField()
    public String codeString;

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
        return EntityAccess.getDecimalProperty(this, "quantity");
    }

    public void setQuantity(java.math.BigDecimal quantity) {
        EntityAccess.setDecimalProperty(this, "quantity", quantity);
    }

    @DbProperty()
    public String getStandardText() {
        return EntityAccess.getSLOBProperty(this, "standardText").trim();
    }

    public void setStandardText(String standardText) {
        EntityAccess.setSLOBProperty(this, "standardText", standardText.trim());
    }
}
