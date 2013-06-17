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
public class StockItem extends com.jadeworld.jade.rootschema.Object {

    @DbProperty(length = 20)
    public String getCode() {
        return EntityAccess.getStringProperty(this, "code");
    }

    public void setCode(String code) {
        EntityAccess.setStringProperty(this, "code", code);
    }
}