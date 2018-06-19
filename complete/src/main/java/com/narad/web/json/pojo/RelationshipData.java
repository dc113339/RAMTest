
package com.narad.web.json.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Mapper class for JSON to Java Object and vice versa for RelationshipData
 * 
 * @author Devendra
 *
 */

@JsonRootName("relationship-data")

public class RelationshipData {

	@JsonProperty("relationship-key")

	private String relationshipKey;
	@JsonProperty("relationship-value")
	private String relationshipValue;

	/**
	 * Gets the value of the relationshipKey property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRelationshipKey() {
		return relationshipKey;
	}

	/**
	 * Sets the value of the relationshipKey property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRelationshipKey(String value) {
		this.relationshipKey = value;
	}

	/**
	 * Gets the value of the relationshipValue property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRelationshipValue() {
		return relationshipValue;
	}

	/**
	 * Sets the value of the relationshipValue property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRelationshipValue(String value) {
		this.relationshipValue = value;
	}

}
