package com.narad.application.main;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * This is test class,will  not use in application
 * @author Devendra
 *
 */
@Controller    // This means that this class is a Controller
@RequestMapping(path="/testuser") // This means URL's start with /testuser (after Application path)
public class TestController {

	private UserRepository userRepository;
	
	/**
	 * Get  requestd  
	 * @param name
	 * @param email
	 * @return
	 */
	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewUser (@RequestParam String name
			, @RequestParam String email) {
	
		
		User n = new User();
		n.setName(name);
		n.setEmail(email);
		userRepository.save(n);
		return "Saved";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
}
