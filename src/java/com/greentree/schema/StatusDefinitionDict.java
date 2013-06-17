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
    @DictionaryKey(key = "name")})
public class StatusDefinitionDict<StatusDefinition> extends MemberKeyDictionary<StatusDefinition> {

    public StatusDefinition getAtKey(String name) {
        return (StatusDefinition) EntityAccess.sendMsgGetReference(this, "getAtKey", name);
    }

    public StatusDefinition getAtKeyGeq(String name) {
        return (StatusDefinition) EntityAccess.sendMsgGetReference(this, "getAtKeyGeq", name);
    }

    public StatusDefinition getAtKeyGtr(String name) {
        return (StatusDefinition) EntityAccess.sendMsgGetReference(this, "getAtKeyGtr", name);
    }

    public StatusDefinition getAtKeyLeq(String name) {
        return (StatusDefinition) EntityAccess.sendMsgGetReference(this, "getAtKeyLeq", name);
    }

    public StatusDefinition getAtKeyLss(String name) {
        return (StatusDefinition) EntityAccess.sendMsgGetReference(this, "getAtKeyLss", name);
    }

    public void getIteratorKeys(Iterator iter, ByRef<String> name) {
        EntityAccess.sendMsg(this, "getIteratorKeys", name, iter);
    }

    public void startKeyGeq(Iterator iter, String name) {
        EntityAccess.sendMsg(this, "startKeyGeq", name, iter);
    }

    public void startKeyGtr(Iterator iter, String name) {
        EntityAccess.sendMsg(this, "startKeyGtr", name, iter);
    }

    public void startKeyLeq(Iterator iter, String name) {
        EntityAccess.sendMsg(this, "startKeyLeq", name, iter);
    }

    public void startKeyLss(Iterator iter, String name) {
        EntityAccess.sendMsg(this, "startKeyLss", name, iter);
    }

    public StatusDefinition putAtKey(StatusDefinition value, String name) {
        EntityAccess.sendMsg(this, "putAtKey", name, value);
        return value;
    }

    public void removeKey(String name) {
        EntityAccess.sendMsg(this, "removeKey", name);
    }

    public void removeKeyEntry(StatusDefinition value, String name) {
        EntityAccess.sendMsg(this, "removeKeyEntry", name, value);
    }

    public boolean includesKey(String name) {
        return EntityAccess.sendMsgGetBoolean(this, "includesKey", name);
    }

    public boolean includes(StatusDefinition element) {
        return EntityAccess.sendMsgGetBoolean(this, "includes", element);
    }
}