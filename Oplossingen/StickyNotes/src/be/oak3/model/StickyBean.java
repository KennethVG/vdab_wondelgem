package be.oak3.model;

import java.io.Serializable;

public class StickyBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String text;
	private int id;

	public StickyBean() {

	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return getText();
	}

}
