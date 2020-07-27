package com.spring.ddtwork.controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/dep")   // 預設 Url 根目錄
public class DepartmentController {
 
    // 映射 / 的要求 (request)，並交由本方法處理
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        // 回傳至 View Page : home.jsp
        return "home";
    }
    
    // 映射 / 的要求 (request)，並交由本方法處理
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello(Authentication authentication, Model model) {
        
    	
    	// 回傳至 View Page : hello.jsp
        return "hello";
    }    
}
