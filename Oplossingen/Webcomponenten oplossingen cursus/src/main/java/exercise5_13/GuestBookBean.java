package exercise5_13;

import java.io.Serializable;
import java.time.LocalDateTime;

public class GuestBookBean implements Serializable {
	private LocalDateTime date;
	private String name;
	private String message;
	
	public GuestBookBean(){		
	}

	public GuestBookBean(LocalDateTime date, String name, String message) {
		this.date = date;
		this.name = name;
		this.message = message;
	}
	
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
