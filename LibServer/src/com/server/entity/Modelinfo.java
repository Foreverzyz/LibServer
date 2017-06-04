package com.server.entity;

/**
 * Modelinfo entity. @author MyEclipse Persistence Tools
 */

public class Modelinfo implements java.io.Serializable {

	// Fields

	private String fid;
	private String indexrange;
	private String x;
	private String y;
	private String z;
	private String name;
	private String type;

	// Constructors

	/** default constructor */
	public Modelinfo() {
	}

	/** full constructor */
	public Modelinfo(String indexrange, String x, String y, String z,
			String name, String type) {
		this.indexrange = indexrange;
		this.x = x;
		this.y = y;
		this.z = z;
		this.name = name;
		this.type = type;
	}

	// Property accessors

	public String getFid() {
		return this.fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getIndexrange() {
		return this.indexrange;
	}

	public void setIndexrange(String indexrange) {
		this.indexrange = indexrange;
	}

	public String getX() {
		return this.x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return this.y;
	}

	public void setY(String y) {
		this.y = y;
	}

	public String getZ() {
		return this.z;
	}

	public void setZ(String z) {
		this.z = z;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}