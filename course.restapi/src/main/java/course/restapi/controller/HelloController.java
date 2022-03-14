package course.restapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController   // make it as a rest API controller, which maps a request to a response
public class HelloController {
	
	@RequestMapping("/hello")   // RequestMapping annotation by default take GET request of HTTP 
	public String sayHello()
	{
		return "Hi there..this is me localhost:8080 running spring boot application" ;
	}

}
