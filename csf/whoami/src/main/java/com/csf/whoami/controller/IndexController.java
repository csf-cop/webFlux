/**
 * 
 */
package com.csf.whoami.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author TuanDQ
 *
 */
@Controller
public class IndexController {

	@GetMapping("/hellopage")
	public String helloPage() {
		return "hello";
	}

	@RequestMapping("/")
	public String indexPage() {
		return "index";
	}
	
	
	// Secure
	@GetMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hello User!";
    }
	@GetMapping("/secure")
    @ResponseBody
    public String saySecure() {
        return "Secure Hello!";
    }
}
