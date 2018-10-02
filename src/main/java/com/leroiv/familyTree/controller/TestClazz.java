package com.leroiv.familyTree.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestClazz {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();
//        System.out.println(bCryptPasswordEncoder.encode("admin"));
//        System.out.println(bCryptPasswordEncoder.encode("user"));
//        System.out.println(bCryptPasswordEncoder.encode("guest"));
        System.out.println(bCryptPasswordEncoder.matches("user","$2a$10$13UrbXyGb30i5Gcd/I2fX.MmPzWT0/p8sBtktcPHl1NMSd/ro5576"));
    }
}
