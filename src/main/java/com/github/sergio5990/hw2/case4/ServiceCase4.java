package com.github.sergio5990.hw2.case4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceCase4 {
    @Autowired
    private DaoCase4 daoCase;

    public DaoCase4 getDaoCase() {
        return daoCase;
    }
}
