package io.spring.springbootapp.Demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// acts as a rest controller
@RestController
public class DemoController {
	
	// GET Request	
	@RequestMapping("/message")
	public String getMessage() {
		return "Hello Message";
	}
	
}
