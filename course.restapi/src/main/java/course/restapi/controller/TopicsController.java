package course.restapi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import course.restapi.pojo.Topics;
import course.restapi.services.TopicsService;

@RestController
public class TopicsController {
	
	@Autowired      //  Declares a dependency which needs to be injected
	private TopicsService topicServices ;    

	
	//Simple HTTP GET Request 
	@RequestMapping("/topics")
	public List<Topics> getTopics()
	{
		return topicServices.getAllTopics() ;
	}
	
	// HTTP GET Request with a variable in URI   --  it will fetch the data present in topics
	@RequestMapping("/topics/{id}")    // Request Mapping annotation in case variable is passed onto URL
	public Topics getTopic(@PathVariable String id)   // Path Variable annotation tells to choose variable from path in RequestMapping
	{
		return topicServices.getTopic(id) ;
	}
	
	//Simple HTTP POST Request  -- it will create a new record in topics
	@RequestMapping(method = RequestMethod.POST , value = "/topics")
	public void addTopic(@RequestBody Topics topic)
	{
		topicServices.addTopic(topic) ;
	}
	
	//Simple HTTP PUT Request -- it will update an existing record
	@RequestMapping(method = RequestMethod.PUT , value = "/topics/{id}")
	public void updateTopic(@RequestBody Topics topic, @PathVariable String id )
	{
		topicServices.updateTopic(id,topic) ;
	}
	
	//Simple HTTP DELETE Request  --  it will delete an existing record from topics
	@RequestMapping(method = RequestMethod.DELETE , value = "/topics/{id}")
	public void deleteTopic(@PathVariable String id )
	{
		topicServices.deleteTopic(id) ;
	}
	
}
