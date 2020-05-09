package com.cg.dcms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dcms.model.DiagnosticCenterModel;
import com.cg.dcms.service.DiagnosticCenterService;

@RestController
@RequestMapping("/diagCenter")
public class DiagnosticCenterController {
	
	@Autowired
	DiagnosticCenterService dcs;
	
	@GetMapping
	public ResponseEntity<List<DiagnosticCenterModel>> findAll(){
		return new ResponseEntity<>(dcs.findAll(),HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<DiagnosticCenterModel> add(@RequestBody DiagnosticCenterModel model){
		model=dcs.add(model);
		return new ResponseEntity<>(model,HttpStatus.CREATED);
	}

}
