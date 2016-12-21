package org.nhnnext.nextstep.session;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.nhnnext.nextstep.enrollment.Enrollment;
import org.nhnnext.nextstep.enrollment.EnrollmentException;
import org.nhnnext.nextstep.user.AuthenticationUtils;
import org.nhnnext.nextstep.user.SecurityUser;
import org.springframework.security.core.Authentication;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Data
@Entity
@DiscriminatorValue(SessionType.Values.COURSE)
public class CourseSession extends Session {

    //    @Column(unique = true, nullable = false)
    @NotNull
    private final String name;

    private String description;

    @NotNull
    private State state = State.IN_SESSION;

    public enum State {
        UPCOMING, IN_SESSION
    }

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "session")
    private final List<Enrollment> enrollments = new ArrayList<>();

    public boolean isEnrolled(Authentication authentication) {
        return isEnrolled(AuthenticationUtils.getUser(authentication));
    }

    public boolean isEnrolled(SecurityUser user) {
        return getEnrollments().stream().map(Enrollment::getUser).collect(Collectors.toList()).contains(user);
    }

    public void addToEnrollments(Enrollment enrollment) {
        if (isEnrolled(enrollment.getUser())) {
            throw new EnrollmentException(enrollment, "User already enrolled!");
        }

        getEnrollments().add(enrollment);
        enrollment.setSession(this);

    }
//    public List<User> getParticipants() {
//        return this.enrollments.stream()
//                .filter(Enrollment::isApproved)
//                .map(Enrollment::getUser)
//                .collect(Collectors.toList());
//    }
}
