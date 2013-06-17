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
import com.jadeworld.jade.persistence.DbProperty;
import com.jadeworld.jade.persistence.Entity;
import com.jadeworld.jade.persistence.ManyToOne;
import com.jadeworld.jade.persistence.OneToMany;
import com.jadeworld.jade.persistence.ReferenceRelationshipType;
import com.jadeworld.jade.persistence.ReferenceUpdateMode;

@SuppressWarnings("unchecked")
@CollectionEntity(keys = {
    @DictionaryKey(key = "reference")})
public class StandingTransactionDict<StandingTransaction> extends MemberKeyDictionary<StandingTransaction> {

    public StandingTransaction getAtKey(String reference) {
        return (StandingTransaction) EntityAccess.sendMsgGetReference(this, "getAtKey", reference);
    }

    public StandingTransaction getAtKeyGeq(String reference) {
        return (StandingTransaction) EntityAccess.sendMsgGetReference(this, "getAtKeyGeq", reference);
    }

    public StandingTransaction getAtKeyGtr(String reference) {
        return (StandingTransaction) EntityAccess.sendMsgGetReference(this, "getAtKeyGtr", reference);
    }

    public StandingTransaction getAtKeyLeq(String reference) {
        return (StandingTransaction) EntityAccess.sendMsgGetReference(this, "getAtKeyLeq", reference);
    }

    public StandingTransaction getAtKeyLss(String reference) {
        return (StandingTransaction) EntityAccess.sendMsgGetReference(this, "getAtKeyLss", reference);
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

    public StandingTransaction putAtKey(StandingTransaction value, String reference) {
        EntityAccess.sendMsg(this, "putAtKey", reference, value);
        return value;
    }

    public void removeKey(String reference) {
        EntityAccess.sendMsg(this, "removeKey", reference);
    }

    public void removeKeyEntry(StandingTransaction value, String reference) {
        EntityAccess.sendMsg(this, "removeKeyEntry", reference, value);
    }

    public boolean includesKey(String reference) {
        return EntityAccess.sendMsgGetBoolean(this, "includesKey", reference);
    }

    public boolean includes(StandingTransaction element) {
        return EntityAccess.sendMsgGetBoolean(this, "includes", element);
    }
}