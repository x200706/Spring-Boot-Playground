package org.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

// 一個很古意的Spring Boot Controller
@Controller
public class HelloController {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @ResponseBody
    public List<String> hello(){
        ArrayList<String> test = new ArrayList<>();
        test.add("h");
        test.add("e");
        test.add("l");
        test.add("l");
        test.add("o");
        test.add("o");
        return test;
    }
    @RequestMapping(value = "/hellohtml",method = RequestMethod.GET)
    @ResponseBody
    public String helloHtml(){
        StringBuilder sb = new StringBuilder();
        sb.append("<h1>超古早味</h1>");
        return sb.toString();
    }
}