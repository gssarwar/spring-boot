package io.gs.springboot.topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	
	
	@Autowired 
	TopicRepository topicRepository;
	/**
	 * 
	 * @return
	 */
	public List<Topic> getAllTopics()
	{
		List<Topic> topis = new ArrayList<>();
		topicRepository.findAll().forEach(topis::add);
		return topis;
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Topic getTopic(String id)
	{
		return topicRepository.findOne(id);
	}
	/**
	 * 
	 * @param topic
	 */
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}
	/**
	 * 
	 */
	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
		
	}
	public void deleteTopic(String id) {
			
		topicRepository.delete(id);
	}

}
