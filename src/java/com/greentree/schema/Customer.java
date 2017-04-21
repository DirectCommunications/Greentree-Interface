/*
 * Copyright (C) 2013 Direct Communications
 *
 * Licensed under the MIT License.
 */

package com.greentree.schema;

import com.jadeworld.jade.persistence.DbField;
import com.jadeworld.jade.persistence.Entity;
import com.jadeworld.jade.persistence.Lob;

@Entity()
public class Customer extends com.jadeworld.jade.rootschema.Object {

    @DbField(length = 50)
    public String address1;
    @DbField(length = 50)
    public String address2;
    @DbField(length = 50)
    public String address3;
    @DbField(length = 12)
    public String code;
    @Lob()
    @DbField()
    public String emailAddress;
    @DbField(length = 50)
    public String fax;
    @DbField(length = 50)
    public String name;
    @DbField(length = 50)
    public String phoneNumber;
    @DbField(length = 10)
    public String postCode;

    public String getAddress1() {
        return address1.trim();
    }

    public void setAddress1(String address1) {
        this.address1 = address1.trim();
    }

    public String getAddress2() {
        return address2.trim();
    }

    public void setAddress2(String address2) {
        this.address2 = address2.trim();
    }

    public String getAddress3() {
        return address3.trim();
    }

    public void setAddress3(String address3) {
        this.address3 = address3.trim();
    }

    public String getCode() {
        return code.trim();
    }

    public void setCode(String code) {
        this.code = code.trim();
    }

    public String getEmailAddress() {
        return emailAddress.trim();
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress.trim();
    }

    public String getFax() {
        return fax.trim();
    }

    public void setFax(String fax) {
        this.fax = fax.trim();
    }

    @Override
    public String getName() {
        return name.trim();
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber.trim();
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber.trim();
    }

    public String getPostCode() {
        return postCode.trim();
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode.trim();
    }

    @Override
    public String toString() {
        return "Name: " + this.getName();
    }
}