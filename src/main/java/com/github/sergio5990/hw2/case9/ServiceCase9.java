package com.github.sergio5990.hw2.case9;

import com.github.sergio5990.hw2.case8.IDao8;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCase9 {

    @Value("${secretKey}")
    private String key;

    public String getKey() {
        return key;
    }

}
