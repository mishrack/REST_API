//package learning.eureka.service.request.mapping;  change the package accordingly 

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestMappingDemo {

	// @RequestMapping — by Path
	@RequestMapping(value = "/rm/by-path")
	public String getRequestBySimplePath() {
		return "Request Mapping via simple path";
	}

	// @RequestMapping — the HTTP Method
	@RequestMapping(value = "rm/by-http-method", method = POST)
	public String getRequestByHttpMethod() {
		return "Request Mapping By HTTP method";
	}

	// RequestMapping Consumes and Produces
	// Accept example
	@RequestMapping(value = "/rm/accept", method = GET, headers = "Accept=application/json")
	public String getFoosAsJsonFromBrowser() {
		return "Get some Foos with Header Old";
	}

	// produce example
	@RequestMapping(value = "/rm/produce", method = GET, produces = "application/json")
	public String getFoosAsJsonFromREST() {
		return "Get some Foos with Header New";
	}

	// RequestMapping With Path Variables
	// Single @PathVariable
	@RequestMapping(value = "/rm/foos/{id}", method = GET)
	@ResponseBody
	public String getFoosBySimplePathWithPathVariable(@PathVariable("id") long id) {
		return "Get a specific Foo with id=" + id;
	}

	// Multiple @PathVariable
	@RequestMapping(value = "/rm/foos/{fooid}/bar/{barid}", method = GET)
	@ResponseBody
	public String getFoosBySimplePathWithPathVariables(@PathVariable long fooid, @PathVariable long barid) {
		return "Get a specific Bar with id=" + barid + " from a Foo with id=" + fooid;
	}

	// @PathVariable With Regex : restrict the mapping to only accept numerical
	// values for the id:
	@RequestMapping(value = "/rm/bars/{numericId:[\\d]+}", method = GET)
	@ResponseBody
	public String getBarsBySimplePathWithPathVariable(@PathVariable long numericId) {
		return "Get a specific Bar with id=" + numericId;
	}

	// RequestMapping With Request Parameters
	@RequestMapping(value = "/rm/bars", method = GET)
	@ResponseBody
	public String getBarBySimplePathWithRequestParam(@RequestParam("id") long id) {
		return "Get a specific Bar with id=" + id;
	}

	@RequestMapping(value = "/rm/bars", params = { "id", "second" }, method = GET)
	@ResponseBody
	public String getBarBySimplePathWithExplicitRequestParams(@RequestParam("id") long id) {
		return "Narrow Get a specific Bar with id=" + id;
	}

	// @RequestParam Corner cases :
	// @RequestMapping — Multiple Paths Mapped to the Same Controller Method
	@RequestMapping(value = { "/ex/advanced/bars", "/ex/advanced/foos" }, method = GET)
	@ResponseBody
	public String getFoosOrBarsByPath() {
		return "Advanced - Get some Foos or Bars";
	}

	// @RequestMapping — Multiple HTTP Request Methods to the Same Controller Method
	@RequestMapping(value = "/ex/foos/multiple", method = { PUT, POST })
	@ResponseBody
	public String putAndPostFoos() {
		return "Advanced - PUT and POST within single method";
	}

	// @RequestMapping — a Fallback for All Requests
	@RequestMapping(value = "*", method = { GET, POST.PUT, DELETE, PATCH })
	@ResponseBody
	public String allFallback() {
		return "Fallback for All Requests";
	}

	// Ambigious Error Mapping
	@GetMapping(value = "foos/duplicate")
	public String duplicate() {
		return "Duplicate";
	}

	@GetMapping(value = "foos/duplicate")
	public String duplicateEx() {
		return "Duplicate";
	}

	/*BELOW EXCEPTION Will be thrown in above case
	 * Caused by: java.lang.IllegalStateException: Ambiguous mapping. Cannot map
	 * 'fooMappingExamplesController' method public java.lang.String
	 * org.baeldung.web.controller.FooMappingExamplesController.duplicateEx() to
	 * {[/ex/foos/duplicate],methods=[GET]}: There is already
	 * 'fooMappingExamplesController' bean method public java.lang.String
	 * org.baeldung.web.controller.FooMappingExamplesController.duplicate() mapped.
	 */
	
	// But if the content return is changed then it will not return any exception 
	@GetMapping(value = "foos/duplicate", produces = MediaType.APPLICATION_XML_VALUE)
	public String duplicateXml() {
	    return "<message>Duplicate</message>";
	}
	    
	@GetMapping(value = "foos/duplicate", produces = MediaType.APPLICATION_JSON_VALUE)
	public String duplicateJson() {
	    return "{\"message\":\"Duplicate\"}";
	}
}
