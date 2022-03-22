package com.codegym.controller;

import com.codegym.dto.EmployeeDto;
import com.codegym.model.Employee;
import com.codegym.service.IDivisionService;
import com.codegym.service.IEducationService;
import com.codegym.service.IEmployeeService;
import com.codegym.service.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.*;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IPositionService iPositionService;

    @Autowired
    private IDivisionService divisionService;

    @Autowired
    private IEducationService educationService;

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping
    private ModelAndView homeEmployee(@PageableDefault(value = 5, sort = "nameEmployee", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Employee> employees = employeeService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("employee/list");
        modelAndView.addObject("employeeList", employees);
        modelAndView.addObject("position", iPositionService.findAll());
        modelAndView.addObject("division", divisionService.findAll());
        modelAndView.addObject("educationDegree", educationService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("employee/create");
        modelAndView.addObject("employeeDto", new EmployeeDto());
        modelAndView.addObject("position", iPositionService.findAll());
        modelAndView.addObject("division", divisionService.findAll());
        modelAndView.addObject("educationDegree", educationService.findAll());
        return modelAndView;
    }

    @PostMapping("/save")
    public String createEmployee(@Validated @ModelAttribute EmployeeDto employeeDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("position", iPositionService.findAll());
            model.addAttribute("division", divisionService.findAll());
            model.addAttribute("educationDegree", educationService.findAll());
            return "employee/create";
        } else{
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            employeeService.save(employee);
            model.addAttribute("message", "Thêm mới nhân viên " + employee.getNameEmployee() + " thành công!");
            return "redirect:/employee";
        }

    }

    @PostMapping("/delete")
    public String deleteEmployee(@ModelAttribute Employee employee, RedirectAttributes redirectAttributes) {
        employeeService.remove(employee.getId());
        redirectAttributes.addFlashAttribute("message", "Xóa nhân viên thành công!");
        return "redirect:/employee";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable int id) {
        Employee employee = employeeService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/employee/edit");
        modelAndView.addObject("employees", employee);
        modelAndView.addObject("position", iPositionService.findAll());
        modelAndView.addObject("division", divisionService.findAll());
        modelAndView.addObject("educationDegree", educationService.findAll());
        return modelAndView;
    }

    @PostMapping("/edit")
    public String editEmployee(Employee employee, RedirectAttributes redirectAttributes) {
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("message", "Chỉnh sửa nhân viên thành công!");
        return "redirect:/employee";
    }

    @GetMapping("/search")
    public String searchByName(@RequestParam(name = "name", required = false) String name, Model model,@PageableDefault(value = 5, sort = "nameEmployee", direction = Sort.Direction.ASC) Pageable pageable) {
        model.addAttribute("employeeList",employeeService.findByName(name, pageable));
        return "/employee/list";
    }
}
