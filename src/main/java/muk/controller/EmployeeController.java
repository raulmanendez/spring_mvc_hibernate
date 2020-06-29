package muk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import muk.beans.Employee;
import muk.bo.BODepartment;
import muk.bo.BODesignation;
import muk.bo.BOEmployee;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private BODepartment bo_dept;
	
	@Autowired
	private BODesignation bo_desig;
	
	@Autowired
	private BOEmployee bo_employee;
	
	@RequestMapping("/add")
	public String addEmp(Model model)
	{
		model.addAttribute("department_list",bo_dept.getAllDepartments());
		model.addAttribute("designation_list",bo_desig.getAllDesignations());
		
		model.addAttribute("employee_list",bo_employee.getListofEmployee());
		model.addAttribute("employee_obj",new Employee());
		return "add_emp";
	}
	
	@RequestMapping("/delete")
	public String deleteEmp(@RequestParam("emp_id") int emp_id,RedirectAttributes redirectattribute)
	{
		bo_employee.deleteEmployee(emp_id);
		redirectattribute.addFlashAttribute("message","The Employee Deleted Successfully !");
		return "redirect:add";
	}
	
	@RequestMapping("/save_employee")
	private String save_employee(@ModelAttribute Employee emp,RedirectAttributes redirectattribute)
	{
		bo_employee.addEmployee(emp);
		
		redirectattribute.addFlashAttribute("message","The Employee Added Successfully !");
		return "redirect:add";
	}
	
}
