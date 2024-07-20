/**
 * 
 */
package com.imaginnovate.codetest.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

/**
 * @author ADMIN
 *
 */
@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int empId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private LocalDate doj;
	private double salary;
	@Transient
	private double totalSalary;
	@Transient
	private double totalTax;
	@Transient
	private double totalCess;

	/**
	 * 
	 */
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param empId
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param phoneNumber
	 * @param doj
	 * @param salary
	 * @param totalSalary
	 * @param totalTax
	 * @param totalCess
	 */
	public Employee(int id, int empId, String firstName, String lastName, String email, String phoneNumber,
			LocalDate doj, double salary, double totalSalary, double totalTax, double totalCess) {
		super();
		this.id = id;
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.doj = doj;
		this.salary = salary;
		this.totalSalary = totalSalary;
		this.totalTax = totalTax;
		this.totalCess = totalCess;
	}

	/**
	 * @param empId
	 * @param firstName
	 * @param lastName
	 * @param totalSalary
	 * @param totalTax
	 * @param totalCess
	 */
	public Employee(int empId, String firstName, String lastName, double totalSalary, double totalTax,
			double totalCess) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.totalSalary = totalSalary;
		this.totalTax = totalTax;
		this.totalCess = totalCess;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the doj
	 */
	public LocalDate getDoj() {
		return doj;
	}

	/**
	 * @param doj the doj to set
	 */
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/**
	 * @return the totalSalary
	 */
	public double getTotalSalary() {
		return totalSalary;
	}

	/**
	 * @param totalSalary the totalSalary to set
	 */
	public void setTotalSalary(double totalSalary) {
		this.totalSalary = totalSalary;
	}

	/**
	 * @return the totalTax
	 */
	public double getTotalTax() {
		return totalTax;
	}

	/**
	 * @param totalTax the totalTax to set
	 */
	public void setTotalTax(double totalTax) {
		this.totalTax = totalTax;
	}

	/**
	 * @return the totalCess
	 */
	public double getTotalCess() {
		return totalCess;
	}

	/**
	 * @param totalCess the totalCess to set
	 */
	public void setTotalCess(double totalCess) {
		this.totalCess = totalCess;
	}

	public static void calculateTotalSalary(Employee employee) {

		int monthsWorked = 0;
		Double monthlySalary = employee.getSalary();
		Double dailyLop = monthlySalary / 30;
		Double dojMonthSal = 0.0;
		Double yearlySalary = 0.0;
		LocalDate dateOfJoin = employee.getDoj();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate startOfYear = LocalDate.parse("2023-04-01", formatter);
		LocalDate endOfYear = LocalDate.parse("2024-03-31", formatter);
		if (dateOfJoin.getYear() == endOfYear.getYear()) {

		}
		if (dateOfJoin.getYear() < startOfYear.getYear()) {
			monthsWorked = 12;
			yearlySalary = monthlySalary * monthsWorked;
		} else if (dateOfJoin.getYear() == startOfYear.getYear()) {
			if (dateOfJoin.getMonthValue() < startOfYear.getMonthValue()) {
				monthsWorked = 12;
				yearlySalary = monthlySalary * monthsWorked;
			} else if (dateOfJoin.getMonthValue() == startOfYear.getMonthValue()) {
				dojMonthSal = dailyLop * (dateOfJoin.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth()
						- dateOfJoin.getDayOfMonth() + 1);
				monthsWorked = 11;
				yearlySalary = (monthlySalary * monthsWorked) + dojMonthSal;
			} else {
				dojMonthSal = dailyLop * (dateOfJoin.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth()
						- dateOfJoin.getDayOfMonth() + 1);
				monthsWorked = 12 - dateOfJoin.getMonthValue() + 3;
				yearlySalary = (monthlySalary * monthsWorked) + dojMonthSal;
			}
		} else {
			if (dateOfJoin.getMonthValue() > endOfYear.getMonthValue()) {
				yearlySalary = 0.0;
				System.out.println("Outside of financial");
			} else {
				dojMonthSal = dailyLop * (dateOfJoin.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth()
						- dateOfJoin.getDayOfMonth() + 1);
				monthsWorked = 3 - dateOfJoin.getMonthValue();
				yearlySalary = (monthlySalary * monthsWorked) + dojMonthSal;
			}

		}

//		System.out.println(monthsWorked);
//		System.out.println(dojMonthSal);
//		System.out.println(yearlySalary);

		employee.setTotalSalary(yearlySalary);

	}

	public static void calculateTax(Employee employee) {
		Double tax = 0.0;
		Double salary = employee.getTotalSalary();
		if (salary > 1000000.00) {
			tax += (salary - 1000000.00) * 0.20;
			salary = 1000000.00;
		}
		if (salary > 500000.00) {
			tax += (salary - 500000.00) * 0.10;
			salary = 500000.00;
		}
		if (salary > 250000.00) {
			tax += (salary - 250000.00) * 0.05;
		}
		employee.setTotalTax(tax);
	}

	public static void calculateCess(Employee employee) {
		Double salary = employee.getTotalSalary();
		Double cess = salary > 2500000 ? (salary - 2500000) * 0.02 : 0.0;
		employee.setTotalCess(cess);
	}

}
