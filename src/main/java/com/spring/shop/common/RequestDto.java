package com.spring.shop.common;

public class RequestDto {
	private String board_type;
	private int board_id;
	
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
	
	public RequestDto() {
		// TODO Auto-generated constructor stub
	}
	
	public RequestDto(String board_type, int board_id) {
		super();
		this.board_type = board_type;
		this.board_id = board_id;
	}
	
	public static final RequestDto CreateDto(String board_type, int board_id) {
		return new RequestDto(board_type, board_id);
	}
}
