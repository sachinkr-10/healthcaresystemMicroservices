package com.cg.dcms.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.dcms.entity.DiagnosticCenterEntity;

@Repository
public interface DiagnosticCenterRepository extends JpaRepository<DiagnosticCenterEntity,Long>{

	

}
