/*
 * Copyright (C) 2013 Direct Communications
 *
 * Licensed under the MIT License.
 */

package com.greentree.schema;

import com.jadeworld.jade.persistence.Entity;
import com.jadeworld.jade.persistence.DbField;

@Entity()
public abstract class SalesOrderLine extends LineItem {

    @DbField(length = 30)
    public String reference;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}