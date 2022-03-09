package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.model.Province;
import com.codegym.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.ManyToOne;

@Controller
@RequestMapping("provinces")
public class ProvinceController {

    @Autowired
    private IProvinceService provinceService;

    @GetMapping("/list")
    public ModelAndView home() {
        return new ModelAndView("province/list", "province", provinceService.findAll());
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("province/create");
        modelAndView.addObject("province", new Province());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Province province, RedirectAttributes redirectAttributes) {
        provinceService.save(province);
        redirectAttributes.addFlashAttribute("message", "Thêm mới tỉnh thành công!");
        return "redirect:/provinces/list";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        Province province = provinceService.findById(id);
        ModelAndView modelAndView = new ModelAndView("province/edit");
        modelAndView.addObject("province", province);
        return modelAndView;
    }

    @PostMapping("/edit")
    public String updateProvince(@ModelAttribute Province province, RedirectAttributes redirectAttributes) {
        provinceService.save(province);
        redirectAttributes.addFlashAttribute("message", "Chỉnh sửa thành công!");
        return "redirect:/provinces/list";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDelete(@PathVariable int id) {
        Province province = provinceService.findById(id);
        ModelAndView modelAndView = new ModelAndView("province/delete");
        modelAndView.addObject("province", province);
        return modelAndView;
    }

    @PostMapping("/delete")
    public String deleteProvince(@ModelAttribute Province province, RedirectAttributes redirectAttributes) {
        provinceService.remove(province.getId());
        redirectAttributes.addFlashAttribute("message", "Xóa thành công!");
        return "redirect:/provinces/list";
    }
}
