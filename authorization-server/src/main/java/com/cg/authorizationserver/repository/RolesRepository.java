package com.cg.authorizationserver.repository;

import com.cg.authorizationserver.models.Roles;
import org.springframework.data.repository.CrudRepository;

public interface RolesRepository extends CrudRepository<Roles, Long> {
}
