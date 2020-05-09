package com.cg.dcms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dcms.dao.DiagnosticCenterRepository;
import com.cg.dcms.entity.DiagnosticCenterEntity;
import com.cg.dcms.model.DiagnosticCenterModel;
import com.cg.dcms.model.TestDataModel;

@Service
public class DiagnosticCenterServiceImpl implements DiagnosticCenterService  {
	
	@Autowired
	private DiagnosticCenterRepository repo;
	@Autowired
	private TestProxyService testProxy;
	
	public DiagnosticCenterModel of(DiagnosticCenterEntity entity) {
		DiagnosticCenterModel model =null;
        if(entity!=null)
        {
         	model=new DiagnosticCenterModel();
         	model.setCenterId(entity.getCenterId());
            model.setCenterName(entity.getCenterName());
            model.setAddress(entity.getAddress());
            model.setContactInfo(entity.getContactInfo());
            List<TestDataModel> testSource=testProxy.getalltest();
            if(testSource!=null) {
            	model.setTestList(testSource);
            }
        }
        return model;
}
public DiagnosticCenterEntity of(DiagnosticCenterModel model) {
	DiagnosticCenterEntity entity=null;
if(model!=null) {
entity=new DiagnosticCenterEntity();
entity.setCenterId(model.getCenterId());
entity.setCenterName(model.getCenterName());
entity.setAddress(model.getAddress());
entity.setContactInfo(model.getContactInfo());
}

return entity;
}

 @Override
public List<DiagnosticCenterModel> findAll(){
      return repo.findAll().stream().map(e  ->  of(e)).collect(Collectors.toList());	
}

@Override
public DiagnosticCenterModel findById(Long centerId) {
	DiagnosticCenterModel model=null;
	DiagnosticCenterEntity entity=repo.findById(centerId).orElse(null);
     if(entity!=null) {
      model=of(entity);
    }
return  model;
}

@Override
public  DiagnosticCenterModel add( DiagnosticCenterModel model) {

return of(repo.save(of( model)));
}

}
