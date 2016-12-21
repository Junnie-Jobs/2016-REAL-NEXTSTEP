package org.nhnnext.nextstep.session;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import org.nhnnext.nextstep.enrollment.Enrollment;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(force = true)
@Data
@Entity
@DiscriminatorValue(SessionType.Values.COURSE)
public class CourseSession extends Session {

    public CourseSession(String name) {
        super(name);
    }

    public CourseSession(String name, String role) {
		super(name, role);
	}
    
	private LocalDateTime startDate;
    private LocalDateTime endDate;

    @OneToMany(mappedBy = "session")
    private final List<Enrollment> enrollments = new ArrayList<>();

//	public void addToLectures(Lecture lecture) {
//		lectures.add(lecture);
//		lecture.setCourseSession(this);
//	}
	
//    public List<User> getParticipants() {
//        return this.enrollments.stream()
//                .filter(Enrollment::isApproved)
//                .map(Enrollment::getUser)
//                .collect(Collectors.toList());
//    }
}
