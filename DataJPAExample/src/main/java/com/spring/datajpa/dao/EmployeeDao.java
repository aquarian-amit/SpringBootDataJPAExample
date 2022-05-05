package com.spring.datajpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.spring.datajpa.entity.Employee;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {

	public List<Employee> findByFirstName(String firstName);

	@Query("FROM Employee")
	public List<Employee> getAllEmployee();

	@Query("SELECT E.firstName FROM Employee E")
	public List<String> getAllFirstName();

	@Query("FROM Employee E WHERE E.id>1 ORDER BY E.salary ASC")
	/* @Query("FROM Employee E WHERE E.id>1 ORDER BY E.salary DESC") */
	public List<Employee> getOrderedEmployees();

	//@Query("SELECT SUM(E.salary), E.firstName FROM Employee E GROUP BY E.firstName")
	//@Query("SELECT AVG(E.salary), E.firstName FROM Employee E GROUP BY E.firstName")
	//@Query("SELECT MAX(E.salary), E.firstName FROM Employee E GROUP BY E.firstName")
	//@Query("SELECT MIN(E.salary), E.firstName FROM Employee E GROUP BY E.firstName")
	@Query("SELECT COUNT(E.salary), E.firstName FROM Employee E GROUP BY E.firstName")
	public List<Object[]> getGroupedEmployees();
	
	
	//@Query("SELECT COUNT(*) FROM Employee")
	@Query("SELECT COUNT(DISTINCT E.firstName) FROM Employee E")
	public List getCountOfemployees();

}
