package org.nhnnext.nextstep;

import org.nhnnext.nextstep.course.CourseRepository;
import org.nhnnext.nextstep.enrollment.EnrollmentRepository;
import org.nhnnext.nextstep.lecture.LectureRepository;
import org.nhnnext.nextstep.lesson.LessonRepository;
import org.nhnnext.nextstep.session.CourseSessionRepository;
import org.nhnnext.nextstep.user.InstructorRepository;
import org.nhnnext.nextstep.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(LectureRepository lectureRepository, UserRepository userRepository, InstructorRepository instructorRepository,
			CourseRepository courseRepository, CourseSessionRepository courseSessionRepository, LessonRepository lessonRepository, EnrollmentRepository enrollmentRepository) {
		return (args) -> {

		};	
}
}
