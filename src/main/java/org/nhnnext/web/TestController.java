package org.nhnnext.web;

import java.util.ArrayList;
import java.util.List;

import org.nhnnext.domain.Course;
import org.nhnnext.domain.Instructor;
import org.nhnnext.domain.User;
import org.nhnnext.domain.repository.CourseRepository;
import org.nhnnext.domain.repository.InstructorRepository;
import org.nhnnext.domain.repository.LectureRepository;
import org.nhnnext.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
public class TestController {

	private final UserRepository userRepository;
	private final LectureRepository lectureRepository;
	private final CourseRepository courseRepository;
	private final InstructorRepository instructorRepository;
    
    @CrossOrigin
	@GetMapping("/courses")
	public ArrayList<Instructor> getLectures() {
    	
    	Instructor backProfessor = instructorRepository.findByNickname("Javajigi");
    	List<Course> backendLectures = courseRepository.findByInstructor(backProfessor);
    	backProfessor.setLectures(backendLectures);
    	
    	Instructor frontProfessor = instructorRepository.findByNickname("Artist");
    	List<Course> frontendLectures = courseRepository.findByInstructor(frontProfessor);
    	frontProfessor.setLectures(frontendLectures);
    	
    	ArrayList<Instructor> professors = new ArrayList<Instructor>();
    	professors.add(backProfessor);
    	professors.add(frontProfessor);
    	
		return professors;
	}
    
  @CrossOrigin
  @RequestMapping("/me/courses/participate")
  public List<Course> MyLecture(){
  	
	  	Course e1 = courseRepository.findOne((long) 1);
	  	Course e2 = courseRepository.findOne((long) 2);
	  	Course e3 = courseRepository.findOne((long) 3);

		ArrayList<Course> participateLectures = new ArrayList<Course>();
		participateLectures.add(e1);
		participateLectures.add(e2);
		participateLectures.add(e3);
	
	   User itsloog = userRepository.findByNickname("itsloog");
	   itsloog.setLectures(participateLectures);
	   userRepository.save(itsloog);
	  
	  return itsloog.getLectures();
  }
  
  @CrossOrigin
  @RequestMapping("/courses/{id}")
  public List<Course> getCourses(){
  	
	  	Course e1 = courseRepository.findOne((long) 1);
//	  	ArrayList<Course> courseList = new ArrayList<Course>();
//	  	e1.setCourses(courses);
	  	Course e2 = courseRepository.findOne((long) 2);
	  	Course e3 = courseRepository.findOne((long) 3);

		ArrayList<Course> participateLectures = new ArrayList<Course>();
		participateLectures.add(e1);
		participateLectures.add(e2);
		participateLectures.add(e3);
	
	   User itsloog = userRepository.findByNickname("itsloog");
	   itsloog.setLectures(participateLectures);
	   userRepository.save(itsloog);
	  
	  return itsloog.getLectures();
  }
    
}

