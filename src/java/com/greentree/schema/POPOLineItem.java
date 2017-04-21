/*
 * Copyright (C) 2013 Direct Communications
 *
 * Licensed under the MIT License.
 */

package com.greentree.schema;

import com.jadeworld.jade.persistence.DbField;
import com.jadeworld.jade.persistence.Entity;

@Entity()
public class POPOLineItem extends LineItem {

    @DbField()
    public boolean isOutstanding;
    @DbField(type = "Decimal", length = 12, scale = 4)
    public java.math.BigDecimal qtyInvoiced;
    @DbField(type = "Decimal", length = 14, scale = 4)
    public java.math.BigDecimal qtyOutstanding;
    @DbField(type = "Decimal", length = 14, scale = 4)
    public java.math.BigDecimal qtyReceived;
    @DbField(type = "Decimal", length = 14, scale = 4)
    public java.math.BigDecimal qtyShipping;

    public boolean getIsOutstanding() {
        return isOutstanding;
    }

    public void setIsOutstanding(boolean isOutstanding) {
        this.isOutstanding = isOutstanding;
    }

    public java.math.BigDecimal getQtyInvoiced() {
        return qtyInvoiced;
    }

    public void setQtyInvoiced(java.math.BigDecimal qtyInvoiced) {
        this.qtyInvoiced = qtyInvoiced;
    }

    public java.math.BigDecimal getQtyOutstanding() {
        return qtyOutstanding;
    }

    public void setQtyOutstanding(java.math.BigDecimal qtyOutstanding) {
        this.qtyOutstanding = qtyOutstanding;
    }

    public java.math.BigDecimal getQtyReceived() {
        return qtyReceived;
    }

    public void setQtyReceived(java.math.BigDecimal qtyReceived) {
        this.qtyReceived = qtyReceived;
    }

    public java.math.BigDecimal getQtyShipping() {
        return qtyShipping;
    }

    public void setQtyShipping(java.math.BigDecimal qtyShipping) {
        this.qtyShipping = qtyShipping;
    }
}