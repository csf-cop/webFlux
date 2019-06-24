/**
 * 
 */
package com.csf.whoami.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TuanDQ
 *
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

	/**
	 * Hello page.
	 * @param model
	 * @return
	 */
	@RequestMapping("/")
    public String index(final Model model) {
        return "hello";

    }
}
