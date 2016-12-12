package org.nhnnext.nextstep.web;

import org.nhnnext.nextstep.course.CourseRepository;
import org.nhnnext.nextstep.session.SessionRepository;
import org.nhnnext.nextstep.user.UserRepository;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MyTestController {

	private final UserRepository userRepository;
	private final CourseRepository courseRepository;
	private final SessionRepository sessionRepository;

//	@GetMapping("/test")
//    public String test() {
//	    User user = new User();
//	    user.setName("name");
//        Instructor instructor = new Instructor();
//        instructor.setName("instructor");
//        userRepository.save(user);
//        userRepository.save(instructor);
//
//        Course course = new Course();
//        course.setName("name");
//        course.setDescription("description");
//        course.getInstructors().add(instructor);
//        courseRepository.save(course);
//
////        CourseSession session = new CourseSession();
////        session.setName("name");
////        session.setCourse(course);
////        sessionRepository.save(session);
//
////        course.setMasterSession(new MasterSession());
////        course.getSessions().add(new CourseSession("default"));
//        course.addToSessions(new CourseSession("default"));
//        courseRepository.save(course);
//
//	    return "ok";
//    }
}
