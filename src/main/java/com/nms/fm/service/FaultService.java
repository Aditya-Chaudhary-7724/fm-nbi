package com.nms.fm.service;

import com.nms.fm.entity.Fault;
import com.nms.fm.repository.FaultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FaultService {

    @Autowired
    private FaultRepository faultRepository;

    public Fault createFault(Fault fault) {
        fault.setTimestamp(LocalDateTime.now());
        return faultRepository.save(fault);
    }

    public List<Fault> getAllFaults() {
        return faultRepository.findAll();
    }

    public Fault updateFaultStatus(Long id, String status) {
        Fault fault = faultRepository.findById(id).orElseThrow();
        fault.setStatus(status);
        return faultRepository.save(fault);
    }

    public void deleteFault(Long id) {
        faultRepository.deleteById(id);
    }
}