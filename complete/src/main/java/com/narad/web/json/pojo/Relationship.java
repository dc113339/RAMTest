
package com.narad.web.json.pojo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Mapper class for JSON to Java Object and vice versa for Relationship
 * 
 * @author Devendra
 *
 */

@JsonRootName("relationship")

public class Relationship {

	@JsonProperty("related-to")
	protected String relatedTo;
	@JsonProperty("relationship-label")
	protected String relationshipLabel;
	@JsonProperty("related-link")
	protected String relatedLink;
	@JsonProperty("relationship-data")
	protected List<RelationshipData> relationshipData;
	@JsonProperty("related-to-property")
	protected List<RelatedToProperty> relatedToProperty;

	/**
	 * Gets the value of the relatedTo property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRelatedTo() {
		return relatedTo;
	}

	/**
	 * Sets the value of the relatedTo property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRelatedTo(String value) {
		this.relatedTo = value;
	}

	/**
	 * Gets the value of the relationshipLabel property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRelationshipLabel() {
		return relationshipLabel;
	}

	/**
	 * Sets the value of the relationshipLabel property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRelationshipLabel(String value) {
		this.relationshipLabel = value;
	}

	/**
	 * Gets the value of the relatedLink property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRelatedLink() {
		return relatedLink;
	}

	/**
	 * Sets the value of the relatedLink property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRelatedLink(String value) {
		this.relatedLink = value;
	}

	/**
	 * Gets the value of the relationshipData property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the relationshipData property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getRelationshipData().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link RelationshipData }
	 * 
	 * 
	 */
	public List<RelationshipData> getRelationshipData() {
		if (relationshipData == null) {
			relationshipData = new ArrayList<RelationshipData>();
		}
		return this.relationshipData;
	}

	/**
	 * Gets the value of the relatedToProperty property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the relatedToProperty property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getRelatedToProperty().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link RelatedToProperty }
	 * 
	 * 
	 */
	public List<RelatedToProperty> getRelatedToProperty() {
		if (relatedToProperty == null) {
			relatedToProperty = new ArrayList<RelatedToProperty>();
		}
		return this.relatedToProperty;
	}

}
