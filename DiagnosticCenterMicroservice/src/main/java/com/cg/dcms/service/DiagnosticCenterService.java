package com.cg.dcms.service;

import java.util.List;

import com.cg.dcms.model.DiagnosticCenterModel;

public interface DiagnosticCenterService {
	
	 List<DiagnosticCenterModel> findAll();
	 DiagnosticCenterModel add(DiagnosticCenterModel model);
	 DiagnosticCenterModel findById(Long centerId);
	

}
