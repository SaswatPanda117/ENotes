package com.user;

import java.util.Date;

//POJO CLASS
public class Notes {

	private int id;
	private String title;
	private String content;
	private Date postDate;
	private UserDetails user;

	public Notes(int id, String title, String content, Date postDate, UserDetails user) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.postDate = postDate;
		this.user = user;
	}

	public Notes() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

}
