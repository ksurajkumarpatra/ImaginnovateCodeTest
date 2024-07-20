/**
 * 
 */
package com.imaginnovate.codetest.dao;

import org.springframework.data.repository.CrudRepository;

import com.imaginnovate.codetest.entities.Employee;

/**
 * @author ADMIN
 *
 */

public interface EmpDAO extends CrudRepository<Employee, Integer>{
	
	public Employee findByEmpId(int empId);

}
