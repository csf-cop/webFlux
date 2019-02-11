/**
 * 
 */
package com.csf.mama.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author TuanDQ
 *
 */
@Controller
@RequestMapping(value = "/events")
public class EventController {

//	@Autowired
//	EventService service;

	@GetMapping(name = "/")
	public String helloWorld(Model model) {

//		List<Event> events = service.getAllPublicEvents();
//		model.addAttribute("events", events);

		return "welcome";
	}
}
