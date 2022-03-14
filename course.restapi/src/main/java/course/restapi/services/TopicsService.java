package course.restapi.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import course.restapi.controller.TopicRepository;
import course.restapi.pojo.Topics;

@Service                      // @Service mark this class as a Service in Spring Application 
public class TopicsService {
	
		private TopicRepository topicRepository ;
	
		/*
		private List<Topics> topics = 	new ArrayList<> (Arrays.asList(
			new Topics("spring","Spring framework","Spring framework Description"),
			new Topics("java","Java EE","core java Description"),
			new Topics("javascript","Javascript ES6","Javascript Description")
			));
			*/

		public List<Topics> getAllTopics()
		{
			//return topics ;
			List<Topics> topics = new ArrayList<>() ;
			topicRepository.findAll().forEach(topics::add);
			return topics ;
			
		}

		public Topics getTopic(String id) {
			//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get() ;
			
			Topics t = topicRepository.findById(id).get() ;
			return t ;
		}

		public void addTopic(Topics topic) {
			topicRepository.save(topic)  ;
		}

		public void updateTopic(String id, Topics topic) {
			
			topicRepository.save(topic)  ;   // add and update works as same
			
			/*for(int i =0 ; i < topics.size() ;i++)
			{
				Topics t = topics.get(i) ;
				if(t.getId().equals(id))
				{
					topics.set(i, topic) ;
					return ;
				}
			}
			*/
		}

		public void deleteTopic(String id) {
			//topics.removeIf(t -> t.getId().equals(id)) ;
			
			topicRepository.deleteById(id);
		}
}
