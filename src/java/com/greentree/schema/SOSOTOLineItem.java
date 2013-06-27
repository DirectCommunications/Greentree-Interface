/*
 * Copyright (C) 2013 Direct Communications
 *
 * Licensed under the BSD License.
 */

package com.greentree.schema;

import com.jadeworld.jade.persistence.Entity;

/**
 * Handles text only line items for sales orders.
 */
@Entity()
public class SOSOTOLineItem extends SOSOLineItem {

    @Override
    public String toString() {
        return "Line: " + this.getLineNumber() + " " + this.getStandardText();
    }
}