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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.narad.application.main.LocationInstanceRepository;
import com.narad.db.domain.compositeprimarykeys.LocationInstanceCompositePKey;
import com.narad.util.AdapterUtil;
import com.narad.util.DeleteFlag;
import com.narad.web.json.pojo.LocationInstance;

/**
 * REST Consumer class for Location Instance
 * 
 * @author Devendra
 *
 */
@Controller
@RequestMapping(path = "/aai/v13/cloud-infrastructure/location-instances")
public class LocationInstanceController {

	@Autowired
	private LocationInstanceRepository locationInstanceRepository;

	/**
	 * Method for ADD or UPDATE operation
	 * 
	 * @param locationid
	 * @param locationName
	 * @param locationInstance
	 * @return
	 */
	@PutMapping(path = "/location-instance/{location-id}/{location-name}")
	public ResponseEntity<com.narad.db.domain.LocationInstance> addUpdateLocationInstance(
			@PathVariable("location-id") Integer locationid, @PathVariable("location-name") String locationName,
			@RequestBody LocationInstance locationInstance) {
		String result = "Saved Successfully ...";

		ObjectMapper mapper = new ObjectMapper();
		try {
			String input = mapper.writeValueAsString(locationInstance);
			com.narad.db.domain.LocationInstance locInstance = mapper.readValue(input,
					com.narad.db.domain.LocationInstance.class);
			locInstance.setCreatedAt(new java.sql.Date(System.currentTimeMillis()));
			locInstance.setResourceVersion("" + new Random().nextInt());

			System.out.println("input >>>" + input);
			System.out.println("input >>>" + locInstance.getAddress() + "  "
					+ locInstance.getLocationInstanceCompositePKey().getLocationId());

			locationInstanceRepository.save(locInstance);

		} catch (Exception e) {

			e.printStackTrace();
			return new ResponseEntity<com.narad.db.domain.LocationInstance>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<com.narad.db.domain.LocationInstance>(HttpStatus.CREATED);
	}

	/**
	 * Method for GET Operation
	 * 
	 * @param locationid
	 * @param locationName
	 * @return
	 */

	@GetMapping(path = "/location-instance/{location-id}/{location-name}")
	public ResponseEntity<com.narad.db.domain.LocationInstance> getLocationInstance(
			@PathVariable("location-id") Integer locationid, @PathVariable("location-name") String locationName) {

		LocationInstanceCompositePKey id = new LocationInstanceCompositePKey(locationid, locationName);
		// com.onap.domain.LocationInstance locInst =
		// locationInstanceRepository.findById(id).get();
		List<com.narad.db.domain.LocationInstance> locInstList = locationInstanceRepository
				.findByLocationInstanceCompositePKeyAndDeleteFlag(id, DeleteFlag.N);
		if (locInstList.size() == 0) {

			return new ResponseEntity<com.narad.db.domain.LocationInstance>(HttpStatus.NO_CONTENT);
		}

		com.narad.db.domain.LocationInstance locInst = locInstList.get(0);

		ObjectMapper mapper = new ObjectMapper();
		String output = "error";
		try {
			output = mapper.writeValueAsString(locInst);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ResponseEntity<com.narad.db.domain.LocationInstance>(locInst, HttpStatus.OK);
	}

	/**
	 * Method for PATCH Operation
	 * 
	 * @param locationid
	 * @param locationName
	 * @param fields
	 * @return
	 */
	@PatchMapping(path = "/location-instance/{location-id}/{location-name}") // Map ONLY GET Requests
	public ResponseEntity<com.narad.db.domain.LocationInstance> patchLocationInstance(
			@PathVariable("location-id") Integer locationid, @PathVariable("location-name") String locationName,
			@RequestBody Map<String, Object> fields) {

		LocationInstanceCompositePKey id = new LocationInstanceCompositePKey(locationid, locationName);
		com.narad.db.domain.LocationInstance locInst = locationInstanceRepository.findById(id).get();
		// com.onap.domain.LocationInstance locInst =
		// locationInstanceRepository.findByLocationInstanceCompositePKeyAndDeleteFlag(id,
		// DeleteFlag.N).get(0);

		fields.forEach((k, v) -> {
			if (k != "location-id" && k != "location-name") {
				String convertedField = AdapterUtil.convertPropertyName(k);
				System.out.println("k>>>" + k + "   convertedField>>" + convertedField);
				Field field = ReflectionUtils.findRequiredField(com.narad.db.domain.LocationInstance.class,
						convertedField);
				ReflectionUtils.setField(field, locInst, v);
			}
		});

		locationInstanceRepository.save(locInst);

		return new ResponseEntity<com.narad.db.domain.LocationInstance>(locInst, HttpStatus.OK);
	}

	/**
	 * Method for DELETE Operation
	 * 
	 * @param locationid
	 * @param locationName
	 * @param locationInstance
	 * @return
	 */
	@DeleteMapping(path = "/location-instance/{location-id}/{location-name}")
	public ResponseEntity<com.narad.db.domain.LocationInstance> deleteLocationInstance(
			@PathVariable("location-id") Integer locationid, @PathVariable("location-name") String locationName,
			@RequestBody LocationInstance locationInstance) {

		LocationInstanceCompositePKey id = new LocationInstanceCompositePKey(locationid, locationName);
		com.narad.db.domain.LocationInstance locInst = locationInstanceRepository.findById(id).get();
		locInst.setDeleteFlag("Y");
		locationInstanceRepository.save(locInst);

		return new ResponseEntity<com.narad.db.domain.LocationInstance>(HttpStatus.NO_CONTENT);
	}

}
