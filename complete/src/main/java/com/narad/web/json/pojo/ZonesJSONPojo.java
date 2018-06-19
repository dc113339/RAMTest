package com.narad.web.json.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.narad.util.ZoneType;

/**
 * Mapper class for JSON to Java Object and vice versa for Zones
 * 
 * @author Devendra
 *
 */

public class ZonesJSONPojo extends GenericPropertiesPojo {

	@JsonProperty("zone-id")
	private Integer zoneId;

	@JsonProperty("zone-name")
	private String zoneName;

	@JsonProperty("zone-type")
	private ZoneType zoneType;

	@JsonProperty("zone-template-id")
	private Integer zoneTemplateId;

	@JsonProperty("purpose")
	private String purpose;

	@JsonProperty("contact-name")
	private String contactName;

	@JsonProperty("contact-tel")
	private String contactTel;

	@JsonProperty("contact-email")
	private String contactEmail;

	public Integer getZoneId() {
		return zoneId;
	}

	public void setZoneId(Integer zoneId) {
		this.zoneId = zoneId;
	}

	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	public ZoneType getZoneType() {
		return zoneType;
	}

	public void setZoneType(ZoneType zoneType) {
		this.zoneType = zoneType;
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

}
