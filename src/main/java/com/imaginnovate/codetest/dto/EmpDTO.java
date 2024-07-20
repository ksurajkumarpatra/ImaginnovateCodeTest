/**
 * 
 */
package com.imaginnovate.codetest.dto;

/**
 * @author ADMIN
 *
 */
public class EmpDTO {
	
	private int empId;
	private String firstName;
	private String lastName;
	private double yearlySalary;
	private double taxAmount;
	private double cessAmount;
	/**
	 * 
	 */
	public EmpDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param empId
	 * @param firstName
	 * @param lastName
	 * @param yearlySalary
	 * @param taxAmount
	 * @param cessAmount
	 */
	public EmpDTO(int empId, String firstName, String lastName, double yearlySalary, double taxAmount,
			double cessAmount) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearlySalary = yearlySalary;
		this.taxAmount = taxAmount;
		this.cessAmount = cessAmount;
	}
	/**
	 * @return the empId
	 */
	public int getEmpId() {
		return empId;
	}
	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the yearlySalary
	 */
	public double getYearlySalary() {
		return yearlySalary;
	}
	/**
	 * @param yearlySalary the yearlySalary to set
	 */
	public void setYearlySalary(double yearlySalary) {
		this.yearlySalary = yearlySalary;
	}
	/**
	 * @return the taxAmount
	 */
	public double getTaxAmount() {
		return taxAmount;
	}
	/**
	 * @param taxAmount the taxAmount to set
	 */
	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}
	/**
	 * @return the cessAmount
	 */
	public double getCessAmount() {
		return cessAmount;
	}
	/**
	 * @param cessAmount the cessAmount to set
	 */
	public void setCessAmount(double cessAmount) {
		this.cessAmount = cessAmount;
	}
	

}
