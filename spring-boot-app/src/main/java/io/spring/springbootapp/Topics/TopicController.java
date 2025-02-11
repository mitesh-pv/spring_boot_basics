package io.spring.springbootapp.Topics;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping(method=RequestMethod.GET, value="/topics")
	public List<Topics> getTopics(){
		return topicService .getAllTopics();
	}
	
	@RequestMapping(method=RequestMethod.GET,value= "/topics/{id}")
	public Topics getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	// adding a post request
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopics(@RequestBody Topics topic) {
		topicService.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@RequestBody Topics topic, @PathVariable String id) {
		topicService.updateTopic(id, topic);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}
}
