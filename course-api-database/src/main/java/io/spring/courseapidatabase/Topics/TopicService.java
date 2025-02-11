package io.spring.courseapidatabase.Topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topics> getAllTopics(){
		// return topics;
		List<Topics> topics=new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Optional<Topics> getTopic(String id) {
		// return topics.stream().filter(topic->topic.getId().equals(id)).findFirst().get();
		return topicRepository.findById(id);
	}

	public void addTopics(Topics topic) {
		//	topics.add(topic);
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topics topic) {
		topicRepository.save(topic);
	}

	public void deleteTopic(String id) {
		topicRepository.deleteById(id);	
	}
}