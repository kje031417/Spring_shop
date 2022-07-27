package com.spring.shop.notice;

public class NoticeDto {
	private int nb_num;      
	private String nb_id;       
	private String nb_subject;  
	private String nb_content;  
	private String nb_createdAt;
	
	public int getNb_num() {
		return nb_num;
	}
	public void setNb_num(int nb_num) {
		this.nb_num = nb_num;
	}
	public String getNb_id() {
		return nb_id;
	}
	public void setNb_id(String nb_id) {
		this.nb_id = nb_id;
	}
	public String getNb_subject() {
		return nb_subject;
	}
	public void setNb_subject(String nb_subject) {
		this.nb_subject = nb_subject;
	}
	public String getNb_content() {
		return nb_content;
	}
	public void setNb_content(String nb_content) {
		this.nb_content = nb_content;
	}
	public String getNb_createdAt() {
		return nb_createdAt;
	}
	public void setNb_createdAt(String nb_createdAt) {
		this.nb_createdAt = nb_createdAt;
	}
	
	public NoticeDto() {
		// TODO Auto-generated constructor stub
	}
	
	public NoticeDto(int nb_num, String nb_id, String nb_subject, String nb_content, String nb_createdAt) {
		super();
		this.nb_num = nb_num;
		this.nb_id = nb_id;
		this.nb_subject = nb_subject;
		this.nb_content = nb_content;
		this.nb_createdAt = nb_createdAt;
	}
}
