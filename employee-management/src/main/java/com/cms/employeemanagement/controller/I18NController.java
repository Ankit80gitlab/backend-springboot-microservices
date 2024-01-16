package com.cms.employeemanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class I18NController {

    @RequestMapping("/locale")
    public String locale() {
        return "locale";
    }

}
