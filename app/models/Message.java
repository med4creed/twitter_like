package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Message extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private long id;
	@Required
	@Column(length = 255, nullable = true)
	private String msg;
	//@Required
	@Temporal(TemporalType.DATE)
	private Date dateCreation = new Date();
	//@Required
	@JsonManagedReference
	@ManyToOne
	private Utilisateur user;
	@JsonManagedReference
	@ManyToOne
	private Groupe grp;

	public Message() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getDateCreation() {
		return dateCreation.toString();
	}

	public void setDateCreation(Date date) {
		this.dateCreation = date;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public Groupe getGrp() {
		return grp;
	}

	public void setGrp(Groupe grp) {
		this.grp = grp;
	}

	// Méthodes CRUD

	public static Finder<Long, Message> find = new Finder<Long, Message>(
			Long.class, Message.class);

	// Create
	public static void createMsg(Message msg) {
		msg.save();
	}

	// Read
	public static List<Message> findAllMsgs() {
		return find.all();
	}

	public static Message findMsgById(long id) {
		return find.byId(id);
	}

	// Update
	public static void updateMsg(Message msg) {
		find.byId(msg.getId()).update(msg);
	}

	// Delete
	public static void deleteMsg(Long id) {
		find.ref(id).delete();
	}

	@Override
	public String toString() {
		return "Message [id= " + id + ", msg = " + msg + ", dateCreation = "
				+ dateCreation + ", user = " + user + ", grp = " + grp + "]";
	}

}
