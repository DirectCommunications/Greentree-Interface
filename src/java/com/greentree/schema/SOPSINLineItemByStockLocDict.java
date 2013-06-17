/*
 * Copyright (C) 2013 Direct Communications
 * 
 * Licensed under the BSD License.
 */

package com.greentree.schema;

import com.jadeworld.jade.rootschema.MemberKeyDictionary;
import com.jadeworld.jade.entitymanager.EntityAccess;
import com.jadeworld.jade.rootschema.Iterator;
import com.jadeworld.jade.ByRef;
import com.jadeworld.jade.persistence.CollectionEntity;
import com.jadeworld.jade.persistence.DictionaryKey;

@SuppressWarnings("unchecked")
@CollectionEntity(duplicatesAllowed = true, keys = {
    @DictionaryKey(key = "myStockItem.code"),
    @DictionaryKey(key = "myLocation.fullPath")})
public class SOPSINLineItemByStockLocDict<SOPSINLineItem> extends MemberKeyDictionary<SOPSINLineItem> {

    public SOPSINLineItem getAtKey(String code, String fullPath) {
        return (SOPSINLineItem) EntityAccess.sendMsgGetReference(this, "getAtKey", code, fullPath);
    }

    public SOPSINLineItem getAtKeyGeq(String code, String fullPath) {
        return (SOPSINLineItem) EntityAccess.sendMsgGetReference(this, "getAtKeyGeq", code, fullPath);
    }

    public SOPSINLineItem getAtKeyGtr(String code, String fullPath) {
        return (SOPSINLineItem) EntityAccess.sendMsgGetReference(this, "getAtKeyGtr", code, fullPath);
    }

    public SOPSINLineItem getAtKeyLeq(String code, String fullPath) {
        return (SOPSINLineItem) EntityAccess.sendMsgGetReference(this, "getAtKeyLeq", code, fullPath);
    }

    public SOPSINLineItem getAtKeyLss(String code, String fullPath) {
        return (SOPSINLineItem) EntityAccess.sendMsgGetReference(this, "getAtKeyLss", code, fullPath);
    }

    public void getIteratorKeys(Iterator iter, ByRef<String> code, ByRef<String> fullPath) {
        EntityAccess.sendMsg(this, "getIteratorKeys", code, fullPath, iter);
    }

    public void startKeyGeq(Iterator iter, String code, String fullPath) {
        EntityAccess.sendMsg(this, "startKeyGeq", code, fullPath, iter);
    }

    public void startKeyGtr(Iterator iter, String code, String fullPath) {
        EntityAccess.sendMsg(this, "startKeyGtr", code, fullPath, iter);
    }

    public void startKeyLeq(Iterator iter, String code, String fullPath) {
        EntityAccess.sendMsg(this, "startKeyLeq", code, fullPath, iter);
    }

    public void startKeyLss(Iterator iter, String code, String fullPath) {
        EntityAccess.sendMsg(this, "startKeyLss", code, fullPath, iter);
    }

    public SOPSINLineItem putAtKey(SOPSINLineItem value, String code, String fullPath) {
        EntityAccess.sendMsg(this, "putAtKey", code, fullPath, value);
        return value;
    }

    public void removeKey(String code, String fullPath) {
        EntityAccess.sendMsg(this, "removeKey", code, fullPath);
    }

    public void removeKeyEntry(SOPSINLineItem value, String code, String fullPath) {
        EntityAccess.sendMsg(this, "removeKeyEntry", code, fullPath, value);
    }

    public boolean includesKey(String code, String fullPath) {
        return EntityAccess.sendMsgGetBoolean(this, "includesKey", code, fullPath);
    }

    public boolean includes(SOPSINLineItem element) {
        return EntityAccess.sendMsgGetBoolean(this, "includes", element);
    }
}