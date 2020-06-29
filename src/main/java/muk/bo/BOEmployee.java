package muk.bo;

import java.util.List;

import muk.beans.Employee;

public interface BOEmployee {

	void addEmployee(Employee emp);
	List<Employee> getListofEmployee();
	void deleteEmployee(int emp_id);
}
