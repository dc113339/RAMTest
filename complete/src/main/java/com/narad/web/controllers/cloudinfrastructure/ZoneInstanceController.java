package com.narad.web.controllers.cloudinfrastructure;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Random;

//
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.narad.application.main.LocationInstanceRepository;
import com.narad.application.main.ZoneInstanceRepository;
import com.narad.db.domain.LocationInstance;
import com.narad.db.domain.compositeprimarykeys.LocationInstanceCompositePKey;
import com.narad.db.domain.compositeprimarykeys.ZoneInstanceCompositePKey;
import com.narad.util.AdapterUtil;
import com.narad.util.DeleteFlag;
import com.narad.web.json.pojo.Relationship;
import com.narad.web.json.pojo.RelationshipData;
import com.narad.web.json.pojo.RelationshipList;
import com.narad.web.json.pojo.ZonesJSONPojo;

/**
 * REST Consumer class for Zone Instance
 * 
 * @author Devendra
 *
 */

@Controller
@RequestMapping(path = "/aai/v13/cloud-infrastructure/zone-instances")
public class ZoneInstanceController {

	@Autowired
	private ZoneInstanceRepository zoneInstanceRepository;

	@Autowired
	private LocationInstanceRepository loactionInstanceRepository;

	/**
	 * Method for ADD or UPDATE operation
	 * 
	 * @param zoneid
	 * @param zoneName
	 * @param zoneInstance
	 * @return
	 */
	@PutMapping(path = "/zone-instance/{zone-id}/{zone-name}")
	public ResponseEntity<com.narad.db.domain.ZoneInstance> addUpdateZoneInstance(
			@PathVariable("zone-id") Integer zoneid, @PathVariable("zone-name") String zoneName,
			@RequestBody ZonesJSONPojo zoneInstance) {

		String result = "Saved Successfully ...";

		ObjectMapper mapper = new ObjectMapper();
		try {
			String input = mapper.writeValueAsString(zoneInstance);
			com.narad.db.domain.ZoneInstance zoneDomainInstance = mapper.readValue(input,
					com.narad.db.domain.ZoneInstance.class);
			zoneDomainInstance.setCreatedAt(new java.sql.Date(System.currentTimeMillis()));
			zoneDomainInstance.setResourceVersion("" + new Random().nextInt());

			System.out.println("input >>>" + input);
			System.out.println("input >>>" + zoneDomainInstance.getZoneInstanceCompositePKey().getZoneId());

			LocationInstanceCompositePKey pKey = new LocationInstanceCompositePKey();

			RelationshipList list = zoneInstance.getRelationshipList();
			List<Relationship> relationshipList = list.getRelationship();

			Relationship relationship = relationshipList.get(0);
			String relatedToProperty = AdapterUtil.convertPropertyName(relationship.getRelatedTo());
			for (RelationshipData data : relationship.getRelationshipData()) {

				String key = data.getRelationshipKey();
				String value = data.getRelationshipValue();
				System.out.println("key >>>" + key + " value>>" + value);
				String keys[] = key.split("\\.");
				System.out.println("keys" + keys);
				key = keys[1];
				System.out.println("key after >>>" + key + " value>>" + value);
				String convertedField = AdapterUtil.convertPropertyName(key);
				System.out.println("convertedField >>>" + convertedField);
				Field field = ReflectionUtils.findRequiredField(LocationInstanceCompositePKey.class, convertedField);
				if (convertedField.equals("locationId")) {

					ReflectionUtils.setField(field, pKey, Integer.parseInt(value));
					System.out.println("field>>>" + field.toString() + " value>>" + value);
				} else {
					ReflectionUtils.setField(field, pKey, value);
					System.out.println("field>>>" + field.toString() + " value>>" + value);
				}

			}

			LocationInstance locationInstance = loactionInstanceRepository
					.findByLocationInstanceCompositePKeyAndDeleteFlag(pKey, DeleteFlag.N).get(0);
			System.out.println(
					"locationInstance>>>>" + locationInstance.getLocationInstanceCompositePKey().getLocationId());
			zoneDomainInstance.setLocationInstance(locationInstance);

			zoneInstanceRepository.save(zoneDomainInstance);

		} catch (Exception e) {

			e.printStackTrace();
			return new ResponseEntity<com.narad.db.domain.ZoneInstance>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<com.narad.db.domain.ZoneInstance>(HttpStatus.CREATED);
	}

	/**
	 * Method for GET Operation
	 * 
	 * @param zoneid
	 * @param zoneName
	 * @return
	 */
	@GetMapping(path = "/zone-instance/{zone-id}/{zone-name}")

	public ResponseEntity<com.narad.db.domain.ZoneInstance> getZoneInstance(@PathVariable("zone-id") Integer zoneid,
			@PathVariable("zone-name") String zoneName) {

		ZoneInstanceCompositePKey id = new ZoneInstanceCompositePKey(zoneid, zoneName);
	
		List<com.narad.db.domain.ZoneInstance> zoneInstList = zoneInstanceRepository
				.findByZoneInstanceCompositePKeyAndDeleteFlag(id, DeleteFlag.N);
		if (zoneInstList.size() == 0) {

			return new ResponseEntity<com.narad.db.domain.ZoneInstance>(HttpStatus.NO_CONTENT);
		}

		com.narad.db.domain.ZoneInstance zoneInst = zoneInstList.get(0);

		return new ResponseEntity<com.narad.db.domain.ZoneInstance>(zoneInst, HttpStatus.OK);
	}

	/**
	 * Method for PATCH Operation
	 * 
	 * @param zoneid
	 * @param zoneName
	 * @param fields
	 * @return
	 */
	@PatchMapping(path = "/zone-instance/{zone-id}/{zone-name}")
	public ResponseEntity<com.narad.db.domain.ZoneInstance> patchZoneInstance(@PathVariable("zone-id") Integer zoneid,
			@PathVariable("zone-name") String zoneName, @RequestBody Map<String, Object> fields) {

		ZoneInstanceCompositePKey id = new ZoneInstanceCompositePKey(zoneid, zoneName);
		com.narad.db.domain.ZoneInstance locInst = zoneInstanceRepository.findById(id).get();

		fields.forEach((k, v) -> {

			if (k != "zone-id" && k != "zone-name") {
				String convertedField = AdapterUtil.convertPropertyName(k);
				System.out.println("k>>>" + k + "   convertedField>>" + convertedField);
				Field field = ReflectionUtils.findRequiredField(com.narad.db.domain.ZoneInstance.class, convertedField);
				ReflectionUtils.setField(field, locInst, v);
			}
		});

		zoneInstanceRepository.save(locInst);

		return new ResponseEntity<com.narad.db.domain.ZoneInstance>(locInst, HttpStatus.OK);
	}

	/**
	 * Method for DELETE Operation
	 * 
	 * @param zoneid
	 * @param zoneName
	 * @param zoneInstance
	 * @return
	 */
	@DeleteMapping(path = "/zone-instance/{zone-id}/{zone-name}")
	public ResponseEntity<com.narad.db.domain.ZoneInstance> deleteZoneInstance(@PathVariable("zone-id") Integer zoneid,
			@PathVariable("zone-name") String zoneName, @RequestBody ZonesJSONPojo zoneInstance) {

		ZoneInstanceCompositePKey id = new ZoneInstanceCompositePKey(zoneid, zoneName);
		com.narad.db.domain.ZoneInstance zoneInst = zoneInstanceRepository.findById(id).get();
		zoneInst.setDeleteFlag("Y");
		zoneInstanceRepository.save(zoneInst);

		return new ResponseEntity<com.narad.db.domain.ZoneInstance>(HttpStatus.NO_CONTENT);
	}

}
