package com.ningyq.security_demo.repository;

import com.ningyq.security_demo.bean.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

    @Query("select ur from UserRole ur where ur.userId = ?1")
    List<UserRole> findUserRolesByUId(Integer userId);
}
