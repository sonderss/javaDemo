package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/page")
//@RestController
@Controller
public class HtmlController {
    @GetMapping("/addUser")
    public  String addUser() {
        return "addUser";
    }

    @GetMapping("/vue")
    public  String vue() {
        return "vue";
    }
}
