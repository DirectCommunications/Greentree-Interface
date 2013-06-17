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
@CollectionEntity(keys = {
    @DictionaryKey(key = "myPurchaseOrder.reference"),
    @DictionaryKey(key = "customerCode"),
    @DictionaryKey(key = "packingSlipNumber"),
    @DictionaryKey(key = "date"),
    @DictionaryKey(key = "isPrinted")})
public class POReleaseSOLinkInfoDict<POReleaseSOLinkInfo> extends MemberKeyDictionary<POReleaseSOLinkInfo> {

    public POReleaseSOLinkInfo getAtKey(String reference, String customerCode, String packingSlipNumber, java.util.Calendar date, boolean isPrinted) {
        return (POReleaseSOLinkInfo) EntityAccess.sendMsgGetReference(this, "getAtKey", reference, customerCode, packingSlipNumber, date, isPrinted);
    }

    public POReleaseSOLinkInfo getAtKeyGeq(String reference, String customerCode, String packingSlipNumber, java.util.Calendar date, boolean isPrinted) {
        return (POReleaseSOLinkInfo) EntityAccess.sendMsgGetReference(this, "getAtKeyGeq", reference, customerCode, packingSlipNumber, date, isPrinted);
    }

    public POReleaseSOLinkInfo getAtKeyGtr(String reference, String customerCode, String packingSlipNumber, java.util.Calendar date, boolean isPrinted) {
        return (POReleaseSOLinkInfo) EntityAccess.sendMsgGetReference(this, "getAtKeyGtr", reference, customerCode, packingSlipNumber, date, isPrinted);
    }

    public POReleaseSOLinkInfo getAtKeyLeq(String reference, String customerCode, String packingSlipNumber, java.util.Calendar date, boolean isPrinted) {
        return (POReleaseSOLinkInfo) EntityAccess.sendMsgGetReference(this, "getAtKeyLeq", reference, customerCode, packingSlipNumber, date, isPrinted);
    }

    public POReleaseSOLinkInfo getAtKeyLss(String reference, String customerCode, String packingSlipNumber, java.util.Calendar date, boolean isPrinted) {
        return (POReleaseSOLinkInfo) EntityAccess.sendMsgGetReference(this, "getAtKeyLss", reference, customerCode, packingSlipNumber, date, isPrinted);
    }

    public void getIteratorKeys(Iterator iter, ByRef<String> reference, ByRef<String> customerCode, ByRef<String> packingSlipNumber, ByRef<java.util.Calendar> date, ByRef<Boolean> isPrinted) {
        EntityAccess.sendMsg(this, "getIteratorKeys", reference, customerCode, packingSlipNumber, date, isPrinted, iter);
    }

    public void startKeyGeq(Iterator iter, String reference, String customerCode, String packingSlipNumber, java.util.Calendar date, boolean isPrinted) {
        EntityAccess.sendMsg(this, "startKeyGeq", reference, customerCode, packingSlipNumber, date, isPrinted, iter);
    }

    public void startKeyGtr(Iterator iter, String reference, String customerCode, String packingSlipNumber, java.util.Calendar date, boolean isPrinted) {
        EntityAccess.sendMsg(this, "startKeyGtr", reference, customerCode, packingSlipNumber, date, isPrinted, iter);
    }

    public void startKeyLeq(Iterator iter, String reference, String customerCode, String packingSlipNumber, java.util.Calendar date, boolean isPrinted) {
        EntityAccess.sendMsg(this, "startKeyLeq", reference, customerCode, packingSlipNumber, date, isPrinted, iter);
    }

    public void startKeyLss(Iterator iter, String reference, String customerCode, String packingSlipNumber, java.util.Calendar date, boolean isPrinted) {
        EntityAccess.sendMsg(this, "startKeyLss", reference, customerCode, packingSlipNumber, date, isPrinted, iter);
    }

    public POReleaseSOLinkInfo putAtKey(POReleaseSOLinkInfo value, String reference, String customerCode, String packingSlipNumber, java.util.Calendar date, boolean isPrinted) {
        EntityAccess.sendMsg(this, "putAtKey", reference, customerCode, packingSlipNumber, date, isPrinted, value);
        return value;
    }

    public void removeKey(String reference, String customerCode, String packingSlipNumber, java.util.Calendar date, boolean isPrinted) {
        EntityAccess.sendMsg(this, "removeKey", reference, customerCode, packingSlipNumber, date, isPrinted);
    }

    public void removeKeyEntry(POReleaseSOLinkInfo value, String reference, String customerCode, String packingSlipNumber, java.util.Calendar date, boolean isPrinted) {
        EntityAccess.sendMsg(this, "removeKeyEntry", reference, customerCode, packingSlipNumber, date, isPrinted, value);
    }

    public boolean includesKey(String reference, String customerCode, String packingSlipNumber, java.util.Calendar date, boolean isPrinted) {
        return EntityAccess.sendMsgGetBoolean(this, "includesKey", reference, customerCode, packingSlipNumber, date, isPrinted);
    }

    public boolean includes(POReleaseSOLinkInfo element) {
        return EntityAccess.sendMsgGetBoolean(this, "includes", element);
    }
}