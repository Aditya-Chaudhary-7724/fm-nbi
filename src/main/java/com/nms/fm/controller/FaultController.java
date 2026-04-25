package com.nms.fm.controller;

import com.nms.fm.entity.Fault;
import com.nms.fm.service.FaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faults")
public class FaultController {

    @Autowired
    private FaultService faultService;

    @PostMapping
    public Fault createFault(@RequestBody Fault fault) {
        return faultService.createFault(fault);
    }

    @GetMapping
    public List<Fault> getAllFaults() {
        return faultService.getAllFaults();
    }

    @PutMapping("/{id}")
    public Fault updateFault(@PathVariable Long id, @RequestParam String status) {
        return faultService.updateFaultStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void deleteFault(@PathVariable Long id) {
        faultService.deleteFault(id);
    }
}