package io.spring.springbootapp.Topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
		
	private List<Topics> topics = new ArrayList<>(Arrays.asList(
			new Topics("spring", "Spring framework", "spring framework description"),
			new Topics("Java", "core java", "java framework description"),
			new Topics("javascript", "java script framework", "java script framework description")
		));
	
	public List<Topics> getAllTopics(){
		return topics;
	}
	
	public Topics getTopic(String id) {
		return topics.stream().filter(topic->topic.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topics topic) {
		topics.add(topic);
	}

	public void updateTopic(String id, Topics topic) {
		for(int i=0; i<topics.size(); ++i) {
			if(topics.get(i).getId().equals(id)) {
				topics.set(i, topic);
				return ;
			}
		}
	}

	public void deleteTopic(String id) {
		topics.removeIf(topic->topic.getId().equals(id));	
	}
}