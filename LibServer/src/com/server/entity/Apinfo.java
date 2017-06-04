package com.server.entity;

/**
 * Apinfo entity. @author MyEclipse Persistence Tools
 */

public class Apinfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private String macaddr;
	private String index;
	private String ssid;

	// Constructors

	/** default constructor */
	public Apinfo() {
	}

	/** full constructor */
	public Apinfo(String macaddr, String index, String ssid) {
		this.macaddr = macaddr;
		this.index = index;
		this.ssid = ssid;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMacaddr() {
		return this.macaddr;
	}

	public void setMacaddr(String macaddr) {
		this.macaddr = macaddr;
	}

	public String getIndex() {
		return this.index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getSsid() {
		return this.ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

}