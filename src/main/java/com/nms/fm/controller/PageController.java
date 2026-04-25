package com.nms.fm.controller;

import com.nms.fm.entity.Fault;
import com.nms.fm.service.FaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
public class PageController {

    @Autowired
    private FaultService faultService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("faults", faultService.getAllFaults());
        return "index";
    }

    @PostMapping("/add")
    public String addFault(@RequestParam String alarmId,
                           @RequestParam String severity,
                           @RequestParam String description,
                           @RequestParam String status) {

        Fault fault = new Fault();
        fault.setAlarmId(alarmId);
        fault.setSeverity(severity);
        fault.setDescription(description);
        fault.setStatus(status);

        // 🔥 ADD THIS LINE
        fault.setTimestamp(java.time.LocalDateTime.now());

        faultService.createFault(fault);

        return "redirect:/";
    }
    @PostMapping("/delete/{id}")
    public String deleteFault(@PathVariable Long id) {
        faultService.deleteFault(id);
        return "redirect:/";
    }

    @PostMapping("/update/{id}")
    public String updateStatus(@PathVariable Long id,
                               @RequestParam String status) {

        Fault fault = faultService.getFaultById(id);
        if (fault != null) {
            fault.setStatus(status);
            faultService.createFault(fault);
        }

        return "redirect:/";
    }
    
}