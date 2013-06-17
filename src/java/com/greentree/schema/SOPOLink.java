/*
 * Copyright (C) 2013 Direct Communications
 * 
 * Licensed under the BSD License.
 */

package com.greentree.schema;

import com.jadeworld.jade.persistence.DbField;
import com.jadeworld.jade.persistence.DbProperty;
import com.jadeworld.jade.persistence.Entity;
import com.jadeworld.jade.persistence.ReferenceRelationshipType;
import com.jadeworld.jade.persistence.ReferenceUpdateMode;
import com.jadeworld.jade.entitymanager.EntityAccess;
import com.jadeworld.jade.persistence.ManyToOne;

@Entity()
public class SOPOLink extends com.jadeworld.jade.rootschema.Object {

    @DbField()
    public boolean isExceptLink;

    public boolean getIsExceptLink() {
        return isExceptLink;
    }

    public void setIsExceptLink(boolean isExceptLink) {
        this.isExceptLink = isExceptLink;
    }
    
    @DbField(type = "Decimal", length = 14, scale = 4)
    public java.math.BigDecimal linkedPOQty;

    public java.math.BigDecimal getLinkedPOQty() {
        return linkedPOQty;
    }

    public void setLinkedPOQty(java.math.BigDecimal linkedPOQty) {
        this.linkedPOQty = linkedPOQty;
    }
    
    @DbField(type = "Decimal", length = 14, scale = 4)
    public java.math.BigDecimal linkedSOQty;

    public java.math.BigDecimal getLinkedSOQty() {
        return linkedSOQty;
    }

    public void setLinkedSOQty(java.math.BigDecimal linkedSOQty) {
        this.linkedSOQty = linkedSOQty;
    }

    @DbProperty()
    @ManyToOne(relationshipType = ReferenceRelationshipType.PEER,
            updateMode = ReferenceUpdateMode.MAN_AUTO,
            inverses = {"allSOPOLinks"})
    public POPOINLineItem getMyPOLineItem() {
        return (POPOINLineItem) EntityAccess.getReferenceProperty(this, "myPOLineItem");
    }

    public void setMyPOLineItem(POPOINLineItem myPOLineItem) {
        EntityAccess.setReferenceProperty(this, "myPOLineItem", myPOLineItem);
    }

    @DbProperty()
    @ManyToOne(relationshipType = ReferenceRelationshipType.CHILD, updateMode = ReferenceUpdateMode.MAN_AUTO, inverses = {"allSOPOLinks"})
    public SOSOINLineItem getMySOLineItem() {
        return (SOSOINLineItem) EntityAccess.getReferenceProperty(this, "mySOLineItem");
    }

    public void setMySOLineItem(SOSOINLineItem mySOLineItem) {
        EntityAccess.setReferenceProperty(this, "mySOLineItem", mySOLineItem);
    }
    @DbField(type = "Decimal", length = 14, scale = 4)
    public java.math.BigDecimal poQtyTxfToPS;

    public java.math.BigDecimal getPoQtyTxfToPS() {
        return poQtyTxfToPS;
    }

    public void setPoQtyTxfToPS(java.math.BigDecimal poQtyTxfToPS) {
        this.poQtyTxfToPS = poQtyTxfToPS;
    }
    
    @DbField(type = "Decimal", length = 14, scale = 4)
    public java.math.BigDecimal releasedPOQty;

    public java.math.BigDecimal getReleasedPOQty() {
        return releasedPOQty;
    }

    public void setReleasedPOQty(java.math.BigDecimal releasedPOQty) {
        this.releasedPOQty = releasedPOQty;
    }
    
    @DbField(type = "Decimal", length = 14, scale = 4)
    public java.math.BigDecimal releasedSOQty;

    public java.math.BigDecimal getReleasedSOQty() {
        return releasedSOQty;
    }

    public void setReleasedSOQty(java.math.BigDecimal releasedSOQty) {
        this.releasedSOQty = releasedSOQty;
    }
}