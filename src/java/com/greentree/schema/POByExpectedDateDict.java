/*
 * Copyright (C) 2013 Direct Communications
 * 
 * Licensed under the BSD License.
 */
package com.greentree.schema;

import com.jadeworld.jade.ByRef;
import com.jadeworld.jade.entitymanager.EntityAccess;
import com.jadeworld.jade.persistence.CollectionEntity;
import com.jadeworld.jade.persistence.DictionaryKey;
import com.jadeworld.jade.rootschema.Iterator;
import com.jadeworld.jade.rootschema.MemberKeyDictionary;

@SuppressWarnings("unchecked")
@CollectionEntity(duplicatesAllowed = true, keys = {
    @DictionaryKey(key = "expectedDate")})
public class POByExpectedDateDict<POPurchaseOrder> extends MemberKeyDictionary<POPurchaseOrder> {

    public POPurchaseOrder getAtKey(java.util.Calendar expectedDate) {
        return (POPurchaseOrder) EntityAccess.sendMsgGetReference(this, "getAtKey", expectedDate);
    }

    public POPurchaseOrder getAtKeyGeq(java.util.Calendar expectedDate) {
        return (POPurchaseOrder) EntityAccess.sendMsgGetReference(this, "getAtKeyGeq", expectedDate);
    }

    public POPurchaseOrder getAtKeyGtr(java.util.Calendar expectedDate) {
        return (POPurchaseOrder) EntityAccess.sendMsgGetReference(this, "getAtKeyGtr", expectedDate);
    }

    public POPurchaseOrder getAtKeyLeq(java.util.Calendar expectedDate) {
        return (POPurchaseOrder) EntityAccess.sendMsgGetReference(this, "getAtKeyLeq", expectedDate);
    }

    public POPurchaseOrder getAtKeyLss(java.util.Calendar expectedDate) {
        return (POPurchaseOrder) EntityAccess.sendMsgGetReference(this, "getAtKeyLss", expectedDate);
    }

    public void getIteratorKeys(Iterator iter, ByRef<java.util.Calendar> expectedDate) {
        EntityAccess.sendMsg(this, "getIteratorKeys", expectedDate, iter);
    }

    public void startKeyGeq(Iterator iter, java.util.Calendar expectedDate) {
        EntityAccess.sendMsg(this, "startKeyGeq", expectedDate, iter);
    }

    public void startKeyGtr(Iterator iter, java.util.Calendar expectedDate) {
        EntityAccess.sendMsg(this, "startKeyGtr", expectedDate, iter);
    }

    public void startKeyLeq(Iterator iter, java.util.Calendar expectedDate) {
        EntityAccess.sendMsg(this, "startKeyLeq", expectedDate, iter);
    }

    public void startKeyLss(Iterator iter, java.util.Calendar expectedDate) {
        EntityAccess.sendMsg(this, "startKeyLss", expectedDate, iter);
    }

    public POPurchaseOrder putAtKey(POPurchaseOrder value, java.util.Calendar expectedDate) {
        EntityAccess.sendMsg(this, "putAtKey", expectedDate, value);
        return value;
    }

    public void removeKey(java.util.Calendar expectedDate) {
        EntityAccess.sendMsg(this, "removeKey", expectedDate);
    }

    public void removeKeyEntry(POPurchaseOrder value, java.util.Calendar expectedDate) {
        EntityAccess.sendMsg(this, "removeKeyEntry", expectedDate, value);
    }

    public boolean includesKey(java.util.Calendar expectedDate) {
        return EntityAccess.sendMsgGetBoolean(this, "includesKey", expectedDate);
    }

    public boolean includes(POPurchaseOrder element) {
        return EntityAccess.sendMsgGetBoolean(this, "includes", element);
    }
}