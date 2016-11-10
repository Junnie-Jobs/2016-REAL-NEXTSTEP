package org.nhnnext.web;

import java.util.ArrayList;
import java.util.List;

import org.nhnnext.domain.Course;
import org.nhnnext.domain.Lecture;
import org.nhnnext.domain.User;
import org.nhnnext.domain.repository.CourseRepository;
import org.nhnnext.domain.repository.LectureRepository;
import org.nhnnext.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
public class TestController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private LectureRepository lectureRepository;
	
	@Autowired
	private CourseRepository courseRepository;

    
    @CrossOrigin
	@GetMapping("/courses") //All courses
	public ArrayList<User> getLectures() {
    	
    	User backProfessor = userRepository.findByNickname("Javajigi");    	
    	User frontProfessor = userRepository.findByNickname("Artist");
    	
    	ArrayList<User> professors = new ArrayList<User>();
    	professors.add(backProfessor);
    	professors.add(frontProfessor);
    	
    	System.out.println("과연");
    	System.out.println(backProfessor.getCourses());
    	
		return professors;
	}
    
  @CrossOrigin
  @RequestMapping("/me/courses/participate")
  public List<Course> MyLecture(){
  	
	  	Course e1 = courseRepository.findOne((long) 1);
	  	Course e2 = courseRepository.findOne((long) 2);
	  	Course e3 = courseRepository.findOne((long) 3);

		ArrayList<Course> participateCourses = new ArrayList<Course>();
		participateCourses.add(e1);
		participateCourses.add(e2);
		participateCourses.add(e3);
	
	   User itsloog = userRepository.findByNickname("itsloog");
	   itsloog.setCourses(participateCourses);
	   userRepository.save(itsloog);
	  
	  return itsloog.getCourses();
  }
//  
//  @CrossOrigin
//  @RequestMapping("/courses/{id}")
//  public ArrayList<Lecture> getCourses(@PathVariable Long id){
//	  
//	  	Course course = courseRepository.findOne(id);
//	  	System.out.println("교수자는?");
//	  	System.out.println(course);
//	  	Lecture l1 = new Lecture("test-1"+id, course);
//	  	Lecture l2 = new Lecture("test-2"+id, course);
//	  	Lecture l3 = new Lecture("test-3"+id, course);
//	  	lectureRepository.save(l1);
//	  	System.out.println("첫번쨰 렉처");
//	  	System.out.println(l1);
//	  	lectureRepository.save(l2);
//	  	lectureRepository.save(l3);
//	  	courseRepository.save(course);
//
////	  	System.out.println(courseRepository.findAll());
////		ArrayList<Lecture> lectures = lectureRepository.findByCourse(course);
//	
//	  return (ArrayList<Lecture>) lectureRepository.findAll();
//  }
//    
}

