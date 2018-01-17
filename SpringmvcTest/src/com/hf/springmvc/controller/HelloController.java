package com.hf.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hf.springmvc.beans.User;

@Controller
@RequestMapping(value="/hello")
public class HelloController {
	 @RequestMapping(value="/world",method=RequestMethod.GET)
	    public String hello(Model model){
	        model.addAttribute("msg", "你好spring mvc");
	        return "index";
	    }
	 @RequestMapping(value="/login",method=RequestMethod.GET)
	 public String login(Model model){
		 model.addAttribute("msg", "你好spring mvc");
		 return "./index";//返回到index页面
	 }
	 
	 @RequestMapping(value="/indexs")
	 public String index(@RequestParam String name){
		 System.out.println(name);
		 return "index";
	 }
	/* @RequestMapping(value="/{test}")
	 public String test(@PathVariable String test){
		 System.out.println(test);
		 return "index";
	 }*/
	 @RequestMapping(value="/{test}")
	 @ResponseBody
	 public String test1(@PathVariable String test,@RequestBody User user){
		 System.out.println(user);
		 return test;
	 }
	 
}
