package next.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reply")
public class Reply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String content;
	
	@NotNull
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_discussion_id"))
	private Discussion discussion;

	public Reply(){}
	
	public Reply(String content, Discussion discussion){
		this.content = content;
		this.discussion = discussion;
		discussion.addReply(this);
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Discussion getDiscussion() {
		return discussion;
	}

	public void setDiscussion(Discussion discussion) {
		this.discussion = discussion;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Reply [id=" + id + ", content=" + content + ", discussion=" + discussion + "]";
	}


}
