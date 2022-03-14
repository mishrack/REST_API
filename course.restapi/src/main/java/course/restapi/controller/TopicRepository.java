package course.restapi.controller;

import course.restapi.pojo.Topics;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topics, String>{

	// CrudRepository is an interface which comes with some useful methods for DataJPA
	// first argument is the type which you want to make it as Entity and second argument is the ID in this case is String 
}
