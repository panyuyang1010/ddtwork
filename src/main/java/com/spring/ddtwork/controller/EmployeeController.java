package com.spring.ddtwork.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.spring.ddtwork.model.*;
import com.spring.ddtwork.service.EmployeeService;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/listEmp", method = RequestMethod.GET)
	public String listEmployees(Model model) {

		List<IEmployee> employees = employeeService.getAllEmployees();

		model.addAttribute("employees", employees);

		return "listEmps";
	}

	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable("id") int id, Model model) {
		employeeService.removeEmployee(id);
		model.addAttribute("employees", employeeService.getAllEmployees());

		return "redirect:/emp/listEmps";
	}

	@RequestMapping("/addEmp")
	public String showAddEmployeeView(Model model) {

		IEmployee employee = new EmployeeModel();
		model.addAttribute("employee", employee);

		return "addEmp";
	}

	@PostMapping("/saveEmp")
	public String saveCustomer(@ModelAttribute("employee") IEmployee employee) {
		employeeService.addEmployee(employee);

		return "redirect:/emp/listEmps";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView showEditEmployeeView(@PathVariable(name = "id") int id) {

		ModelAndView mav = new ModelAndView("editEmp");

		IEmployee employee = employeeService.getEmployeeById(id);
		mav.addObject("employee", employee);

		return mav;
	}

	@PostMapping("/editEmp")
	public String editCustomer(@ModelAttribute("employee") IEmployee employee) {

		return "redirect:/emp/listEmps";
	}
}