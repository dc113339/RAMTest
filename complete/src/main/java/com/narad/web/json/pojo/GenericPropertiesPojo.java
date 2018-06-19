package com.narad.web.json.pojo;

import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.narad.util.DeleteFlag;

/**
 * Mapper class for JSON to Java Object and vice versa for Generic Properties
 * 
 * @author Devendra
 *
 */
public class GenericPropertiesPojo {
	@JsonProperty("comment")
	private String comment;
	@JsonProperty("num-changes")
	private BigInteger numChanges;
	@JsonProperty("last-update-by")
	private String lastUpdateBy;
	@JsonProperty("created-at")
	private java.sql.Date createdAt;
	@JsonProperty("updated-at")
	private java.sql.Date updatedAt;
	@JsonProperty("delete-flag")
	private DeleteFlag deleteFlag;
	@JsonProperty("resource-version")
	private String resourceVersion;
	@JsonProperty("relationship-list")
	private RelationshipList relationshipList;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public BigInteger getNumChanges() {
		return numChanges;
	}

	public void setNumChanges(BigInteger numChanges) {
		this.numChanges = numChanges;
	}

	public String getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public java.sql.Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(java.sql.Date createdAt) {
		this.createdAt = createdAt;
	}

	public java.sql.Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(java.sql.Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public DeleteFlag getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(DeleteFlag deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getResourceVersion() {
		return resourceVersion;
	}

	public void setResourceVersion(String resourceVersion) {
		this.resourceVersion = resourceVersion;
	}

	public RelationshipList getRelationshipList() {
		return relationshipList;
	}

	public void setRelationshipList(RelationshipList relationshipList) {
		this.relationshipList = relationshipList;
	}

}
