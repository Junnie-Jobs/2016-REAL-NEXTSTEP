package org.nhnnext.nextstep.course.web;

import java.util.ArrayList;
import java.util.List;

import org.nhnnext.nextstep.course.Course;
import org.nhnnext.nextstep.course.CourseRepository;
import org.nhnnext.nextstep.user.AuthenticationUtils;
import org.nhnnext.nextstep.user.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@RequestMapping(value = "/Mine", method = RequestMethod.GET)
	public void getMyCourses(Authentication authentication){
		
		List<Instructor> arr = new ArrayList<Instructor>();
		List<Course> arr2 = new ArrayList<Course>();
		
		arr2 = courseRepository.findAll();
		
		for(int i=0; i< arr2.size(); i++){
			Course c1 = arr2.get(i);
			arr2.get(i).getInstructors();
		}
		
//		   public boolean isInstructor(Authentication authentication) {
//		        return getInstructors().contains(AuthenticationUtils.getUser(authentication));
//		    }
		
	}
	





	public void getMyPublishedCourses(){
		
	}

}
