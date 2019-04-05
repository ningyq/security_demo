package com.ningyq.security_demo.repository;

import com.ningyq.security_demo.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.userName = ?1")
    User findByUserName(String userName);
}
