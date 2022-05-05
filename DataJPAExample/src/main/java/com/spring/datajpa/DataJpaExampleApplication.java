package com.spring.datajpa;

import java.util.Iterator;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.spring.datajpa.dao.EmployeeDao;
import com.spring.datajpa.entity.Employee;

@SpringBootApplication
public class DataJpaExampleApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(DataJpaExampleApplication.class,
				args);
		EmployeeDao dao = (EmployeeDao) applicationContext.getBean("employeeDao");
		dao.save(new Employee(1, "Amit", "Kumar", 88000));
		dao.save(new Employee(2, "Mayur", "Lawand", 166000));
		dao.save(new Employee(3, "Ganesh", "Shinde", 180000));
		dao.save(new Employee(4, "Roshan", "Patil", 92000));
		dao.save(new Employee(5, "Amit", "Kumar", 100000));

		List<Employee> employeeList = (List<Employee>) dao.findAll();
		System.out.println(employeeList);

		/*
		 * Employee emp1 = dao.findById(1).orElse(new Employee());
		 * System.out.println(emp1);
		 * 
		 * List<Employee> emp2 = dao.findByFirstName("AMIT"); System.out.println(emp2);
		 * 
		 * Employee emp3 = dao.findById(2).orElseThrow(); emp3.setSalary(170000);
		 * dao.save(emp3); dao.delete(emp3);
		 * 
		 * dao.deleteById(3);
		 */

		List<String> names = dao.getAllFirstName();
		Iterator<String> it_name = names.iterator();
		while (it_name.hasNext()) {
			String first_name = it_name.next();
			System.out.println(first_name);
		}

		List<Employee> orderedEmployees = dao.getOrderedEmployees();
		Iterator<Employee> it = orderedEmployees.iterator();
		while (it.hasNext()) {
			Employee emp = it.next();
			System.out.println(emp);
		}

		List<Object[]> objects = dao.getGroupedEmployees();
		Iterator<Object[]> it2 = objects.iterator();
		while (it2.hasNext()) {
			Object[] objArr = it2.next();
			System.out.println(objArr[0] + "    " + objArr[1]);

		}

		List list = dao.getCountOfemployees();
		Iterator it3 = list.iterator();
		System.out.println(it3.next());

	}

}
