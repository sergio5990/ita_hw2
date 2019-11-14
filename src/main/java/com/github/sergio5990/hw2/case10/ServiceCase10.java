package com.github.sergio5990.hw2.case10;

import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class ServiceCase10 {

    @Profiling
    public void execute(){
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(200));
            System.out.println("work");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void execute2(){
        System.out.println("2");
    }
}
