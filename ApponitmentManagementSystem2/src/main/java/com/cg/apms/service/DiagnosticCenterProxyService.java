package com.cg.apms.service;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.cg.apms.model.DiagnosticCenterModel;

@FeignClient(name="diagnostic-service")
@RibbonClient(name="diagnostic-service")

public interface DiagnosticCenterProxyService {
        @GetMapping("/diagCenter")
        public List<DiagnosticCenterModel> getAllCenters();
}
