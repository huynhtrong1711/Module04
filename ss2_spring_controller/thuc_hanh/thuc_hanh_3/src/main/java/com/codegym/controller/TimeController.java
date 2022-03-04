package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {

    @GetMapping(value = "/world-clock")
    public String getTimeByTimezone(ModelMap modelMap ,@RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city) {
        Date date = new Date();
        TimeZone timeZone = TimeZone.getDefault();
        TimeZone local = TimeZone.getTimeZone(city);
        long local_time = date.getTime() + (local.getRawOffset() - timeZone.getRawOffset());
        date.setTime(local_time);
        modelMap.addAttribute("city", city);
        modelMap.addAttribute("date", date);
        return "/index";
    }
}
