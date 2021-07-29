package com.si.project.VO;

import java.sql.Date;

public class BoardVO {

	private int b_idx;
	private String b_subject;
	private String b_content;
	private String b_writer;
	private int b_readnum;
	private Date b_writedate;
	
	
	public BoardVO() {
		super();
	}
	
	public BoardVO(int b_idx, String b_subject, String b_content, String b_writer, int b_readnum, Date b_writedate) {
		super();
		this.b_idx = b_idx;
		this.b_subject = b_subject;
		this.b_content = b_content;
		this.b_writer = b_writer;
		this.b_readnum = b_readnum;
		this.b_writedate = b_writedate;
	}
	public int getB_idx() {
		return b_idx;
	}
	public void setB_idx(int b_idx) {
		this.b_idx = b_idx;
	}
	public String getB_subject() {
		return b_subject;
	}
	public void setB_subject(String b_subject) {
		this.b_subject = b_subject;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public String getB_writer() {
		return b_writer;
	}
	public void setB_writer(String b_writer) {
		this.b_writer = b_writer;
	}
	public int getB_readnum() {
		return b_readnum;
	}
	public void setB_readnum(int b_readnum) {
		this.b_readnum = b_readnum;
	}
	public Date getB_writedate() {
		return b_writedate;
	}
	public void setB_writedate(Date b_writedate) {
		this.b_writedate = b_writedate;
	}
}
	