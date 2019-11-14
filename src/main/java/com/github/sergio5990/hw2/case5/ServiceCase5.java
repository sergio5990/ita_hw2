package com.github.sergio5990.hw2.case5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceCase5 {
    private DaoCase5 daoCase;

    @Autowired
    public void setDaoCase(DaoCase5 daoCase) {
        this.daoCase = daoCase;
    }

    public DaoCase5 getDaoCase() {
        return daoCase;
    }
}
