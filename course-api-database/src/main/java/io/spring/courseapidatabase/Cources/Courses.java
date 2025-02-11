package io.spring.courseapidatabase.Cources;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.spring.courseapidatabase.Topics.Topics;

@Entity
public class Courses {
	
	@Id
	private String id;
	private String name;
	private String description;
	
	@ManyToOne
	private Topics topics;
	
	
	public Topics getTopics() {
		return topics;
	}

	public void setTopics(Topics topics) {
		this.topics = topics;
	}

	public Courses() {
	}
	
	public Courses(String id, String name, String description, String topicId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.topics=new Topics(topicId, "", "");
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
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
