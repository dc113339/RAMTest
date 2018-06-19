package com.narad.db.domain.compositeprimarykeys;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class for Zone Instance Composite Promary Key
 * 
 * @author Devendra
 *
 */
@Embeddable
public class ZoneInstanceCompositePKey implements Serializable {

	@Column(name = "zone_id")
	@JsonProperty("zone-id")
	private Integer zoneId;

	@Column(name = "zone_name")
	@JsonProperty("zone-name")
	private String zoneName;

	public ZoneInstanceCompositePKey() {

	}

	public ZoneInstanceCompositePKey(Integer zoneId, String zoneName) {
		this.zoneId = zoneId;
		this.zoneName = zoneName;

	}

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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof ZoneInstanceCompositePKey))
			return false;
		ZoneInstanceCompositePKey that = (ZoneInstanceCompositePKey) o;
		return Objects.equals(getZoneId(), that.getZoneId()) && Objects.equals(getZoneName(), that.getZoneName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getZoneId(), getZoneName());
	}

}
