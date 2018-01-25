package be.vdab.guestbook.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GuestBookBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private LocalDateTime date;
	private String name;
	private String message;

	public GuestBookBean() {
		this(null, null);
	}

	public GuestBookBean(String name, String message) {
		this.name = name;
		this.message = message;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String formattedDate() {
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		 return formatter.format(getDate());
	}

}
