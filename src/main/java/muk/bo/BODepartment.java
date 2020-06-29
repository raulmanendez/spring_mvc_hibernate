package muk.bo;

import java.util.List;

import muk.beans.Department;

public interface BODepartment {
void add_department(Department dept);
void delete_department(int dept_id);
List<Department> getAllDepartments();
}
