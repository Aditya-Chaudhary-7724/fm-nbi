package com.nms.fm.controller;

import com.nms.fm.entity.Fault;
import com.nms.fm.service.FaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faults")   // 🔥 Base URL
public class FaultController {

    @Autowired
    private FaultService faultService;

    // ✅ CREATE
    @PostMapping
    public Fault createFault(@RequestBody Fault fault) {
        return faultService.createFault(fault);
    }

    // ✅ READ ALL
    @GetMapping
    public List<Fault> getAllFaults() {
        return faultService.getAllFaults();
    }

    // ✅ READ BY ID
    @GetMapping("/{id}")
    public Fault getFaultById(@PathVariable Long id) {
        return faultService.getFaultById(id);
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public Fault updateFault(@PathVariable Long id, @RequestBody Fault fault) {
        return faultService.updateFault(id, fault);
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public String deleteFault(@PathVariable Long id) {
        faultService.deleteFault(id);
        return "Deleted Successfully";
    }
}