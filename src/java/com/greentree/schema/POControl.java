/*
 * Copyright (C) 2013 Direct Communications
 *
 * Licensed under the BSD License.
 */

package com.greentree.schema;

import com.jadeworld.jade.entitymanager.EntityAccess;
import com.jadeworld.jade.persistence.DbProperty;
import com.jadeworld.jade.persistence.Entity;
import com.jadeworld.jade.persistence.OneToMany;
import com.jadeworld.jade.persistence.ReferenceRelationshipType;
import com.jadeworld.jade.persistence.ReferenceUpdateMode;

@Entity()
public class POControl extends com.jadeworld.jade.rootschema.Object {

    @SuppressWarnings("unchecked")
    @DbProperty()
    @OneToMany(relationshipType = ReferenceRelationshipType.PEER,
            updateMode = ReferenceUpdateMode.AUTOMATIC, inverse = "myPOControl")
    public POByReferenceDict<PODocument> getAllPOPurchaseOrders() {
        return (POByReferenceDict<PODocument>) EntityAccess.getReferenceProperty(this, "allPOPurchaseOrders");
    }
}