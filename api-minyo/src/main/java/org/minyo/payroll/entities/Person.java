package org.minyo.payroll.entities;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="tbl_persons")
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name = "person_id")
	private long id;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "affix")
	private String affix;

	@Column(name = "age")
	private int age;

	@Column(name = "gender")
	private String gender;

	@Column(name = "date_of_birth")
	private Date dateOfBirth;

	@Column(name = "civil_status")
	private String civilStatus;

	@Column(name = "permanent_residence")
	private String permanentResidence;

	@Column(name = "current_residence")
	private String currentResidence;

	public Person() {
		
	}
	
	public Person(String lastName, String firstName, String middleName,
			String affix, int age, String gender, Date dateOfBirth,
			String civilStatus, String permanentResidence,
			String currentResidence) {

		this.lastName = lastName;
		this.firstName = firstName;
		this.affix = affix;
		this.age = age;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.civilStatus = civilStatus;
		this.permanentResidence = permanentResidence;
		this.currentResidence = currentResidence;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName
	 *            the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the affix
	 */
	public String getAffix() {
		return affix;
	}

	/**
	 * @param affix
	 *            the affix to set
	 */
	public void setAffix(String affix) {
		this.affix = affix;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth
	 *            the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the civilStatus
	 */
	public String getCivilStatus() {
		return civilStatus;
	}

	/**
	 * @param civilStatus
	 *            the civilStatus to set
	 */
	public void setCivilStatus(String civilStatus) {
		this.civilStatus = civilStatus;
	}

	/**
	 * @return the permanentResidence
	 */
	public String getPermanentResidence() {
		return permanentResidence;
	}

	/**
	 * @param permanentResidence
	 *            the permanentResidence to set
	 */
	public void setPermanentResidence(String permanentResidence) {
		this.permanentResidence = permanentResidence;
	}

	/**
	 * @return the currentResidence
	 */
	public String getCurrentResidence() {
		return currentResidence;
	}

	/**
	 * @param currentResidence
	 *            the currentResidence to set
	 */
	public void setCurrentResidence(String currentResidence) {
		this.currentResidence = currentResidence;
	}

}
