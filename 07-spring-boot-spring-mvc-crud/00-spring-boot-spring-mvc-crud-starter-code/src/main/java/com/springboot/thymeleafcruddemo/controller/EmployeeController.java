package com.springboot.thymeleafcruddemo.controller;

import com.springboot.thymeleafcruddemo.entity.Employee;
import com.springboot.thymeleafcruddemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model){
        model.addAttribute("employees", employeeService.findAll());

        return "/employees/list-employees";
    }

    @GetMapping("/showAddForm")
    public String showAddForm(Model model){
        model.addAttribute("employee", new Employee());

        return "/employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);

        return "redirect:/employees/list";
    }

    @GetMapping("/showUpdateForm")
    public String updateEmployee(@RequestParam("employeeId") int id, Model model){
        model.addAttribute("employee", employeeService.findById(id));

        return "/employees/employee-form";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int id){
        employeeService.deleteById(id);

        return "redirect:/employees/list";
    }
}
