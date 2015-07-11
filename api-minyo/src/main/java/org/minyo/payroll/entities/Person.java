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

	@Column(name = "father_first_name")
	private String fatherFirstName;
	
	@Column(name = "father_last_name")
	private String fatherLastName;
	
	@Column(name = "father_middle_name")
	private String fatherMiddleName;
	
	@Column(name = "father_affix")
	private String fatherAffix;
	
	@Column(name = "father_date_of_birth")
	private Date fatherDateOfBirth;
	
	@Column(name = "father_occupation")
	private String fatherOccupation;
	
	@Column(name = "mother_first_name")
	private String motherFirstName;
	
	@Column(name = "mother_last_name")
	private String motherLastName;
	
	@Column(name = "mother_middle_name")
	private String motherMiddleName;
	
	@Column(name = "mother_affix")
	private String motherAffix;
	
	@Column(name = "mother_date_of_birth")
	private Date motherDateOfBirth;
	
	@Column(name = "mother_occupation")
	private String motherOccupation;	
	

	@Column(name = "spouse_first_name")
	private String spouseFirstName;
	
	@Column(name = "spouse_last_name")
	private String spouseLastName;
	
	@Column(name = "spouse_middle_name")
	private String spouseMiddleName;
	
	@Column(name = "spouse_affix")
	private String spouseAffix;
	
	@Column(name = "spouse_date_of_birth")
	private Date spouseDateOfBirth;
	
	@Column(name = "spouse_occupation")
	private String spouseOccupation;
	
	
	
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

	/**
	 * @return the fatherFirstName
	 */
	public String getFatherFirstName() {
		return fatherFirstName;
	}

	/**
	 * @param fatherFirstName the fatherFirstName to set
	 */
	public void setFatherFirstName(String fatherFirstName) {
		this.fatherFirstName = fatherFirstName;
	}

	/**
	 * @return the fatherLastName
	 */
	public String getFatherLastName() {
		return fatherLastName;
	}

	/**
	 * @param fatherLastName the fatherLastName to set
	 */
	public void setFatherLastName(String fatherLastName) {
		this.fatherLastName = fatherLastName;
	}

	/**
	 * @return the fatherMiddleName
	 */
	public String getFatherMiddleName() {
		return fatherMiddleName;
	}

	/**
	 * @param fatherMiddleName the fatherMiddleName to set
	 */
	public void setFatherMiddleName(String fatherMiddleName) {
		this.fatherMiddleName = fatherMiddleName;
	}

	/**
	 * @return the fatherAffix
	 */
	public String getFatherAffix() {
		return fatherAffix;
	}

	/**
	 * @param fatherAffix the fatherAffix to set
	 */
	public void setFatherAffix(String fatherAffix) {
		this.fatherAffix = fatherAffix;
	}

	/**
	 * @return the fatherDateOfBirth
	 */
	public Date getFatherDateOfBirth() {
		return fatherDateOfBirth;
	}

	/**
	 * @param fatherDateOfBirth the fatherDateOfBirth to set
	 */
	public void setFatherDateOfBirth(Date fatherDateOfBirth) {
		this.fatherDateOfBirth = fatherDateOfBirth;
	}

	/**
	 * @return the fatherOccupation
	 */
	public String getFatherOccupation() {
		return fatherOccupation;
	}

	/**
	 * @param fatherOccupation the fatherOccupation to set
	 */
	public void setFatherOccupation(String fatherOccupation) {
		this.fatherOccupation = fatherOccupation;
	}

	/**
	 * @return the motherFirstName
	 */
	public String getMotherFirstName() {
		return motherFirstName;
	}

	/**
	 * @param motherFirstName the motherFirstName to set
	 */
	public void setMotherFirstName(String motherFirstName) {
		this.motherFirstName = motherFirstName;
	}

	/**
	 * @return the motherLastName
	 */
	public String getMotherLastName() {
		return motherLastName;
	}

	/**
	 * @param motherLastName the motherLastName to set
	 */
	public void setMotherLastName(String motherLastName) {
		this.motherLastName = motherLastName;
	}

	/**
	 * @return the motherMiddleName
	 */
	public String getMotherMiddleName() {
		return motherMiddleName;
	}

	/**
	 * @param motherMiddleName the motherMiddleName to set
	 */
	public void setMotherMiddleName(String motherMiddleName) {
		this.motherMiddleName = motherMiddleName;
	}

	/**
	 * @return the motherAffix
	 */
	public String getMotherAffix() {
		return motherAffix;
	}

	/**
	 * @param motherAffix the motherAffix to set
	 */
	public void setMotherAffix(String motherAffix) {
		this.motherAffix = motherAffix;
	}

	/**
	 * @return the motherDateOfBirth
	 */
	public Date getMotherDateOfBirth() {
		return motherDateOfBirth;
	}

	/**
	 * @param motherDateOfBirth the motherDateOfBirth to set
	 */
	public void setMotherDateOfBirth(Date motherDateOfBirth) {
		this.motherDateOfBirth = motherDateOfBirth;
	}

	/**
	 * @return the motherOccupation
	 */
	public String getMotherOccupation() {
		return motherOccupation;
	}

	/**
	 * @param motherOccupation the motherOccupation to set
	 */
	public void setMotherOccupation(String motherOccupation) {
		this.motherOccupation = motherOccupation;
	}

	/**
	 * @return the spouseFirstName
	 */
	public String getSpouseFirstName() {
		return spouseFirstName;
	}

	/**
	 * @param spouseFirstName the spouseFirstName to set
	 */
	public void setSpouseFirstName(String spouseFirstName) {
		this.spouseFirstName = spouseFirstName;
	}

	/**
	 * @return the spouseLastName
	 */
	public String getSpouseLastName() {
		return spouseLastName;
	}

	/**
	 * @param spouseLastName the spouseLastName to set
	 */
	public void setSpouseLastName(String spouseLastName) {
		this.spouseLastName = spouseLastName;
	}

	/**
	 * @return the spouseMiddleName
	 */
	public String getSpouseMiddleName() {
		return spouseMiddleName;
	}

	/**
	 * @param spouseMiddleName the spouseMiddleName to set
	 */
	public void setSpouseMiddleName(String spouseMiddleName) {
		this.spouseMiddleName = spouseMiddleName;
	}

	/**
	 * @return the spouseAffix
	 */
	public String getSpouseAffix() {
		return spouseAffix;
	}

	/**
	 * @param spouseAffix the spouseAffix to set
	 */
	public void setSpouseAffix(String spouseAffix) {
		this.spouseAffix = spouseAffix;
	}

	/**
	 * @return the spouseDateOfBirth
	 */
	public Date getSpouseDateOfBirth() {
		return spouseDateOfBirth;
	}

	/**
	 * @param spouseDateOfBirth the spouseDateOfBirth to set
	 */
	public void setSpouseDateOfBirth(Date spouseDateOfBirth) {
		this.spouseDateOfBirth = spouseDateOfBirth;
	}

	/**
	 * @return the spouseOccupation
	 */
	public String getSpouseOccupation() {
		return spouseOccupation;
	}

	/**
	 * @param spouseOccupation the spouseOccupation to set
	 */
	public void setSpouseOccupation(String spouseOccupation) {
		this.spouseOccupation = spouseOccupation;
	}

}
