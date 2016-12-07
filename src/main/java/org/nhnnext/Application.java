package org.nhnnext;

import java.util.ArrayList;
import java.util.HashSet;

import org.nhnnext.domain.Course;
import org.nhnnext.domain.Lecture;
import org.nhnnext.domain.Lesson;
import org.nhnnext.domain.SecurityUser;
import org.nhnnext.domain.User;
import org.nhnnext.repository.CourseRepository;
import org.nhnnext.repository.LectureRepository;
import org.nhnnext.repository.LessonRepository;
import org.nhnnext.repository.MySessionRepository;
import org.nhnnext.repository.SecurityUserRepository;
import org.nhnnext.repository.UserRepository;
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
	public CommandLineRunner demo(LectureRepository lectureRepository, UserRepository userRepository,
			CourseRepository courseRepository, MySessionRepository sessionRepository, SecurityUserRepository securityUserRepository, LessonRepository lessonRepository) {
		return (args) -> {

			User student1 = new User();
			student1.setName("Choi Yeonkyu");
			student1.setAvatarUrl("https://scontent-icn1-1.xx.fbcdn.net/v/t1.0-9/14494785_1303032459755018_522118762631698008_n.jpg?oh=3fa832407d4254f7e97fcba1b70d3f40&oe=58AD5DA2");
			userRepository.save(student1);
			
			User student2 = new User();
			student2.setName("Lim Dongjun");
			student2.setAvatarUrl("https://avatars2.githubusercontent.com/u/3433096?v=3&s=460");
			userRepository.save(student2);
			
			User student3 = new User();
			student3.setName("Seo Jaewon");
			student3.setAvatarUrl("https://scontent.xx.fbcdn.net/v/t1.0-9/230403_368531479891429_635986668_n.jpg?oh=a42efa9e657826e57a96db008960b817&oe=58C68AA9");
			userRepository.save(student3);
			
			User professor1 = new User();
			professor1.setName("Javajigi");
			professor1.setAvatarUrl("https://avatars2.githubusercontent.com/u/520500?v=3&s=400");
			userRepository.save(professor1);
			
			SecurityUser manager = new SecurityUser("testuser", "password", "ROLE_INSTRUCTOR");
			securityUserRepository.save(manager);
			
			Course course = new Course();
			course.setName("jwp-basic");
			course.setInstructors(new HashSet<>());
			course.getInstructors().add(professor1);
			course.setParticipants(new HashSet<>());
			course.getParticipants().add(student1);
			course.getParticipants().add(student2);
			course.getParticipants().add(student3);
			course.setInstructor(manager);
			courseRepository.save(course);
		
			course.setLectures(new ArrayList<>());	
			Lecture lecture1 = new Lecture();
			lecture1.setTitle("Orientation");
			lecture1.setCourse(course);
			lectureRepository.save(lecture1);
			Lecture lecture2 = new Lecture();
			lecture2.setTitle("Frist Week");
			lecture2.setCourse(course);
			lectureRepository.save(lecture2);
			Lecture lecture3 = new Lecture();
			lecture3.setTitle("Second Week");
			lecture3.setCourse(course);
			lectureRepository.save(lecture3);
			course.getLectures().add(lecture1);
			course.getLectures().add(lecture2);
			course.getLectures().add(lecture3);
			courseRepository.save(course);
		
			lecture1.setLessons(new ArrayList<Lesson>());			
			Lesson lesson1 = new Lesson();
			lesson1.setTitle("학습목표 1");
			lesson1.setContent("첫 번째 내용");
			lesson1.setLecture(lecture1);
			lecture1.getLessons().add(lesson1);
			lectureRepository.save(lecture1);
			lessonRepository.save(lesson1);

			Lesson lesson2 = new Lesson();
			lesson2.setTitle("학습목표 2");
			lesson2.setContent("두 번째 내용");
			lesson2.setLecture(lecture1);
			lecture1.getLessons().add(lesson2);
			lectureRepository.save(lecture1);
			lessonRepository.save(lesson2);
			
			Lesson lesson3 = new Lesson();
			lesson3.setTitle("학습목표 3");
			lesson3.setContent("세 번째 내용");
			lesson3.setLecture(lecture1);
			lecture1.getLessons().add(lesson3);
			lectureRepository.save(lecture1);
			lessonRepository.save(lesson3);
						
			Course course2 = new Course();
			course2.setName("jwp-adv");
			course2.setInstructors(new HashSet<>());
			course2.getInstructors().add(professor1);
			course2.setParticipants(new HashSet<>());
			course2.getParticipants().add(student1);
			course2.getParticipants().add(student2);
			course2.getParticipants().add(student3);
			courseRepository.save(course2);
					
		};
	
	
	
	}	
}
