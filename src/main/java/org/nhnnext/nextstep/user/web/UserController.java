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
	
}
