/*
 * Copyright (C) 2013 Direct Communications
 *
 * Licensed under the MIT License.
 */

package com.greentree.schema;

import com.jadeworld.jade.ByRef;
import com.jadeworld.jade.entitymanager.EntityAccess;
import com.jadeworld.jade.persistence.CollectionEntity;
import com.jadeworld.jade.persistence.DictionaryKey;
import com.jadeworld.jade.rootschema.MemberKeyDictionary;
import java.util.Iterator;

@CollectionEntity(keys = {
    @DictionaryKey(key = "reference")})
public class SODocumentByReferenceDict<SODocument> extends MemberKeyDictionary<SODocument> {

    public SODocument getAtKey(String reference) {
        return (SODocument) EntityAccess.sendMsgGetReference(this,
                "getAtKey", reference);
    }

    public SODocument getAtKeyGeq(String reference) {
        return (SODocument) EntityAccess.sendMsgGetReference(this,
                "getAtKeyGeq", reference);
    }

    public SODocument getAtKeyGtr(String reference) {
        return (SODocument) EntityAccess.sendMsgGetReference(this,
                "getAtKeyGtr", reference);
    }

    public SODocument getAtKeyLeq(String reference) {
        return (SODocument) EntityAccess.sendMsgGetReference(this,
                "getAtKeyLeq", reference);
    }

    public SODocument getAtKeyLss(String reference) {
        return (SODocument) EntityAccess.sendMsgGetReference(this,
                "getAtKeyLss", reference);
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

    public SODocument putAtKey(SODocument value, String reference) {
        EntityAccess.sendMsg(this, "putAtKey", reference, value);
        return value;
    }

    public void removeKey(String reference) {
        EntityAccess.sendMsg(this, "removeKey", reference);
    }

    public void removeKeyEntry(SODocument value, String reference) {
        EntityAccess.sendMsg(this, "removeKeyEntry", reference, value);
    }

    public boolean includesKey(String reference) {
        return EntityAccess.sendMsgGetBoolean(this, "includesKey", reference);
    }

    @Override
    public boolean includes(SODocument element) {
        return EntityAccess.sendMsgGetBoolean(this, "includes", element);
    }
}