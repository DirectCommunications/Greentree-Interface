/*
 * Copyright (C) 2013 Direct Communications
 * 
 * Licensed under the BSD License.
 */

package com.greentree.schema;

import com.jadeworld.jade.rootschema.MemberKeyDictionary;
import com.jadeworld.jade.rootschema.Iterator;
import com.jadeworld.jade.ByRef;
import com.jadeworld.jade.entitymanager.EntityAccess;
import com.jadeworld.jade.persistence.CollectionEntity;
import com.jadeworld.jade.persistence.DictionaryKey;


@SuppressWarnings("unchecked")
@CollectionEntity(keys = {
    @DictionaryKey(key = "mySourceObject"),
    @DictionaryKey(key = "lineNumber")})
public class RPRTTextLineDict<RPRTTextLine> extends MemberKeyDictionary<RPRTTextLine> {

    public RPRTTextLine getAtKey(Object mySourceObject, int lineNumber) {
        return (RPRTTextLine) EntityAccess.sendMsgGetReference(this, "getAtKey", mySourceObject, lineNumber);
    }

    public RPRTTextLine getAtKeyGeq(Object mySourceObject, int lineNumber) {
        return (RPRTTextLine) EntityAccess.sendMsgGetReference(this, "getAtKeyGeq", mySourceObject, lineNumber);
    }

    public RPRTTextLine getAtKeyGtr(Object mySourceObject, int lineNumber) {
        return (RPRTTextLine) EntityAccess.sendMsgGetReference(this, "getAtKeyGtr", mySourceObject, lineNumber);
    }

    public RPRTTextLine getAtKeyLeq(Object mySourceObject, int lineNumber) {
        return (RPRTTextLine) EntityAccess.sendMsgGetReference(this, "getAtKeyLeq", mySourceObject, lineNumber);
    }

    public RPRTTextLine getAtKeyLss(Object mySourceObject, int lineNumber) {
        return (RPRTTextLine) EntityAccess.sendMsgGetReference(this, "getAtKeyLss", mySourceObject, lineNumber);
    }

    public void getIteratorKeys(Iterator iter, ByRef<Object> mySourceObject, ByRef<Integer> lineNumber) {
        EntityAccess.sendMsg(this, "getIteratorKeys", mySourceObject, lineNumber, iter);
    }

    public void startKeyGeq(Iterator iter, Object mySourceObject, int lineNumber) {
        EntityAccess.sendMsg(this, "startKeyGeq", mySourceObject, lineNumber, iter);
    }

    public void startKeyGtr(Iterator iter, Object mySourceObject, int lineNumber) {
        EntityAccess.sendMsg(this, "startKeyGtr", mySourceObject, lineNumber, iter);
    }

    public void startKeyLeq(Iterator iter, Object mySourceObject, int lineNumber) {
        EntityAccess.sendMsg(this, "startKeyLeq", mySourceObject, lineNumber, iter);
    }

    public void startKeyLss(Iterator iter, Object mySourceObject, int lineNumber) {
        EntityAccess.sendMsg(this, "startKeyLss", mySourceObject, lineNumber, iter);
    }

    public RPRTTextLine putAtKey(RPRTTextLine value, Object mySourceObject, int lineNumber) {
        EntityAccess.sendMsg(this, "putAtKey", mySourceObject, lineNumber, value);
        return value;
    }

    public void removeKey(Object mySourceObject, int lineNumber) {
        EntityAccess.sendMsg(this, "removeKey", mySourceObject, lineNumber);
    }

    public void removeKeyEntry(RPRTTextLine value, Object mySourceObject, int lineNumber) {
        EntityAccess.sendMsg(this, "removeKeyEntry", mySourceObject, lineNumber, value);
    }

    public boolean includesKey(Object mySourceObject, int lineNumber) {
        return EntityAccess.sendMsgGetBoolean(this, "includesKey", mySourceObject, lineNumber);
    }

    public boolean includes(RPRTTextLine element) {
        return EntityAccess.sendMsgGetBoolean(this, "includes", element);
    }
}