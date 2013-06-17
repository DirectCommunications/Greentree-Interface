/*
 * Copyright (C) 2013 Direct Communications
 * 
 * Licensed under the BSD License.
 */

package com.greentree.schema;

import com.jadeworld.jade.entitymanager.EntityAccess;
import com.jadeworld.jade.persistence.DbProperty;
import com.jadeworld.jade.persistence.Entity;
import com.jadeworld.jade.persistence.OneToOne;
import com.jadeworld.jade.persistence.ReferenceRelationshipType;
import com.jadeworld.jade.persistence.ReferenceUpdateMode;

@Entity()
public class UTAddressSODocument extends com.jadeworld.jade.rootschema.Object {

    @DbProperty()
    @OneToOne(relationshipType = ReferenceRelationshipType.PEER,
            updateMode = ReferenceUpdateMode.MAN_AUTO,
            inverse = "myAddress")
    public SODocument getMySODocument() {
        return (SODocument) EntityAccess.getReferenceProperty(this, "mySODocument");
    }

    public void setMySODocument(SODocument mySODocument) {
        EntityAccess.setReferenceProperty(this, "mySODocument", mySODocument);
    }
}