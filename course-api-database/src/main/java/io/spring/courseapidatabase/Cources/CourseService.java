package io.spring.courseapidatabase.Cources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Courses> getAllCourses(String topicId){
		// first find out all topics which are inside a particular topic, and then carry out the search for 
		// the courses inside that Topic
		List<Courses> courses = new ArrayList<>();
		courseRepository.findByTopicsId(topicId).forEach(courses::add);
		return courses;
	}
	
	public Optional<Courses> getCourse(String id) {
		// return topics.stream().filter(topic->topic.getId().equals(id)).findFirst().get();
		return courseRepository.findById(id);
	}

	public void addCourse(Courses course) {
		//	topics.add(topic);
		courseRepository.save(course);
	}

	public void updateCourse(Courses course) {
		courseRepository.save(course);
	}

	public void deleteCourse(String id) {
		courseRepository.deleteById(id);	
	}
}