/*
 * Copyright (C) 2013 Direct Communications
 *
 * Licensed under the MIT License.
 */

package com.greentree.schema;

import com.jadeworld.jade.entitymanager.EntityAccess;
import com.jadeworld.jade.persistence.DbProperty;
import com.jadeworld.jade.persistence.Entity;
import com.jadeworld.jade.persistence.OneToMany;
import com.jadeworld.jade.persistence.ReferenceRelationshipType;
import com.jadeworld.jade.persistence.ReferenceUpdateMode;

@SuppressWarnings("unchecked")
@Entity()
public class SOControl extends com.jadeworld.jade.rootschema.Object {

    @DbProperty()
    @OneToMany(relationshipType = ReferenceRelationshipType.PEER, updateMode = ReferenceUpdateMode.AUTOMATIC, inverse = "mySOControl")
    public SODocumentByReferenceDict<SODocument> getAllSOSalesOrders() {
        return (SODocumentByReferenceDict<SODocument>) EntityAccess.getReferenceProperty(this, "allSOSalesOrders");
    }
}