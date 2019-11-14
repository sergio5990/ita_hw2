package com.github.sergio5990.hw2.case6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceCase6 {

    private final DaoCase6 daoCase;

    public ServiceCase6(DaoCase6 daoCase) {
        this.daoCase = daoCase;
    }

    public DaoCase6 getDaoCase() {
        return daoCase;
    }
}
