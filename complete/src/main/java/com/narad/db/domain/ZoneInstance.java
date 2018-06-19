package com.narad.db.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.narad.db.domain.compositeprimarykeys.ZoneInstanceCompositePKey;
import com.narad.util.ZoneType;
/**
 * ORM for Zone Instance and DB table
 * @author Devendra
 *
 */

@Entity
@Table(name = "zones")
public class ZoneInstance extends GenericProperties {

	@EmbeddedId
	@JsonUnwrapped
	private ZoneInstanceCompositePKey zoneInstanceCompositePKey;

	@Column(name = "zone_type")
	@JsonProperty("zone-type")
	private ZoneType zoneType;

	@Column(name = "zone_template_id")
	@JsonProperty("zone-template-id")
	private Integer zoneTemplateId;

	@Column(name = "purpose")
	@JsonProperty("purpose")
	private String purpose;

	@Column(name = "contact_name")
	@JsonProperty("contact-name")
	private String contactName;

	@Column(name = "contact_tel")
	@JsonProperty("contact-tel")
	private String contactTel;

	@Column(name = "contact_email")
	@JsonProperty("contact-email")
	private String contactEmail;

	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "location_id", referencedColumnName = "location_id"),
			@JoinColumn(name = "location_name", referencedColumnName = "location_name")

	})
	private LocationInstance locationInstance;

	public ZoneInstanceCompositePKey getZoneInstanceCompositePKey() {
		return zoneInstanceCompositePKey;
	}

	public void setZoneInstanceCompositePKey(ZoneInstanceCompositePKey zoneInstanceCompositePKey) {
		this.zoneInstanceCompositePKey = zoneInstanceCompositePKey;
	}

	public String getZoneType() {
		return this.zoneType.name();
	}

	public void setZoneType(String zoneType) {
		this.zoneType = ZoneType.valueOf(zoneType);
	}

	public Integer getZoneTemplateId() {
		return zoneTemplateId;
	}

	public void setZoneTemplateId(Integer zoneTemplateId) {
		this.zoneTemplateId = zoneTemplateId;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
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

	public LocationInstance getLocationInstance() {
		return locationInstance;
	}

	public void setLocationInstance(LocationInstance locationInstance) {
		this.locationInstance = locationInstance;
	}

}