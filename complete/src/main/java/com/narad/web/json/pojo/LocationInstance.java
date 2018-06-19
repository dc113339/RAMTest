package com.narad.web.json.pojo;

import java.math.BigInteger;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.narad.util.DeleteFlag;

/**
 * Mapper class for JSON to Java Object and vice versa for Location instance
 * 
 * @author Devendra
 *
 */

public class LocationInstance {

	@JsonProperty("location-id")
	private Integer locationId;

	@JsonProperty("location-name")
	private String locationName;

	@JsonProperty("location-alias1")
	private String locationAlias1;

	@JsonProperty("location-alias2")
	private String locationAlias2;

	@Column(name = "type")
	@JsonProperty("type")
	private String type;

	@JsonProperty("zone-count")
	private String zoneCount;

	@JsonProperty("clli")
	private String clli;
	@JsonProperty("region")
	private String region;
	@JsonProperty("sub-region")
	private String subRegion;
	@JsonProperty("street_address")
	private String streetAddress;
	@JsonProperty("city")
	private String city;
	@JsonProperty("state-prov")
	private String stateProv;
	@JsonProperty("country")
	private String country;
	@JsonProperty("zip")
	private String zip;
	@JsonProperty("address")
	private String address;
	@JsonProperty("contact-name")
	private String contactName;
	@JsonProperty("contact-tel")
	private String contactTel;
	@JsonProperty("contact-email")
	private String contactEmail;
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

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getLocationAlias1() {
		return locationAlias1;
	}

	public void setLocationAlias1(String locationAlias1) {
		this.locationAlias1 = locationAlias1;
	}

	public String getLocationAlias2() {
		return locationAlias2;
	}

	public void setLocationAlias2(String locationAlias2) {
		this.locationAlias2 = locationAlias2;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getZoneCount() {
		return zoneCount;
	}

	public void setZoneCount(String zoneCount) {
		this.zoneCount = zoneCount;
	}

	public String getClli() {
		return clli;
	}

	public void setClli(String clli) {
		this.clli = clli;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getSubRegion() {
		return subRegion;
	}

	public void setSubRegion(String subRegion) {
		this.subRegion = subRegion;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateProv() {
		return stateProv;
	}

	public void setStateProv(String stateProv) {
		this.stateProv = stateProv;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactTel() {
		return contactTel;
	}

	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

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

	public RelationshipList getRelationshipList() {
		return relationshipList;
	}

	public void setRelationshipList(RelationshipList relationshipList) {
		this.relationshipList = relationshipList;
	}

}
