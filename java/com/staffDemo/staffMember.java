package com.staffDemo;

public class staffMember {
    private String staffId;
    private String fname;
    private String lname;
    private String number;
    private String position;
    private String address;
    private String regDate;
    private String email;
    private String dob;
   

	public staffMember(String staffId, String fname, String lname, String number, String position, String address,
			String regDate, String email, String dob) {
		super();
		this.staffId = staffId;
		this.fname = fname;
		this.lname = lname;
		this.number = number;
		this.position = position;
		this.address = address;
		this.regDate = regDate;
		this.email = email;
		this.dob = dob;
	}


	public String getStaffId() {
		return staffId;
	}


	public String getFname() {
		return fname;
	}


	public String getLname() {
		return lname;
	}


	public String getNumber() {
		return number;
	}


	public String getPosition() {
		return position;
	}


	public String getAddress() {
		return address;
	}


	public String getRegDate() {
		return regDate;
	}


	public String getEmail() {
		return email;
	}


	public String getDob() {
		return dob;
	}






	
}
