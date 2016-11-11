package org.nhnnext.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.AbstractPersistable;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

@Data
@Entity
public class Session extends AbstractPersistable<Long> {

	@NotEmpty
	private String title;
	
	@NotEmpty
	private String content;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(
			foreignKey = @ForeignKey(name = "fk_lecture_id"))
	@JsonBackReference
	private Lecture lecture;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "session")
	@OrderColumn
	@JsonManagedReference
	private List<SessionComment> comments;
	
	private Access access;

	
	public Session(){}
	
	public Session(String title, Lecture lecture){
		this.title = title;
		this.lecture = lecture;
	}
	
	public enum Access {
		PUBLIC,
		PRIVATE
	}
}
