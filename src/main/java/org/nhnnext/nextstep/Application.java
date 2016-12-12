package org.nhnnext.nextstep;
import org.nhnnext.nextstep.course.Course;
import org.nhnnext.nextstep.course.CourseRepository;
import org.nhnnext.nextstep.lecture.LectureRepository;
import org.nhnnext.nextstep.lesson.LessonRepository;
import org.nhnnext.nextstep.session.CourseSession;
import org.nhnnext.nextstep.session.MasterSession;
import org.nhnnext.nextstep.session.MasterSessionRepository;
import org.nhnnext.nextstep.session.Session;
import org.nhnnext.nextstep.session.CourseSessionRepository;
import org.nhnnext.nextstep.user.Instructor;
import org.nhnnext.nextstep.user.User;
import org.nhnnext.nextstep.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.util.ReflectionUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	@Bean
	public CommandLineRunner demo(LectureRepository lectureRepository, UserRepository userRepository,
			CourseRepository courseRepository, CourseSessionRepository courseSessionRepository, MasterSessionRepository masterSessionRepository, LessonRepository lessonRepository) {
		return (args) -> {

			Field usernameField = ReflectionUtils.findField(User.class, "username");
			ReflectionUtils.makeAccessible(usernameField);
			
			User student1 = new User();
			ReflectionUtils.setField(usernameField, student1, "dayBrush");
			student1.setName("Choi Yeonkyu");
			student1.setAvatarUrl("https://scontent-icn1-1.xx.fbcdn.net/v/t1.0-9/14494785_1303032459755018_522118762631698008_n.jpg?oh=3fa832407d4254f7e97fcba1b70d3f40&oe=58AD5DA2");
			userRepository.save(student1);
			
			User student2 = new User();
			Field student2UsernameField = ReflectionUtils.findField(User.class, "username");
			ReflectionUtils.makeAccessible(student2UsernameField);
			ReflectionUtils.setField(student2UsernameField, student2, "junniejobs");
			student2.setName("Lim Dongjun");
			student2.setAvatarUrl("https://avatars2.githubusercontent.com/u/3433096?v=3&s=460");
			userRepository.save(student2);
//			
			User student3 = new User();
			Field student3UsernameField = ReflectionUtils.findField(User.class, "username");
			ReflectionUtils.makeAccessible(student3UsernameField);
			ReflectionUtils.setField(student3UsernameField, student3, "Byeol");
			student3.setName("Seo Jaewon");
			student3.setAvatarUrl("https://scontent.xx.fbcdn.net/v/t1.0-9/230403_368531479891429_635986668_n.jpg?oh=a42efa9e657826e57a96db008960b817&oe=58C68AA9");
			userRepository.save(student3);
			
			Instructor professor1 = new Instructor();
			Field professorUsernameField = ReflectionUtils.findField(Instructor.class, "username");
			ReflectionUtils.makeAccessible(professorUsernameField);
			ReflectionUtils.setField(professorUsernameField, professor1, "javajigi");
			professor1.setName("jaesung");
			professor1.setAvatarUrl("https://avatars2.githubusercontent.com/u/520500?v=3&s=400");
			userRepository.save(professor1);
			
			MasterSession masterSession = new MasterSession("JWP-master");
			Course course = new Course(masterSession);
			course.setName("jwp-basic");
			course.getInstructors().add(professor1);
			courseRepository.save(course);
		
			masterSession.setCourse(course);
			masterSessionRepository.save(masterSession);
			
			CourseSession session1 = new CourseSession("2016-01-JWP");
			session1.setCourse(course);
			courseSessionRepository.save(session1);
//			
			CourseSession session2 = new CourseSession("2016-02-JWP");
			session2.setCourse(course);
			courseSessionRepository.save(session2);
			
			CourseSession session3 = new CourseSession("2016-03-JWP");
			session3.setCourse(course);
			courseSessionRepository.save(session3);

//			Session session1 = new Session();
//			session1.setCourse(course);
//			session1.setName("jwp-basic-2016-1");
//			session1.setInstructors(course.getInstructors());
//			session1.setDescription(course.getDescription());
//			session1.setParticipants(course.getParticipants());
//			sessionRepository.save(session1);
//			course.getSessions().add(session1);
//			courseRepository.save(course);
		
//			course.setLectures(new ArrayList<>());	
//			Lecture lecture1 = new Lecture();
//			lecture1.setTitle("Orientation");
//			lecture1.setCourse(course);
//			lecture1.setPos(1);
//			lectureRepository.save(lecture1);
//			Lecture lecture2 = new Lecture();
//			lecture2.setTitle("Frist Week");
//			lecture2.setCourse(course);
//			lecture2.setPos(2);
//			lectureRepository.save(lecture2);
//			Lecture lecture3 = new Lecture();
//			lecture3.setTitle("Second Week");
//			lecture3.setCourse(course);
//			lecture3.setPos(3);
//			lectureRepository.save(lecture3);
			
//			session1.setLectures(course.getLectures());
//			sessionRepository.save(session1);
//			
//			Lecture lecture4 = new Lecture();
//			lecture4.setTitle("this for session1");
//			lecture4.setSession(session1);
//			lecture4.setPos(4);
//			lectureRepository.save(lecture4);
			
//			session1.getLectures().add(lecture4);
//			sessionRepository.save(session1);
			
//			course.getLectures().add(lecture1);
//			course.getLectures().add(lecture2);
//			course.getLectures().add(lecture3);
//			courseRepository.save(course);
//		
//			lecture1.setLessons(new ArrayList<Lesson>());			
//			Lesson lesson1 = new Lesson();
//			lesson1.setTitle("학습목표 1");
//			lesson1.setContent("첫 번째 내용");
//			lesson1.setLecture(lecture1);
//			lecture1.getLessons().add(lesson1);
//			lectureRepository.save(lecture1);
//			lessonRepository.save(lesson1);
//
//			Lesson lesson2 = new Lesson();
//			lesson2.setTitle("학습목표 2");
//			lesson2.setContent("두 번째 내용");
//			lesson2.setLecture(lecture1);
//			lecture1.getLessons().add(lesson2);
//			lectureRepository.save(lecture1);
//			lessonRepository.save(lesson2);
//			
//			Lesson lesson3 = new Lesson();
//			lesson3.setTitle("학습목표 3");
//			lesson3.setContent("세 번째 내용");
//			lesson3.setLecture(lecture1);
//			lecture1.getLessons().add(lesson3);
//			lectureRepository.save(lecture1);
//			lessonRepository.save(lesson3);
											
					
		};
	
	
	
	}	
}
