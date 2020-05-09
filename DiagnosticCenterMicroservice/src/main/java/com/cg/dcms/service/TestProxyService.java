package com.cg.dcms.service;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.cg.dcms.model.TestDataModel;

@FeignClient(name="test-service")
@RibbonClient(name="test-service")
public interface TestProxyService {
	
	@GetMapping("/tests")
	public List<TestDataModel> getalltest();

}
