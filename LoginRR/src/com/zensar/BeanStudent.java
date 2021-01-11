package com.zensar;

public class BeanStudent {

	private int sid;
	private String sname;
	private String scourse;
	private String shometown;
	private String sgender;
	public BeanStudent(int sid, String sname, String scourse, String shometown, String sgender) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.scourse = scourse;
		this.shometown = shometown;
		this.sgender = sgender;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getScourse() {
		return scourse;
	}
	public void setScourse(String scourse) {
		this.scourse = scourse;
	}
	public String getShometown() {
		return shometown;
	}
	public void setShometown(String shometown) {
		this.shometown = shometown;
	}
	public String getSgender() {
		return sgender;
	}
	public void setSgender(String sgender) {
		this.sgender = sgender;
	}
	@Override
	public String toString() {
		return "BeanStudent [sid=" + sid + ", sname=" + sname + ", scourse=" + scourse + ", shoemtown=" + shometown
				+ ", sgender=" + sgender + "]";
	}
	
	
}
