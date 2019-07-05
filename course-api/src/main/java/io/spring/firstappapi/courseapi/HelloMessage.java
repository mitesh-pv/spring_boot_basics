package io.spring.firstappapi.courseapi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloMessage {
	
	@RequestMapping("/")
	public String getMessage() {
		return "Hello Spring";
	}
}
