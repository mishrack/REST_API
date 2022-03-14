package course.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class }) // this annotation tells that it is a spring boot application main class
public class CourseAPIApp {

	public static void main(String[] args) {

		// this is to call run method, which take first argument as main class of
		// application and any other argument as second
		SpringApplication.run(CourseAPIApp.class, args);

	}

}

/*
Starting Spring boot application
- SpringApplication is a static class having a static method "run" which performs several actions

1. Sets up default configuration : convention over configuration which covers majority of spring applications need
2. Starts spring application context 
3. Perform class path scan : based on annotations 
4. Starts Embedded Tomcat server

*/