package next.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "discussion")
public class Discussion {

	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String content;
	
	@JsonIgnore	
	@Getter
	@Setter
	@OneToMany(mappedBy = "discussion")
	private List<Reply> replies;

	public Discussion(){}
	
	public Discussion(String content){
		this.content = content;
	}

	public void addReply(Reply reply) {
		replies.add(reply);
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Discussion [id=" + id + ", content=" + content + ", replies=" + replies + "]";
	}

	
	
	
}
