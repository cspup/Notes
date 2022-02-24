package com.csp.notes.controller;

import com.csp.notes.service.LabelService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author csp
 * @date 2022/2/22 20:41
 * @description
 */
@Controller
public class IndexController {

    final private LabelService labelService;
    IndexController (LabelService labelService){
        this.labelService = labelService;
    }

    @RequestMapping(value = "/")
    public String redirect(HttpServletRequest request,HttpServletResponse response){
        String label = labelService.generateLabel();
        response.addHeader("label",label);
        return "redirect:/"+label;
    }

    @RequestMapping(value = "/sdsds/{label}")
    public String redirect(@PathVariable("label") String label, HttpServletResponse response){
        if (label.isEmpty()){
            label = labelService.generateLabel();
        }
        response.addHeader("label",label);
        return "/index.html";
    }
}
