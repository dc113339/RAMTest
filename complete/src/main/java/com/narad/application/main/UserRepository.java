package com.narad.application.main;
/**
 * 
 * This is test class,will  not use in application.
 * @author Devendra
 */
import org.springframework.data.repository.CrudRepository;

import com.narad.application.main.User;


public interface UserRepository extends CrudRepository<User, Long> {

}
