package org.nhnnext.web;

import java.util.ArrayList;
import java.util.List;

import org.nhnnext.domain.Course;
import org.nhnnext.domain.Instructor;
import org.nhnnext.domain.Lecture;
import org.nhnnext.domain.Student;
import org.nhnnext.domain.User;
import org.nhnnext.domain.repository.CourseRepository;
import org.nhnnext.domain.repository.InstructorRepository;
import org.nhnnext.domain.repository.LectureRepository;
import org.nhnnext.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
public class TestController {

	private final UserRepository userRepository;
	private final LectureRepository lectureRepository;
	private final CourseRepository courseRepository;
	private final InstructorRepository instructorRepository;
    
    @CrossOrigin(origins = "http://localhost:3001")
	@GetMapping("/lectures")
	public ArrayList<Instructor> getLectures() {
    	
    	Instructor backProfessor = instructorRepository.findByNickname("Javajigi");
    	List<Lecture> backendLectures = lectureRepository.findByInstructor(backProfessor);
    	backProfessor.setLectures(backendLectures);
    	
    	Instructor frontProfessor = instructorRepository.findByNickname("Artist");
    	List<Lecture> frontendLectures = lectureRepository.findByInstructor(frontProfessor);
    	frontProfessor.setLectures(frontendLectures);
    	
    	ArrayList<Instructor> professors = new ArrayList<Instructor>();
    	professors.add(backProfessor);
    	professors.add(frontProfessor);
    	
		return professors;
	}
    
//    @CrossOrigin(origins = "http://localhost:3001")
//    @RequestMapping("/courses")
//    public ArrayList<Course> getCourses{
//    	
//  	   Student s1 = (Student)userRepository.findByNickname("itsloog");
//  	   Instructor backProfessor = instructorRepository.findByNickname("Javajigi");
//  	   List<Lecture> backendLectures = lectureRepository.findByInstructor(backProfessor);
//  	   System.out.println(s1.getLectures());
//  	  
//  	  return null;
//    }
    
  // GET /me/lectures/{instruct,participate}
    
  @CrossOrigin(origins = "http://localhost:3001")
  @RequestMapping("/lecture")
  public Lecture addMyLecture(){
  	
	   Student s1 = (Student)userRepository.findByNickname("itsloog");
	   Instructor backProfessor = instructorRepository.findByNickname("Javajigi");
	   List<Lecture> backendLectures = lectureRepository.findByInstructor(backProfessor);
	   System.out.println(s1.getLectures());
	  
	  return backendLectures.get(1);
  }
    
}

