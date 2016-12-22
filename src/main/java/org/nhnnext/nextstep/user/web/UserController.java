package org.nhnnext.nextstep.user.web;

import lombok.RequiredArgsConstructor;

import org.nhnnext.nextstep.course.Course;
import org.nhnnext.nextstep.course.CourseRepository;
import org.nhnnext.nextstep.user.Instructor;
import org.nhnnext.nextstep.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Transient;

@RequiredArgsConstructor
@RestController
public class UserController {

	private final UserService service;

	@Autowired
	private CourseRepository courseRepository;

	@PreAuthorize("isAuthenticated()")
	@GetMapping("/api/user")
	public Map<String, Object> getAuthenticatedUser(Authentication authentication) {
		Map<String, Object> map = new HashMap<>();
		map.put("user", service.getAuthenticatedUser().orElseGet(null));
		map.put("authorities", authentication.getAuthorities());
		return map;
	}

	@GetMapping("/api/myCourses")
	public List<Course> getMyCourses(Authentication authentication) {

		System.out.println(authentication);
		List<Course> arr2 = new ArrayList<Course>();
		arr2 = courseRepository.findAll();

		List<Course> arr4 = new ArrayList<Course>();

		for (int i = 0; i < arr2.size(); i++) {
			Course c1 = arr2.get(i);
			List<Instructor> arr3 = arr2.get(i).getInstructors();

			for (int j = 0; j < arr3.size(); j++) {

				if (authentication.getName().equals(arr3.get(j).getName())) {
					arr4.add(arr2.get(i));
				}
			}
		}

		System.out.println("나의 개설 강좌목록은 ");
		System.out.println(arr4);
		
		return arr4;

	}

	// @Autowired
	// private CourseRepository courseRepository;
	//
	// @RequestMapping(value = "/Mine", method = RequestMethod.GET)
	// public void getMyCourses(Authentication authentication){
	//
	// List<Instructor> arr = new ArrayList<Instructor>();
	// List<Course> arr2 = new ArrayList<Course>();
	//
	// arr2 = courseRepository.findAll();
	//
	// for(int i=0; i< arr2.size(); i++){
	// Course c1 = arr2.get(i);
	// arr2.get(i).getInstructors();
	// }
	//
	//// public boolean isInstructor(Authentication authentication) {
	//// return
	// getInstructors().contains(AuthenticationUtils.getUser(authentication));
	//// }

	// @PreAuthorize("isAuthenticated()")
	// @GetMapping("/api/user")
	// public Principal user(Principal principal) {
	// return principal;
	// }
}
