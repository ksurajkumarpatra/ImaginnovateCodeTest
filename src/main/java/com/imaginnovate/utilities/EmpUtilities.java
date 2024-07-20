/**
 * 
 */
package com.imaginnovate.utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.imaginnovate.codetest.entities.Employee;

/**
 * @author ADMIN
 *
 */
public class EmpUtilities {

	private static final String PHONE_NUMBER_REGEX = "[1-9]\\d{9}";
	private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	
	

	public static boolean validatePhoneNumber(String phoneNumber) {
		Pattern pattern = Pattern.compile(PHONE_NUMBER_REGEX);
		Matcher matcher = pattern.matcher(phoneNumber);
		return matcher.matches();
	}

	public static boolean validateEmail(String email) {
		Pattern pattern = Pattern.compile(EMAIL_REGEX);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public static boolean validateDOJ(LocalDate doj) {
		LocalDate currentDate = LocalDate.now();
		boolean returnResult = false;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = doj.format(formatter);
		try {
			LocalDate parsedDate = LocalDate.parse(formattedDate, formatter);
			if (parsedDate.equals(doj)) {
				returnResult = doj.isBefore(currentDate);
			}
		} catch (Exception e) {
			return false;
		}

		return returnResult;
	}

	public static void main(String[] args) {
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		LocalDate startOfYear = LocalDate.parse("01-04-2025", formatter);

	}

	public static String validateEmp(Employee emp) {
		String returnResult = null;
		if (validateEmail(emp.getEmail())) {
			if (validatePhoneNumber(emp.getPhoneNumber())) {
				if (validateDOJ(emp.getDoj())) {

				} else {
					returnResult = "DOJ is not valid. 1. Format should be YYYY-MM-DD. 2. DOJ should not be future date";
				}
			} else {
				returnResult = "Phone Number is not valid. 1. Only Numbers are allowed. 2. should not start with Zero. 3. Only 10 Numbers allowed";
			}
		} else {
			returnResult = "Email is not Valid";
		}
		return returnResult;
	}
}
