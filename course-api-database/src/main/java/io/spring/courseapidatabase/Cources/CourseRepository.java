package io.spring.courseapidatabase.Cources;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface CourseRepository extends CrudRepository<Courses, String>{		

	public List<Courses> findByTopicsId(String topicsId);
}
