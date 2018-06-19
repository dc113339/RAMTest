package com.narad.db.domain;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.narad.db.domain.compositeprimarykeys.LocationInstanceCompositePKey;
import com.narad.util.DeleteFlag;

/**
 * ORM for Location Instance and DB table
 * 
 * @author Devendra
 *
 */

@Entity
@Table(name = "location_instance")
public class LocationInstance {

	@EmbeddedId
	@JsonUnwrapped
	private LocationInstanceCompositePKey locationInstanceCompositePKey;

	@Column(name = "location_alias1")
	@JsonProperty("location-alias1")
	private String locationAlias1;

	@Column(name = "location_alias2")
	@JsonProperty("location-alias2")
	private String locationAlias2;

	@Column(name = "type")
	@JsonProperty("type")
	private String type;

	@Column(name = "zone_count")
	@JsonProperty("zone-count")
	private String zoneCount;

	@Column(name = "clli")
	@JsonProperty("clli")
	private String clli;
	@Column(name = "region")
	private String region;

	@Column(name = "sub_region")
	@JsonProperty("sub-region")
	private String subRegion;

	@Column(name = "street_address")
	@JsonProperty("street_address")
	private String streetAddress;

	@Column(name = "city")
	@JsonProperty("city")
	private String city;

	@Column(name = "state_prov")
	@JsonProperty("state-prov")
	private String stateProv;

	@Column(name = "country")
	@JsonProperty("country")
	private String country;

	@Column(name = "zip")
	@JsonProperty("zip")
	private String zip;

	@Column(name = "address")
	@JsonProperty("address")
	private String address;

	@Column(name = "contact_name")
	@JsonProperty("contact-name")
	private String contactName;

	@Column(name = "contact_tel")
	@JsonProperty("contact-tel")
	private String contactTel;

	@Column(name = "contact_email")
	@JsonProperty("contact-email")
	private String contactEmail;

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

	public LocationInstanceCompositePKey getLocationInstanceCompositePKey() {
		return locationInstanceCompositePKey;
	}

	public void setLocationInstanceCompositePKey(LocationInstanceCompositePKey locationInstanceCompositePKey) {
		this.locationInstanceCompositePKey = locationInstanceCompositePKey;
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

}
