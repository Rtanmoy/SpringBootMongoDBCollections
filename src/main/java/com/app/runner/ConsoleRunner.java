package com.app.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.document.Employee;
import com.app.repo.EmployeeRepository;
@Component
public class ConsoleRunner implements CommandLineRunner {
@Autowired
private EmployeeRepository repo;
	@Override
	public void run(String... args) throws Exception {
	repo.deleteAll();
	Employee e=repo.save(new Employee(1,"TR",2.2));
	System.out.println(e);

	
	List<Employee> emps=repo.saveAll(Arrays.asList(
			             new Employee(2,"AR",3.3),
			             new Employee(3,"RR",4.4)));
	System.out.println(emps);
	for(Employee ee:emps) {
		System.out.println(ee.getId());
	}
	System.out.println("------------**************----------------");
	//Some Exception cases
	//#1 save()
	repo.save(new Employee(11,"TR",2.2));
	repo.save(new Employee("12AS",10,"RT",22.2));
	repo.save(new Employee("12AS",10,"RoT",22.2));//update(rt-rot
	
	//#2 insert()
	repo.insert(new Employee(12,"RT",22.2));
	repo.insert(new Employee("13AS",10,"RT",22.2));
	repo.insert(new Employee("13AS",10,"ROT",22.2));//trows exception
	}
}
