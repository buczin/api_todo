package pl.buczi.todo.list;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String name;
	private String description;
	private Date date;
	
	public Task(String name, String description, Date date) {
		super();
		this.name = name;
		this.description = description;
		this.date = date;
	}
	
	public Task(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	public Task() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
