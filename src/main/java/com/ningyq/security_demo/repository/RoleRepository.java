package com.ningyq.security_demo.repository;

import com.ningyq.security_demo.bean.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query("select r from Role r where r.id = ?1")
    Role findRolesById(Integer Id);
}
