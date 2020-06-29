package muk.dao;

import java.util.List;

import muk.beans.Department;

public interface DAODepartment {
	void add_department(Department dept);
	void delete_department(int dept_id);
	List<Department> getAllDepartments();
}
