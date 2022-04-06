package com.example.jk.model;

public class Movie {
	
	private String title;
	private Integer duration;
	private String description;
		
	public Movie() {
		
	}		
	
	public Movie(String title, Integer duration, String description) {
		super();
		this.title = title;
		this.duration = duration;
		this.description = description;
	}
		
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public Integer getDuration() {
		return duration;
	}
	
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

}
