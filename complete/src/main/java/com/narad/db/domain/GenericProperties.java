package com.narad.db.domain;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.narad.util.DeleteFlag;

/**
 * Generic Domain class
 * 
 * @author Devendra
 *
 */

@MappedSuperclass
public class GenericProperties {

	@Column(name = "comment")
	@JsonProperty("comment")
	private String comment;

	@Column(name = "num_changes")
	@JsonProperty("num-changes")
	private BigInteger numChanges;

	@Column(name = "last_update_by")
	@JsonProperty("last-update-by")
	private String lastUpdateBy;

	@Column(name = "created_at")
	@JsonProperty("created-at")
	private java.sql.Date createdAt;

	@Column(name = "updated_at")
	@JsonProperty("updated-at")
	private java.sql.Date updatedAt;

	@Column(name = "delete_flag")
	@JsonProperty("delete-flag")
	private DeleteFlag deleteFlag;

	@Column(name = "resource_version")
	@JsonProperty("resource-version")
	private String resourceVersion;

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

	public String getDeleteFlag() {
		return this.deleteFlag.name();
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = DeleteFlag.valueOf(deleteFlag);
	}

	public String getResourceVersion() {
		return resourceVersion;
	}

	public void setResourceVersion(String resourceVersion) {
		this.resourceVersion = resourceVersion;
	}

}
