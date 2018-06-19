
package com.narad.web.json.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
/**
 * Mapper class for JSON to Java Object and vice versa for RelatedToProperty
 * 
 * @author Devendra
 *
 */

@JsonRootName( "related-to-property")

public class RelatedToProperty {

	@JsonProperty("property-key")
     private String propertyKey;
	
	@JsonProperty("property-value")
    private  String propertyValue;

    /**
     * Gets the value of the propertyKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPropertyKey() {
        return propertyKey;
    }

    /**
     * Sets the value of the propertyKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPropertyKey(String value) {
        this.propertyKey = value;
    }

    /**
     * Gets the value of the propertyValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPropertyValue() {
        return propertyValue;
    }

    /**
     * Sets the value of the propertyValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPropertyValue(String value) {
        this.propertyValue = value;
    }

}
