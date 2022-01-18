package models;


public class Word {

	private long id;
	private String label;
	private String date;
	
	public Word(long id, String label, String date) {
		super();
		this.id = id;
		this.label = label;
		this.date = date;
	}
	
	public Word() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
