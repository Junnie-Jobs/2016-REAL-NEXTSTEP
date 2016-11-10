package org.nhnnext;

import java.util.ArrayList;

import org.nhnnext.domain.Course;
import org.nhnnext.domain.CourseState;
import org.nhnnext.domain.User;
import org.nhnnext.domain.repository.CourseRepository;
import org.nhnnext.domain.repository.LectureRepository;
import org.nhnnext.domain.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// name, state, instructors, participants
	@Bean
	public CommandLineRunner demo(LectureRepository lectureRepository, UserRepository userRepository,
			CourseRepository courseRepository) {
		return (args) -> {

			CourseState upcoming = CourseState.UPCOMING;
			CourseState inSession = CourseState.IN_SESSION;

			ArrayList<User> backEndProfessors = new ArrayList<User>();
			ArrayList<User> frontEndProfessors = new ArrayList<User>();

			User u1 = new User("박재성", "Javajigi", "https://avatars2.githubusercontent.com/u/520500?v=3&s=400", 1);
			User u2 = new User("서경진", "Artist",
					"https://scontent-icn1-1.xx.fbcdn.net/v/l/t1.0-9/246558_465884496764786_1789276701_n.jpg?oh=14f0129a35a51c53b70fbc095ba42df2&oe=589D38A3",
					1);
			User u3 = new User("최연규", "itsloog",
					"https://scontent-icn1-1.xx.fbcdn.net/v/t1.0-9/14494785_1303032459755018_522118762631698008_n.jpg?oh=3fa832407d4254f7e97fcba1b70d3f40&oe=58AD5DA2",
					0);
			
			Course e1 = new Course("jwp-adv", inSession, u1);
			Course e2 = new Course("jwp-basic", upcoming, u1);
			Course e3 = new Course("jwp-nextStep", upcoming, u1);
			
			u1.addCourse(e1);
			u1.addCourse(e2);
			u1.addCourse(e3);
//			System.out.println(u1);
//			
			userRepository.save(u1);
			userRepository.save(u2);
			userRepository.save(u3);
////
			backEndProfessors.add(u1);
			frontEndProfessors.add(u2);

			Course e4 = new Course("HCI", inSession, u2);
			Course e5 = new Course("DataVisualization", inSession, u2);
			Course e6 = new Course("jwp-adv", inSession, u2);
//			
//			u2.addCourse(e4);
//			u2.addCourse(e5);
//			u2.addCourse(e6);

			courseRepository.save(e1);
			courseRepository.save(e2);
			courseRepository.save(e3);
			courseRepository.save(e4);
			courseRepository.save(e5);
			courseRepository.save(e6);

		};
	}
}
