package com.thomas.repository;

import org.springframework.stereotype.Repository;

@Repository
public class HelloRepositoryImpl implements HelloRepository {
    @Override
    public String returnParam(String myString) {
        return myString;
    }
}
