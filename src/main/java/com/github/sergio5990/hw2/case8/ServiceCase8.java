package com.github.sergio5990.hw2.case8;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCase8 {

    private final List<IDao8> daos;

    public ServiceCase8(List<IDao8> daos) {
        this.daos = daos;
    }

    public List<IDao8> getDaos() {
        return daos;
    }
}
