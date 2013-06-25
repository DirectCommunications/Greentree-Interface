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
@CollectionEntity(keys = {
    @DictionaryKey(key = "reference")})
public class POByReferenceDict<PODocument> extends MemberKeyDictionary<PODocument> {

    public PODocument getAtKey(String reference) {
        return (PODocument) EntityAccess.sendMsgGetReference(this, "getAtKey", reference);
    }

    public PODocument getAtKeyGeq(String reference) {
        return (PODocument) EntityAccess.sendMsgGetReference(this, "getAtKeyGeq", reference);
    }

    public PODocument getAtKeyGtr(String reference) {
        return (PODocument) EntityAccess.sendMsgGetReference(this, "getAtKeyGtr", reference);
    }

    public PODocument getAtKeyLeq(String reference) {
        return (PODocument) EntityAccess.sendMsgGetReference(this, "getAtKeyLeq", reference);
    }

    public PODocument getAtKeyLss(String reference) {
        return (PODocument) EntityAccess.sendMsgGetReference(this, "getAtKeyLss", reference);
    }

    public void getIteratorKeys(Iterator iter, ByRef<String> reference) {
        EntityAccess.sendMsg(this, "getIteratorKeys", reference, iter);
    }

    public void startKeyGeq(Iterator iter, String reference) {
        EntityAccess.sendMsg(this, "startKeyGeq", reference, iter);
    }

    public void startKeyGtr(Iterator iter, String reference) {
        EntityAccess.sendMsg(this, "startKeyGtr", reference, iter);
    }

    public void startKeyLeq(Iterator iter, String reference) {
        EntityAccess.sendMsg(this, "startKeyLeq", reference, iter);
    }

    public void startKeyLss(Iterator iter, String reference) {
        EntityAccess.sendMsg(this, "startKeyLss", reference, iter);
    }

    public PODocument putAtKey(PODocument value, String reference) {
        EntityAccess.sendMsg(this, "putAtKey", reference, value);
        return value;
    }

    public void removeKey(String reference) {
        EntityAccess.sendMsg(this, "removeKey", reference);
    }

    public void removeKeyEntry(PODocument value, String reference) {
        EntityAccess.sendMsg(this, "removeKeyEntry", reference, value);
    }

    public boolean includesKey(String reference) {
        return EntityAccess.sendMsgGetBoolean(this, "includesKey", reference);
    }

    public boolean includes(PODocument element) {
        return EntityAccess.sendMsgGetBoolean(this, "includes", element);
    }
}