package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/page")
//@RestController
@Controller
public class HtmlController {
    @GetMapping("/addUser")
    public  String addUser() {
        return "addUser";
    }
}
