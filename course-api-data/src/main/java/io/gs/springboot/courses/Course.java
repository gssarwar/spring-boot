package io.gs.springboot.courses;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.gs.springboot.topics.Topic;

@Entity
public class Course {
	@Id
	private String id;
	private String name ;
	private String description;
	@ManyToOne(fetch=FetchType.LAZY)
	private Topic topic;
	
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public Course() {}
	public Course(String id, String name, String discription,String topicId) {
		super();
		this.id = id;
		this.name = name;
		this.description = discription;
		this.topic = new Topic(topicId,"","");
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDiscription() {
		return description;
	}
	public void setDiscription(String discription) {
		this.description = discription;
	}
	
	
}
