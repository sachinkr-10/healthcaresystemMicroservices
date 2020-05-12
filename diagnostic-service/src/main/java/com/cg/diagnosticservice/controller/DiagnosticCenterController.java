package com.cg.diagnosticservice.controller;

import com.cg.diagnosticservice.entity.Test;
import com.cg.diagnosticservice.entity.DiagnosticCenter;
import com.cg.diagnosticservice.dao.DiagnosticCenterRepository;
import com.cg.diagnosticservice.dao.TestRepository;
import com.cg.diagnosticservice.dto.DiagnosticCenterDto;
import com.cg.diagnosticservice.dto.RestResponse;
import com.cg.diagnosticservice.exceptions.DiagnosticCenterNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("diagnosticCenter")
public class DiagnosticCenterController {
    @Autowired
    TestRepository testRepository;
    RestTemplate restTemplate;
    @Autowired
    DiagnosticCenterRepository diagnosticCenterRepository;


    private List<Test> createDefaultTest(DiagnosticCenter diagnosticCenter) {
//       restTemplate.postForEntity("",Object o,Test.class,)
        List<Test> testList = new ArrayList<>();
        Test t1 = new Test();
        t1.setTestName("Blood Pressure");
        Test t2 = new Test();
        t2.setTestName("Sugar Test");
        Test t3 = new Test();
        t3.setTestName("Eco");
        testList.add(t1);
        testList.add(t2);
        testList.add(t3);
//        testRepository.saveAll(testList);
        return testList;
    }
    @GetMapping
    ResponseEntity<?> getCenters() {
        List<DiagnosticCenter> diagnosticCenters = new ArrayList<>();
        diagnosticCenterRepository.findAll().forEach((diagnosticCenters::add));
        return ResponseEntity.ok(new RestResponse<>(diagnosticCenters, true, null));
    }


    @PutMapping("/{id}")
    ResponseEntity<?> updateCenter(@PathVariable(value = "id") long id, @RequestBody DiagnosticCenterDto diagnosticCenterDto) throws DiagnosticCenterNotFoundException {
        Optional<DiagnosticCenter> optionalDiagnosticCenter = diagnosticCenterRepository.findById(id);

        if(optionalDiagnosticCenter.isPresent()){
            DiagnosticCenter v=optionalDiagnosticCenter.get();
            try{
                v.setCenterName(diagnosticCenterDto.getCenterName());
                v.setAddress(diagnosticCenterDto.getAddress());
                v.setContactNo(diagnosticCenterDto.getContactNo());
                v.setTestList(v.getTestList());
                diagnosticCenterRepository.save(v);
                return ResponseEntity.ok(new RestResponse<>("updated", true, null));
            }
            catch (Exception e){
                return ResponseEntity.ok(new RestResponse<>(null, false, e.getCause().getMessage()));
            }
        }
        else {
            return ResponseEntity.ok(new RestResponse<>(null, false, "Not found by "+id));
        }

    }

    @DeleteMapping("/{centerId}")
    ResponseEntity<?>deleteCenter(@PathVariable(name = "centerId") long centerId){
        try{
            diagnosticCenterRepository.deleteById(centerId);
        return  ResponseEntity.ok(new RestResponse<>("deleted",true,null));
        }
        catch (Exception e){
            return  ResponseEntity.badRequest().body(new RestResponse<>(null,false,e.getCause().getMessage()));
        }
    }


    @PostMapping
    ResponseEntity<?> addCenter(@Valid @RequestBody DiagnosticCenterDto diagnosticCenterDto) {
        try {
            DiagnosticCenter d = new DiagnosticCenter();
            d.setCenterName(diagnosticCenterDto.getCenterName());
            d.setAddress(diagnosticCenterDto.getAddress());
            d.setContactNo(diagnosticCenterDto.getContactNo());
            if (diagnosticCenterDto.getId() != null)
                d.setId(diagnosticCenterDto.getId());
            d.setTestList(createDefaultTest(d));
            diagnosticCenterRepository.save(d);
            return ResponseEntity.ok(new RestResponse<>("Data added", true, null));
        } catch (Exception e) {
            return ResponseEntity.ok(new RestResponse<>(null, false, e.getCause().getMessage()));
        }


    }


}
