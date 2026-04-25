package com.nms.fm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "HOME WORKING 🚀";
    }

    @GetMapping("/test")
    public String test() {
        return "TEST WORKING ✅";
    }
}