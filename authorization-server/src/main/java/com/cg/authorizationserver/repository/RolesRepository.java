package com.cg.authorizationserver.repository;

import com.cg.authorizationserver.entity.Roles;
import org.springframework.data.repository.CrudRepository;

public interface RolesRepository extends CrudRepository<Roles, Long> {
}
