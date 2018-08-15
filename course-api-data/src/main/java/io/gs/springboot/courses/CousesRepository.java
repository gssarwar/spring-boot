package io.gs.springboot.courses;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CousesRepository extends CrudRepository<Course,String>
{
	List<Course> findByName(String name);//to find by name  
	List<Course> findByDescription(String description);//to find by the description
	
	List<Course> findByTopicId(String topicId);
}
