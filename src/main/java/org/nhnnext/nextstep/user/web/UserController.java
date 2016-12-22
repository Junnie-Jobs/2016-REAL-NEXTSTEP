package org.nhnnext.nextstep.user.web;

import java.util.HashMap;
import java.util.Map;
import org.nhnnext.nextstep.course.CourseRepository;
import org.nhnnext.nextstep.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

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
