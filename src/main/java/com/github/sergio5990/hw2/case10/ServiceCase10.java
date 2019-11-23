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

    @Profiling
    public void execute1(){
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(200));
            System.out.println("work 1");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void execute2(){
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(200));
            System.out.println("work 2");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
