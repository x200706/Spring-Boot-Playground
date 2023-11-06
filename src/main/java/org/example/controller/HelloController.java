package org.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.example.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// 一個很古意的Spring Boot Controller
@Controller
// @RestController
//這邊也可以加@RequestMapping
public class HelloController {
    @Autowired
    private Book book;

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
    @GetMapping(value = "jsptest")
    public String helloJSP(){
        return "jsptest";
    }
    // 假如你的頁面裡使用變數${color}，你可以在傳入值傳入ModelMap，根據對應鍵值（這邊k會是color，v就是你要顯示的變數值）填寫內容

    @GetMapping(value = "paramtest")
    @ResponseBody
    public String helloParam(@RequestParam String name){
        return name;
    }
    
    @GetMapping(value = "restfultest/{id}")
    @ResponseBody
    public String RESTfulParam(@PathVariable String id){
        return id;
    }
    
    @GetMapping(value = "restfultest/{name}")
    @ResponseBody
    public String RESTfulParam2(@PathVariable("name") String str){ //自製映射
        return str;
    }
    
    @GetMapping(value = "returnobj")
    @ResponseBody
    public Object returnOBJ(){ 
        Map<String, String> map = new HashMap<>();
        map.put("k1","v1");
        map.put("k2","v2");
        return map;
    }
    
    @GetMapping(value = "posttest")
    @ResponseBody
    public Object postTest(@RequestParam(value = "name", defaultValue = "小華") String name){ 
        Map<String, String> map = new HashMap<>();
        map.put("name",name);
        return map;
    }

    @GetMapping(value = "domaintest")
    @ResponseBody
    public Object domainTest(){ 
        return book;
    }
}