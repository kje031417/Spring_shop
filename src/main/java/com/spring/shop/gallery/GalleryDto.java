package com.spring.shop.gallery;

public class GalleryDto {
	private int gb_num;
	private String gb_id;
	private String gb_subject;
	private String gb_createdAt;
	
	public int getGb_num() {
		return gb_num;
	}

	public void setGb_num(int gb_num) {
		this.gb_num = gb_num;
	}

	public String getGb_id() {
		return gb_id;
	}

	public void setGb_id(String gb_id) {
		this.gb_id = gb_id;
	}

	public String getGb_subject() {
		return gb_subject;
	}

	public void setGb_subject(String gb_subject) {
		this.gb_subject = gb_subject;
	}

	public String getGb_createdAt() {
		return gb_createdAt;
	}

	public void setGb_createdAt(String gb_createdAt) {
		this.gb_createdAt = gb_createdAt;
	}

	public GalleryDto() {
		// TODO Auto-generated constructor stub
	}
	
	public GalleryDto(int gb_num, String gb_id, String gb_subject, String gb_createdAt) {
		super();
		this.gb_num = gb_num;
		this.gb_id = gb_id;
		this.gb_subject = gb_subject;
		this.gb_createdAt = gb_createdAt;
	}
}
