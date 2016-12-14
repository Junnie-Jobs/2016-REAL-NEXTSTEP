package org.nhnnext.nextstep.session;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;
import org.nhnnext.nextstep.core.AbstractEntity;
import org.nhnnext.nextstep.course.Course;
import org.nhnnext.nextstep.enrollment.Enrollment;
import org.nhnnext.nextstep.lecture.Lecture;
import org.nhnnext.nextstep.user.User;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(force = true)
@Data
@Entity
@DiscriminatorValue("COURSE")
@ToString(exclude="course")
@EqualsAndHashCode(of="id")
public class CourseSession extends AbstractEntity {
	
	@ManyToOne
    private Course course;

    public CourseSession(String name) {
        this.name = name;
    }

    @NotEmpty
    private String name;
    
    private String pos;
    // [1][2][5][4][3]
    private LocalDate startDate;
    private LocalDate endDate;
    
	@OneToMany(mappedBy = "courseSession")
//	@OrderColumn(name = "lecture_order")
	private List<Lecture> lectures;

    @OneToMany(mappedBy = "session")
    private final List<Enrollment> enrollments = new ArrayList<>();

	public void addToLectures(Lecture lecture) {
		lectures.add(lecture);
		lecture.setCourseSession(this);
	}
	
    public List<User> getParticipants() {
        return this.enrollments.stream()
                .filter(Enrollment::isApproved)
                .map(Enrollment::getUser)
                .collect(Collectors.toList());
    }
}
