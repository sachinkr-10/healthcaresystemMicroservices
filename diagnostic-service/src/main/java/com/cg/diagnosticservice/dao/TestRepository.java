package com.cg.diagnosticservice.dao;

import com.cg.diagnosticservice.entity.Test;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends CrudRepository<Test,Long> {

}
