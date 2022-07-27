package com.spring.shop.gallery;

public class MainGalleryDto {
	private String saved_file_name;
	private int gb_num;
	private String gb_subject;
	private String gb_id;
	
	public String getSaved_file_name() {
		return saved_file_name;
	}
	public void setSaved_file_name(String saved_file_name) {
		this.saved_file_name = saved_file_name;
	}
	public int getGb_num() {
		return gb_num;
	}
	public void setGb_num(int gb_num) {
		this.gb_num = gb_num;
	}
	public String getGb_subject() {
		return gb_subject;
	}
	public void setGb_subject(String gb_subject) {
		this.gb_subject = gb_subject;
	}
	public String getGb_id() {
		return gb_id;
	}
	public void setGb_id(String gb_id) {
		this.gb_id = gb_id;
	}
	
	public MainGalleryDto() {
		// TODO Auto-generated constructor stub
	}
	
	public MainGalleryDto(String saved_file_name, int gb_num, String gb_subject, String gb_id) {
		super();
		this.saved_file_name = saved_file_name;
		this.gb_num = gb_num;
		this.gb_subject = gb_subject;
		this.gb_id = gb_id;
	}	
}
