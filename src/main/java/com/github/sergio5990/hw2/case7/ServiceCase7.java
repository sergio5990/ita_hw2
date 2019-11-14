package com.github.sergio5990.hw2.case7;

import org.springframework.stereotype.Service;

@Service
public class ServiceCase7 {

    private final IDao7 daoCase7;
    private final IDao7 daoCase71;

    public ServiceCase7(IDao7 daoCase7, IDao7 daoCase71) {
        this.daoCase7 = daoCase7;
        this.daoCase71 = daoCase71;
    }

    public IDao7 getDaoCase7() {
        return daoCase7;
    }

    public IDao7 getDaoCase71() {
        return daoCase71;
    }
}
