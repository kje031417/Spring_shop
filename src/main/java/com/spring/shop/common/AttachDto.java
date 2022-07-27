package com.spring.shop.common;

public class AttachDto {
	private String board_type;
	private int board_id;
	private int file_num;
	private String file_name;
	private String saved_file_name;
	private long file_size;
	
	public AttachDto() {
		// TODO Auto-generated constructor stub
	}

	public String getBoard_type() {
		return board_type;
	}

	public void setBoard_type(String board_type) {
		this.board_type = board_type;
	}

	public int getBoard_id() {
		return board_id;
	}

	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}

	public int getFile_num() {
		return file_num;
	}

	public void setFile_num(int file_num) {
		this.file_num = file_num;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getSaved_file_name() {
		return saved_file_name;
	}

	public void setSaved_file_name(String saved_file_name) {
		this.saved_file_name = saved_file_name;
	}

	public long getFile_size() {
		return file_size;
	}

	public void setFile_size(long file_size) {
		this.file_size = file_size;
	}

	public AttachDto(String board_type, int board_id, String file_name, String saved_file_name,
			long file_size) {
		super();
		this.board_type = board_type;
		this.board_id = board_id;
		this.file_name = file_name;
		this.saved_file_name = saved_file_name;
		this.file_size = file_size;
	}

	public static final AttachDto createDto(String board_type, int board_id,
			String file_name, String saved_file_name, long file_size) {
		return new AttachDto(board_type, board_id, file_name, saved_file_name, file_size);
	}
}
