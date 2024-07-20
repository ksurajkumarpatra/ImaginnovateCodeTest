/**
 * 
 */
package com.imaginnovate.codetest.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.imaginnovate.codetest.dao.EmpDAO;
import com.imaginnovate.codetest.dto.EmpDTO;
import com.imaginnovate.codetest.entities.Employee;

/**
 * @author ADMIN
 *
 */
@Component
public class EmpService {

	@Autowired
	EmpDAO empDAO;

	public Employee addEmployee(Employee emp) {

		Employee empAdded = empDAO.save(emp);
		return empAdded;
	}

	public List<EmpDTO> getAllEmployee() {

		List<Employee> empAdded = (List<Employee>) empDAO.findAll();
		// System.out.println(empAdded);

		empAdded.stream().peek(Employee::calculateTotalSalary).peek(Employee::calculateTax)
				.peek(Employee::calculateCess).collect(Collectors.toList());
		
		List<EmpDTO> filteredEmp = empAdded.stream().map(employee -> new EmpDTO(employee.getEmpId(), employee.getFirstName(), employee.getLastName(), employee.getTotalSalary(), employee.getTotalTax(), employee.getTotalCess())).collect(Collectors.toList());
		
		return filteredEmp;
	}
	
	public Employee getEmployee(int empId) {

		Employee empAdded = empDAO.findByEmpId(empId);
		return empAdded;
	}

}
