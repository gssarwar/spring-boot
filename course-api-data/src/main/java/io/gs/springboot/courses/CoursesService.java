package io.gs.springboot.courses;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoursesService {
	
	
	
	@Autowired 
	CousesRepository topicRepository;
	/**
	 * 
	 * @return
	 */
	public List<Course> getAllCouses(String topicId)
	{
		List<Course> courses = new ArrayList<>();
		topicRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Course getCourse(String id)
	{
		return topicRepository.findOne(id);
	}
	/**
	 * 
	 * @param topic
	 */
	public void addCourse(Course course) {
		topicRepository.save(course);
	}
	/**
	 * 
	 */
	public void updateCourse(Course course) {
		topicRepository.save(course);
		
	}
	public void deleteCourse(String id) {
			
		topicRepository.delete(id);
	}
	public List<Course> findByTopicId(String topicId) {
		// TODO Auto-generated method stub
		return null;
	}

}
