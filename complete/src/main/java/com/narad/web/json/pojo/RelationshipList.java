package com.narad.web.json.pojo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Mapper class for JSON to Java Object and vice versa for RelationshipList
 * 
 * @author Devendra
 *
 */
@JsonRootName("relationship-list")
public class RelationshipList {

	protected List<Relationship> relationship;

	public List<Relationship> getRelationship() {
		if (relationship == null) {
			relationship = new ArrayList<Relationship>();
		}
		return this.relationship;
	}

}
