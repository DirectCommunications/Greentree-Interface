/*
 * Copyright (C) 2013 Direct Communications
 *
 * Licensed under the MIT License.
 */

package com.greentree.schema;

import com.jadeworld.jade.persistence.DbField;
import com.jadeworld.jade.persistence.Entity;

@Entity()
public class JCJob extends com.jadeworld.jade.rootschema.Object {

    @DbField(length = 20)
    public String jobReference;
    @DbField(length = 30)
    public String orderNumber;
    @DbField(length = 50)
    public String name;

    public String getJobReference() {
        return jobReference;
    }

    public void setJobReference(String jobReference) {
        this.jobReference = jobReference;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String result = "Job Ref: " + jobReference + ". ";
        result += "Order Number: " + orderNumber;
        return result;
    }
}