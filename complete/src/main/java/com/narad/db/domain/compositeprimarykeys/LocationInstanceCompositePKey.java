package com.narad.db.domain.compositeprimarykeys;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class for Location Instance Composite Promary Key
 * 
 * @author Devendra
 *
 */
@Embeddable
public class LocationInstanceCompositePKey implements Serializable {

	@Column(name = "location_id")
	@JsonProperty("location-id")
	private Integer locationId;

	@Column(name = "location_name")
	@JsonProperty("location-name")
	private String locationName;

	public LocationInstanceCompositePKey() {

	}

	public LocationInstanceCompositePKey(Integer locationId, String locationName) {
		this.locationId = locationId;
		this.locationName = locationName;

	}

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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof LocationInstanceCompositePKey))
			return false;
		LocationInstanceCompositePKey that = (LocationInstanceCompositePKey) o;
		return Objects.equals(getLocationId(), that.getLocationId())
				&& Objects.equals(getLocationName(), that.getLocationName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getLocationId(), getLocationName());
	}

}
