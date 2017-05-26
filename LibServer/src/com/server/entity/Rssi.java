package com.server.entity;
// default package

/**
 * Rssi entity. @author MyEclipse Persistence Tools
 */

public class Rssi implements java.io.Serializable {

	// Fields

	private Integer wid;
	private Double x;
	private Double y;
	private String bssid;
	private String ssid;
	private Integer rssi;

	// Constructors

	/** default constructor */
	public Rssi() {
	}

	/** full constructor */
	public Rssi(Double x, Double y, String bssid, String ssid, Integer rssi) {
		this.x = x;
		this.y = y;
		this.bssid = bssid;
		this.ssid = ssid;
		this.rssi = rssi;
	}

	// Property accessors

	public Integer getWid() {
		return this.wid;
	}

	public void setWid(Integer wid) {
		this.wid = wid;
	}

	public Double getX() {
		return this.x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return this.y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public String getBssid() {
		return this.bssid;
	}

	public void setBssid(String bssid) {
		this.bssid = bssid;
	}

	public String getSsid() {
		return this.ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	public Integer getRssi() {
		return this.rssi;
	}

	public void setRssi(Integer rssi) {
		this.rssi = rssi;
	}

}