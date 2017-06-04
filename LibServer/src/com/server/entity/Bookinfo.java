package com.server.entity;

/**
 * Bookinfo entity. @author MyEclipse Persistence Tools
 */

public class Bookinfo implements java.io.Serializable {

	// Fields

	private Integer bid;
	private String bookname;
	private String booktype;
	private String bookindex;
	private String bookadrr;
	private String bookmian;
	private String bookceng;

	// Constructors

	/** default constructor */
	public Bookinfo() {
	}

	/** full constructor */
	public Bookinfo(String bookname, String booktype, String bookindex,
			String bookadrr, String bookmian, String bookceng) {
		this.bookname = bookname;
		this.booktype = booktype;
		this.bookindex = bookindex;
		this.bookadrr = bookadrr;
		this.bookmian = bookmian;
		this.bookceng = bookceng;
	}

	// Property accessors

	public Integer getBid() {
		return this.bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getBookname() {
		return this.bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getBooktype() {
		return this.booktype;
	}

	public void setBooktype(String booktype) {
		this.booktype = booktype;
	}

	public String getBookindex() {
		return this.bookindex;
	}

	public void setBookindex(String bookindex) {
		this.bookindex = bookindex;
	}

	public String getBookadrr() {
		return this.bookadrr;
	}

	public void setBookadrr(String bookadrr) {
		this.bookadrr = bookadrr;
	}

	public String getBookmian() {
		return this.bookmian;
	}

	public void setBookmian(String bookmian) {
		this.bookmian = bookmian;
	}

	public String getBookceng() {
		return this.bookceng;
	}

	public void setBookceng(String bookceng) {
		this.bookceng = bookceng;
	}

}