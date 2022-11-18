package com.recipe.project.recipe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping({"", "/", "/home", "/index"})
    public String getIndexPage(){
        System.out.println("yeah");
        return "index";
    }
}
