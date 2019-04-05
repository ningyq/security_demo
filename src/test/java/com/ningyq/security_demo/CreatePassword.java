package com.ningyq.security_demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CreatePassword {


    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


        String str = passwordEncoder.encode("123456");
        System.out.println(str);
        System.out.println(passwordEncoder.matches("123456", str));
    }
}
