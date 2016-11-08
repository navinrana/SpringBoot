package com.navin.SpringBootPro.entity;

public class Student {
	private long id;
	private String name;

	public Student() {
	}

	public Student(long id, String name, String subject) {
		super();
		this.id = id;
		this.name = name;
		this.subject = subject;
	}

	private String subject;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", subject=" + subject
				+ "]";
	}

}
