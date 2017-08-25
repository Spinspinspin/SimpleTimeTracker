package com.libertymutual.goforcode.timeless.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.libertymutual.goforcode.timeless.models.TimesheetItem;
import com.libertymutual.goforcode.timeless.services.SimpleTimeTrackerRepository;




@Controller
@RequestMapping("/")

public class SimpleTimeTrackerController {
	
	private SimpleTimeTrackerRepository repository;
	public SimpleTimeTrackerController(SimpleTimeTrackerRepository repository) {
		this.repository = repository;
	}

@GetMapping("")
    public String redirectToApplication() {
        return "timesheet/default";
    }


//	@GetMapping("timesheet")
//    public ModelAndView list() {
//        ModelAndView mv = new ModelAndView("timesheet/default");
//        List<TimesheetItem> item = repository.getAll();
//        mv.addObject("item", item);
//        
//        return mv;
//    }

	

	@PostMapping("submit")
    public String create(TimesheetItem item) {
        repository.create(item);
        return "redirect:/";
    }
}