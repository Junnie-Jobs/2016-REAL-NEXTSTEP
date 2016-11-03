package org.nhnnext;

import java.util.ArrayList;

import org.nhnnext.domain.Instructor;
import org.nhnnext.domain.Lecture;
import org.nhnnext.domain.LectureState;
import org.nhnnext.domain.Student;
import org.nhnnext.domain.User;
import org.nhnnext.domain.repository.CourseRepository;
import org.nhnnext.domain.repository.InstructorRepository;
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
	
	//name, state, instructors, participants
	@Bean
	public CommandLineRunner demo(LectureRepository lectureRepository, UserRepository userRepository, CourseRepository courseRepository, InstructorRepository instructorRepository) {
		return (args) -> {
			
			LectureState upcoming = LectureState.UPCOMING;
			LectureState inSession = LectureState.IN_SESSION;
			
			ArrayList<User> backEndProfessors = new ArrayList<User>();
			ArrayList<User> frontEndProfessors = new ArrayList<User>();
						
			User u1 = new Instructor("박재성", "Javajigi", "https://avatars2.githubusercontent.com/u/520500?v=3&s=400", 1);
			User u2 = new Instructor("서경진", "Artist", "https://scontent-icn1-1.xx.fbcdn.net/v/l/t1.0-9/246558_465884496764786_1789276701_n.jpg?oh=14f0129a35a51c53b70fbc095ba42df2&oe=589D38A3", 1);
			User u3 = new Student("최연규", "itsloog", "https://scontent-icn1-1.xx.fbcdn.net/v/t1.0-9/14494785_1303032459755018_522118762631698008_n.jpg?oh=3fa832407d4254f7e97fcba1b70d3f40&oe=58AD5DA2", 0);
			
			userRepository.save(u1);
			userRepository.save(u2);
			userRepository.save(u3);
			
			backEndProfessors.add(u1);			
			frontEndProfessors.add(u2);			
			
			Lecture e1 = new Lecture("jwp-adv", inSession, u1);
			Lecture e2 = new Lecture("jwp-basic", upcoming, u1);
			Lecture e3 = new Lecture("jwp-nextStep", upcoming, u1);
			Lecture e4 = new Lecture("HCI", inSession, u2);
			Lecture e5 = new Lecture("DataVisualization", inSession, u2);
			Lecture e6 = new Lecture("jwp-adv", inSession, u2);
			
			lectureRepository.save(e1);
			lectureRepository.save(e2);
			lectureRepository.save(e3);
			lectureRepository.save(e4);
			lectureRepository.save(e5);
			lectureRepository.save(e6);

		};
	}
}
