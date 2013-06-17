/*
 * Copyright (C) 2013 Direct Communications
 * 
 * Licensed under the BSD License.
 */

package com.greentree.schema;

import com.jadeworld.jade.entitymanager.EntityAccess;
import com.jadeworld.jade.persistence.DbProperty;
import com.jadeworld.jade.persistence.Entity;

@Entity()
public class RPRTTextLine extends com.jadeworld.jade.rootschema.Object {

    @DbProperty()
    public int getLineNumber() {
        return EntityAccess.getIntegerProperty(this, "lineNumber");
    }

    public void setLineNumber(int lineNumber) {
        EntityAccess.setIntegerProperty(this, "lineNumber", lineNumber);
    }

    @DbProperty(length = 200)
    public String getLineOfText() {
        return EntityAccess.getStringProperty(this, "lineOfText");
    }

    public void setLineOfText(String lineOfText) {
        EntityAccess.setStringProperty(this, "lineOfText", lineOfText);
    }
}