package com.nms.fm.service;

import com.nms.fm.entity.Fault;
import com.nms.fm.repository.FaultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaultService {

    @Autowired
    private FaultRepository faultRepository;

    public Fault createFault(Fault fault) {
        return faultRepository.save(fault);
    }

    public List<Fault> getAllFaults() {
        return faultRepository.findAll();
    }

    public Fault getFaultById(Long id) {
        return faultRepository.findById(id).orElse(null);
    }

    public Fault updateFault(Long id, Fault updatedFault) {
        Fault fault = faultRepository.findById(id).orElse(null);
        if (fault != null) {
            fault.setStatus(updatedFault.getStatus());
            fault.setName(updatedFault.getName());
            return faultRepository.save(fault);
        }
        return null;
    }

    public void deleteFault(Long id) {
        faultRepository.deleteById(id);
    }
}