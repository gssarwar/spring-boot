package com.gs.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	
	
	List<Topic> topics =new ArrayList<Topic>(Arrays.asList(
			new Topic("spring", "spring course", "spring course desc"),
			new Topic("java", "java course", "java course desc"),
			new Topic("javascript", "javascript course", "javascript course desc")
			));
	/**
	 * 
	 * @return
	 */
	public List<Topic> getAllTopics()
	{
		return topics;
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Topic getTopic(String id)
	{
		return topics.stream().filter(t ->t.getId().equals(id)).findFirst().get();
	}
	/**
	 * 
	 * @param topic
	 */
	public void addTopic(Topic topic) {
		topics.add(topic);
	}
	/**
	 * 
	 */
	public void updateTopic(String id, Topic topic) {
		
			for(int i=0;i<topics.size();i++)
			{
				Topic t = topics.get(i);
				if(t.getId().equals(id))
				{
					topics.set(i, topic);
					return;
				}
			}
		
	}
	public void deleteTopic(String id) {
			
		topics.removeIf(t ->t.getId().equals(id));
	}

}
