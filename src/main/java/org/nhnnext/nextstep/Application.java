package org.nhnnext.nextstep;
import java.lang.reflect.Field;
import java.time.LocalDate;
import org.nhnnext.nextstep.course.Course;
import org.nhnnext.nextstep.course.CourseRepository;
import org.nhnnext.nextstep.enrollment.Enrollment;
import org.nhnnext.nextstep.enrollment.EnrollmentRepository;
import org.nhnnext.nextstep.lecture.Lecture;
import org.nhnnext.nextstep.lecture.LectureRepository;
import org.nhnnext.nextstep.lesson.Lesson;
import org.nhnnext.nextstep.lesson.LessonRepository;
import org.nhnnext.nextstep.session.CourseSession;
import org.nhnnext.nextstep.session.CourseSessionRepository;
import org.nhnnext.nextstep.session.MasterSession;
import org.nhnnext.nextstep.session.MasterSessionRepository;
import org.nhnnext.nextstep.user.Instructor;
import org.nhnnext.nextstep.user.User;
import org.nhnnext.nextstep.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.ReflectionUtils;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	@Bean
	public CommandLineRunner demo(LectureRepository lectureRepository, UserRepository userRepository,
			CourseRepository courseRepository, CourseSessionRepository courseSessionRepository, MasterSessionRepository masterSessionRepository, LessonRepository lessonRepository, EnrollmentRepository enrollmentRepository) {
		return (args) -> {

			Field usernameField = ReflectionUtils.findField(User.class, "username");
			ReflectionUtils.makeAccessible(usernameField);
			
			User student1 = new User();
			ReflectionUtils.setField(usernameField, student1, "dayBrush");
			student1.setName("Choi Yeonkyu");
			student1.setAvatarUrl("https://scontent-icn1-1.xx.fbcdn.net/v/t1.0-9/14494785_1303032459755018_522118762631698008_n.jpg?oh=3fa832407d4254f7e97fcba1b70d3f40&oe=58AD5DA2");
			student1.setEmail("dayBrush@naver.com");
			userRepository.save(student1);
			
			User student2 = new User();
			Field student2UsernameField = ReflectionUtils.findField(User.class, "username");
			ReflectionUtils.makeAccessible(student2UsernameField);
			ReflectionUtils.setField(student2UsernameField, student2, "junniejobs");
			student2.setName("Lim Dongjun");
			student2.setAvatarUrl("https://avatars2.githubusercontent.com/u/3433096?v=3&s=460");
			student2.setEmail("dj0999@naver.com");
			userRepository.save(student2);
//			
			User student3 = new User();
			Field student3UsernameField = ReflectionUtils.findField(User.class, "username");
			ReflectionUtils.makeAccessible(student3UsernameField);
			ReflectionUtils.setField(student3UsernameField, student3, "Byeol");
			student3.setName("Seo Jaewon");
			student3.setAvatarUrl("https://scontent.xx.fbcdn.net/v/t1.0-9/230403_368531479891429_635986668_n.jpg?oh=a42efa9e657826e57a96db008960b817&oe=58C68AA9");
			student3.setEmail("Byeol@naver.com");
			userRepository.save(student3);
			
			Instructor professor1 = new Instructor("javajigi");
//			Field professorUsernameField = ReflectionUtils.findField(Instructor.class, "username");
//			ReflectionUtils.makeAccessible(professorUsernameField);
//			ReflectionUtils.setField(professorUsernameField, professor1, "javajigi");
			professor1.setName("jaesung");
			professor1.setAvatarUrl("https://avatars2.githubusercontent.com/u/520500?v=3&s=400");
			professor1.setEmail("javajigi@naver.com");
			userRepository.save(professor1);
			
			MasterSession masterSession = new MasterSession("JWP-master");
			Course course = new Course(masterSession);
			course.setName("jwp-basic");
			course.getInstructors().add(professor1);
			courseRepository.save(course);
		
			masterSession.setCourse(course);
			masterSessionRepository.save(masterSession);
			
			Lecture lecture0 = new Lecture("orientation");
			lectureRepository.save(lecture0);
			lecture0.setMasterSession(masterSession);
			lectureRepository.save(lecture0);
			
			CourseSession session1 = new CourseSession("2016-01-JWP");
			courseSessionRepository.save(session1);
			session1.setCourse(course);

			courseSessionRepository.save(session1);
			
			CourseSession session2 = new CourseSession("2016-02-JWP");
			session2.setCourse(course);
			courseSessionRepository.save(session2);
		
			CourseSession session3 = new CourseSession("2016-03-JWP");
			session3.setCourse(course);
//			courseSessionRepository.save(session3);
			
//			LocalDateTime startDate = 
			session3.setStartDate(LocalDate.now());
			session3.setEndDate(LocalDate.now());
			System.out.println("시간");
			System.out.println(LocalDate.now());
			courseSessionRepository.save(session3);
			
				Lecture lecture1 = new Lecture("First Week");
				lecture1.setCourseSession(session3);
				lectureRepository.save(lecture1);
	
					Lesson lesson1 = new Lesson("CRUD");
					lesson1.setLecture(lecture1);
					lessonRepository.save(lesson1);
								
					Lesson lesson2 = new Lesson("ajax");
					lesson2.setLecture(lecture1);
					lessonRepository.save(lesson2);

					Lesson lesson3 = new Lesson("Unit test");
					lesson3.setLecture(lecture1);
					lessonRepository.save(lesson3);

				Lecture lecture2 = new Lecture("Second Week");
				lecture2.setCourseSession(session3);
				lectureRepository.save(lecture2);
				
					Lesson lesson4 = new Lesson("java");
					lesson4.setLecture(lecture2);
					lessonRepository.save(lesson4);
								
					Lesson lesson5 = new Lesson("javascript");
					lesson5.setLecture(lecture2);
					lessonRepository.save(lesson5);
	
					Lesson lesson6 = new Lesson("lamda");
					lesson6.setLecture(lecture2);
					lessonRepository.save(lesson6);
		
				Lecture lecture3 = new Lecture("Third Week");
				lecture3.setCourseSession(session3);
				lectureRepository.save(lecture3);
				
					Lesson lesson7 = new Lesson("front");
					lesson7.setLecture(lecture3);
					lessonRepository.save(lesson7);
								
					Lesson lesson8 = new Lesson("react");
					lesson8.setLecture(lecture3);
					lessonRepository.save(lesson8);
	
					Lesson lesson9 = new Lesson("angular");
					lesson9.setLecture(lecture3);
					lessonRepository.save(lesson9);
			
					course.setDefaultSession(session3);
					courseRepository.save(course);
					
					Enrollment e1 = new Enrollment(session3, student1);
					e1.setStatus(e1.getStatus().APPROVED);					
					enrollmentRepository.save(e1);
					
					Enrollment e2 = new Enrollment(session3, student2);
					e2.setStatus(e2.getStatus().APPROVED);
					enrollmentRepository.save(e2);
					
					Enrollment e3 = new Enrollment(session3, student3);
					enrollmentRepository.save(e3);
					
					
			
					
		};
	
	
	
	}	
}
