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
    @DictionaryKey(key = "uniqueKey")})
public class LineItemDictByUniqueKey<LineItem> extends MemberKeyDictionary<LineItem> {

    public LineItem getAtKey(String uniqueKey) {
        return (LineItem) EntityAccess.sendMsgGetReference(this, "getAtKey", uniqueKey);
    }

    public LineItem getAtKeyGeq(String uniqueKey) {
        return (LineItem) EntityAccess.sendMsgGetReference(this, "getAtKeyGeq", uniqueKey);
    }

    public LineItem getAtKeyGtr(String uniqueKey) {
        return (LineItem) EntityAccess.sendMsgGetReference(this, "getAtKeyGtr", uniqueKey);
    }

    public LineItem getAtKeyLeq(String uniqueKey) {
        return (LineItem) EntityAccess.sendMsgGetReference(this, "getAtKeyLeq", uniqueKey);
    }

    public LineItem getAtKeyLss(String uniqueKey) {
        return (LineItem) EntityAccess.sendMsgGetReference(this, "getAtKeyLss", uniqueKey);
    }

    public void getIteratorKeys(Iterator iter, ByRef<String> uniqueKey) {
        EntityAccess.sendMsg(this, "getIteratorKeys", uniqueKey, iter);
    }

    public void startKeyGeq(Iterator iter, String uniqueKey) {
        EntityAccess.sendMsg(this, "startKeyGeq", uniqueKey, iter);
    }

    public void startKeyGtr(Iterator iter, String uniqueKey) {
        EntityAccess.sendMsg(this, "startKeyGtr", uniqueKey, iter);
    }

    public void startKeyLeq(Iterator iter, String uniqueKey) {
        EntityAccess.sendMsg(this, "startKeyLeq", uniqueKey, iter);
    }

    public void startKeyLss(Iterator iter, String uniqueKey) {
        EntityAccess.sendMsg(this, "startKeyLss", uniqueKey, iter);
    }

    public LineItem putAtKey(LineItem value, String uniqueKey) {
        EntityAccess.sendMsg(this, "putAtKey", uniqueKey, value);
        return value;
    }

    public void removeKey(String uniqueKey) {
        EntityAccess.sendMsg(this, "removeKey", uniqueKey);
    }

    public void removeKeyEntry(LineItem value, String uniqueKey) {
        EntityAccess.sendMsg(this, "removeKeyEntry", uniqueKey, value);
    }

    public boolean includesKey(String uniqueKey) {
        return EntityAccess.sendMsgGetBoolean(this, "includesKey", uniqueKey);
    }

    public boolean includes(LineItem element) {
        return EntityAccess.sendMsgGetBoolean(this, "includes", element);
    }
}