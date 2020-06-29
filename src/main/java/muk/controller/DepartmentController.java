package muk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import muk.beans.Department;
import muk.bo.BODepartment;

@Controller
@RequestMapping("/dept")
public class DepartmentController {

	@Autowired
	private BODepartment dao_department;
	
	@RequestMapping("/add")
	private String viewDept(Model model)
	{
		model.addAttribute("department_obj", new Department());
		model.addAttribute("department_list", dao_department.getAllDepartments());
		return "add_dept";
	}
	
	@RequestMapping("/delete")
	private String deleteDept(Model model,@RequestParam("dept_id") int dept_id,RedirectAttributes redirectAttribute)
	{
		dao_department.delete_department(dept_id);
		redirectAttribute.addFlashAttribute("message","Department Deleted SuccessFully !");
		return "redirect:add";
	}
	
	@RequestMapping("/save_department")
	private String addDept(@ModelAttribute("department_obj") Department department,RedirectAttributes redirectAttribute)
	{
		dao_department.add_department(department);
		redirectAttribute.addFlashAttribute("message","Department Added SuccessFully !");
		return "redirect:add";
	}
}
