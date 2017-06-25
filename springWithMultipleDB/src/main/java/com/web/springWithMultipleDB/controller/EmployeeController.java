package com.web.springWithMultipleDB.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import com.web.springWithMultipleDB.entity.Employee;
import com.web.springWithMultipleDB.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private LocaleResolver localeResolver;
	@RequestMapping("/employeeform")
	public ModelAndView user(){
		ModelAndView mv = new ModelAndView("employeeform","employee",new Employee());
		//setPageData(mv.getModelMap());
		return mv;
	}
	
	//@RequestMapping("/addEmployee")
	@RequestMapping(value="addEmployee", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("employee") @Valid Employee employee, BindingResult result, 
			ModelMap model, HttpServletRequest request) {
		//System.out.println("testing: "+employee.getAddress().size());
		/*boolean flag=employeeService.addPerson(employee);
		if(flag){
			model.addAttribute(new Employee());
			model.addAttribute("msg", getMsg("employee.added", request));
		}else{
			model.addAttribute("msg", getMsg("employee.duplicate", request));
		}
		 setPageData(model);*/
		return "employeeform";
	}
	@RequestMapping(value="employeeById")
	public String getPersonById(ModelMap model, HttpServletRequest request) {
		Long employeeid = Long.parseLong(request.getParameter("employeeid"));
		Employee employee = employeeService.getEmployeeById(employeeid);
		setPageData(model);
		model.addAttribute(employee);		
		return "employeeform";
	}
	
	@RequestMapping(value="updateEmployee",method = RequestMethod.POST)
	public String updateEmployee(@ModelAttribute("employee") @Valid Employee employee, BindingResult result, 
			ModelMap model, HttpServletRequest request) {
		employeeService.updateEmployee(employee);
		model.addAttribute(new Employee());
		model.addAttribute("msg", getMsg("employee.updated", request));
		setPageData(model);
		return "employeeform";
	}

	private void setPageData(ModelMap model) {
		System.out.println(employeeService.getAllEmployees().get(0).getSalary());
		model.addAttribute("allData",employeeService.getAllEmployees());
		
	}

	private String getMsg(String key, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return messageSource.getMessage(key, null, localeResolver.resolveLocale(request));
	}
	
}
