package com.narad.application.main;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.narad.db.domain.LocationInstance;
import com.narad.db.domain.compositeprimarykeys.LocationInstanceCompositePKey;
import com.narad.util.DeleteFlag;
/**
 * This will be AUTO IMPLEMENTED by Spring into a Bean called LocationInstanceRepository
 * CRUD refers Create, Read, Update, Delete
 * @author Devendra
 *
 */
@Service
public interface LocationInstanceRepository  extends CrudRepository <LocationInstance,LocationInstanceCompositePKey> {
	
	//
	/**
	 * 
	 * @param id
	 * @param deleteFlag
	 * @return List of LocationInstance
	 */
	public List<LocationInstance> findByLocationInstanceCompositePKeyAndDeleteFlag(LocationInstanceCompositePKey id,DeleteFlag deleteFlag);

}
