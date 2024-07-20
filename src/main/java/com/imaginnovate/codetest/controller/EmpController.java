/**
 * 
 */
package com.imaginnovate.codetest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.imaginnovate.codetest.dto.EmpDTO;
import com.imaginnovate.codetest.entities.Employee;
import com.imaginnovate.codetest.services.EmpService;
import com.imaginnovate.utilities.EmpUtilities;

/**
 * @author ADMIN
 *
 */
@RestController
@Validated
public class EmpController {

	@Autowired
	EmpService empService;

	@PostMapping("/addEmployee")
	public ResponseEntity<String> addEmployee(@RequestBody Employee emp) {

		ResponseEntity<String> returnParam = null;

		try {
			String validateError = EmpUtilities.validateEmp(emp);

			if (validateError == null) {
				Employee isEmpPresent = empService.getEmployee(emp.getEmpId());
				if (isEmpPresent == null) {
					empService.addEmployee(emp);
					returnParam = ResponseEntity.status(HttpStatus.OK).body("Employee Added Successfully");
				} else {
					returnParam = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Employee Id already Exists");
				}
			} else {
				returnParam = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validateError);
			}
		} catch (Exception e) {
			e.printStackTrace();
			returnParam = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Some issue with adding Employee");

		}
		return returnParam;

	}

	@GetMapping("/getEmployee")
	public List<EmpDTO> getAllEmployee() {

		return empService.getAllEmployee();
	}

}
