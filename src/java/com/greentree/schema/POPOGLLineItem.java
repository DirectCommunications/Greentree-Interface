/*
 * Copyright (C) 2013 Direct Communications
 *
 * Licensed under the BSD License.
 */

package com.greentree.schema;

import com.jadeworld.jade.persistence.Entity;

@Entity()
public class POPOGLLineItem extends POPOLineItem {

    @Override
    public String toString() {
        return this.getQuantity().toString() + " x "
                + this.getStandardText();
    }
}
