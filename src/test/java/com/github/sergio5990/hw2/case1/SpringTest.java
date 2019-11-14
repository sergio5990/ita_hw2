package com.github.sergio5990.hw2.case1;

import com.github.sergio5990.hw2.case2.JavaConfigCase2;
import com.github.sergio5990.hw2.case2.ServiceCase2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = JavaConfigCase2.class)
public class SpringTest {

    @Autowired
    private ServiceCase2 serviceCase2;

    @Test
    void name() {
        assertNotNull(serviceCase2);
    }
}
