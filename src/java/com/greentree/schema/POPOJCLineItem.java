/*
 * Copyright (C) 2013 Direct Communications
 *
 * Licensed under the BSD License.
 */

package com.greentree.schema;

import com.jadeworld.jade.persistence.DbField;
import com.jadeworld.jade.persistence.DbProperty;
import com.jadeworld.jade.persistence.Entity;
import com.jadeworld.jade.persistence.ManyToOne;
import com.jadeworld.jade.persistence.ReferenceRelationshipType;
import com.jadeworld.jade.persistence.ReferenceUpdateMode;
import com.jadeworld.jade.entitymanager.EntityAccess;

@Entity()
public class POPOJCLineItem extends POPOLineItem {

    @DbField(length = 60)
    public String activityDescription;

    public String getActivityDescription() {
        return activityDescription;
    }

    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }

    @DbProperty()
    @ManyToOne(relationshipType = ReferenceRelationshipType.PEER,
            updateMode = ReferenceUpdateMode.MANUAL,
            inverses = {"allPOPOJCLineItems"})
    public JCJob getMyJob() {
        return (JCJob) EntityAccess.getReferenceProperty(this, "myJob");
    }

    public void setMyJob(JCJob myJob) {
        EntityAccess.setReferenceProperty(this, "myJob", myJob);
    }

    @Override
    public String toString() {
        String result = this.getCodeString().trim() + " - ";
        result += this.getStandardText().trim();

        return result;
    }
}
