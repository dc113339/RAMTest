package com.narad.application.main;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.narad.db.domain.LocationInstance;
import com.narad.db.domain.ZoneInstance;
import com.narad.db.domain.compositeprimarykeys.LocationInstanceCompositePKey;
import com.narad.db.domain.compositeprimarykeys.ZoneInstanceCompositePKey;
import com.narad.util.DeleteFlag;

/**
 * This class provides CRUD repository for Zone Instances
 *  @author Devendra
 *
 */
@Service
public interface ZoneInstanceRepository  extends CrudRepository <ZoneInstance,ZoneInstanceCompositePKey> {
	
	
	/**
	 * This is customized method to find zone instances by composite primary key
	 * @param id
	 * @param deleteFlag
	 * @return
	 */
	public List<ZoneInstance> findByZoneInstanceCompositePKeyAndDeleteFlag(ZoneInstanceCompositePKey id,DeleteFlag deleteFlag);

}
