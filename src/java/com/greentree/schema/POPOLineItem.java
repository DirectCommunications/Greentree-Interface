/*
 * Copyright (C) 2013 Direct Communications
 * 
 * Licensed under the BSD License.
 */

package com.greentree.schema;

import com.jadeworld.jade.persistence.DbField;
import com.jadeworld.jade.persistence.Entity;

@Entity()
public class POPOLineItem extends LineItem {

    @DbField(type = "Decimal", length = 14, scale = 2)
    public java.math.BigDecimal fcOutstandingNetValue;

    public java.math.BigDecimal getFcOutstandingNetValue() {
        return fcOutstandingNetValue;
    }

    public void setFcOutstandingNetValue(java.math.BigDecimal fcOutstandingNetValue) {
        this.fcOutstandingNetValue = fcOutstandingNetValue;
    }
    
    @DbField(type = "Decimal", length = 14, scale = 0)
    public java.math.BigDecimal fcReceivedNetValue;

    public java.math.BigDecimal getFcReceivedNetValue() {
        return fcReceivedNetValue;
    }

    public void setFcReceivedNetValue(java.math.BigDecimal fcReceivedNetValue) {
        this.fcReceivedNetValue = fcReceivedNetValue;
    }
    
    @DbField()
    public boolean isOutstanding;

    public boolean getIsOutstanding() {
        return isOutstanding;
    }

    public void setIsOutstanding(boolean isOutstanding) {
        this.isOutstanding = isOutstanding;
    }
    
    @DbField(type = "Decimal", length = 12, scale = 4)
    public java.math.BigDecimal qtyCancelled;

    public java.math.BigDecimal getQtyCancelled() {
        return qtyCancelled;
    }

    public void setQtyCancelled(java.math.BigDecimal qtyCancelled) {
        this.qtyCancelled = qtyCancelled;
    }
    
    @DbField(type = "Decimal", length = 12, scale = 4)
    public java.math.BigDecimal qtyInvoiced;

    public java.math.BigDecimal getQtyInvoiced() {
        return qtyInvoiced;
    }

    public void setQtyInvoiced(java.math.BigDecimal qtyInvoiced) {
        this.qtyInvoiced = qtyInvoiced;
    }
    
    @DbField(type = "Decimal", length = 14, scale = 4)
    public java.math.BigDecimal qtyOutstanding;

    public java.math.BigDecimal getQtyOutstanding() {
        return qtyOutstanding;
    }

    public void setQtyOutstanding(java.math.BigDecimal qtyOutstanding) {
        this.qtyOutstanding = qtyOutstanding;
    }
    
    @DbField(type = "Decimal", length = 14, scale = 4)
    public java.math.BigDecimal qtyReceived;

    public java.math.BigDecimal getQtyReceived() {
        return qtyReceived;
    }

    public void setQtyReceived(java.math.BigDecimal qtyReceived) {
        this.qtyReceived = qtyReceived;
    }
    
    @DbField(type = "Decimal", length = 14, scale = 4)
    public java.math.BigDecimal qtyShipping;

    public java.math.BigDecimal getQtyShipping() {
        return qtyShipping;
    }

    public void setQtyShipping(java.math.BigDecimal qtyShipping) {
        this.qtyShipping = qtyShipping;
    }
    
    @DbField(type = "Decimal", length = 14, scale = 4)
    public java.math.BigDecimal rwOrderQty;

    public java.math.BigDecimal getRwOrderQty() {
        return rwOrderQty;
    }

    public void setRwOrderQty(java.math.BigDecimal rwOrderQty) {
        this.rwOrderQty = rwOrderQty;
    }
}