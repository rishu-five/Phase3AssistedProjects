package com.example;

public class Student {
private int sid;
private String sname;
private String semail;
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
public String getSemail() {
	return semail;
}
public void setSemail(String semail) {
	this.semail = semail;
}
@Override
public String toString() {
	return "Student [sid=" + sid + ", sname=" + sname + ", semail=" + semail + "]";
}

}
