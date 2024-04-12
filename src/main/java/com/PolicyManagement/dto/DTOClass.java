package com.PolicyManagement.dto;


import java.sql.Date;

public class DTOClass {
	
	private String username;
	private String firstname;
	private String middlename;
	private String lastname;
	private Date dateofbirth;
	private String gender;
	private String profession;
	private String currentaddress;
	private String nationality;
	private String idprooftype;
	private String idproofdocnumber;
	private String phonenumber;
	private String emailaddress;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Date getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getCurrentaddress() {
		return currentaddress;
	}
	public void setCurrentaddress(String currentaddress) {
		this.currentaddress = currentaddress;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getIdprooftype() {
		return idprooftype;
	}
	public void setIdprooftype(String idprooftype) {
		this.idprooftype = idprooftype;
	}
	public String getIdproofdocnumber() {
		return idproofdocnumber;
	}
	public void setIdproofdocnumber(String idproofdocnumber) {
		this.idproofdocnumber = idproofdocnumber;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getEmailaddress() {
		return emailaddress;
	}
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
	@Override
	public String toString() {
		return "UserProfilesModel [username=" + username + ", firstname=" + firstname + ", middlename=" + middlename
				+ ", lastname=" + lastname + ", dateofbirth=" + dateofbirth + ", gender=" + gender + ", profession="
				+ profession + ", currentaddress=" + currentaddress + ", nationality=" + nationality + ", idprooftype="
				+ idprooftype + ", idproofdocnumber=" + idproofdocnumber + ", phonenumber=" + phonenumber
				+ ", emailaddress=" + emailaddress + "]";
	}
	


}
