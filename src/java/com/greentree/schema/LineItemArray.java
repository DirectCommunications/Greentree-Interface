/*
 * Copyright (C) 2013 Direct Communications
 *
 * Licensed under the BSD License.
 */

package com.greentree.schema;

import com.jadeworld.jade.rootschema.Array;
import com.jadeworld.jade.persistence.CollectionEntity;

@SuppressWarnings("unchecked")
@CollectionEntity()
public class LineItemArray<LineItem> extends Array<LineItem> {
}