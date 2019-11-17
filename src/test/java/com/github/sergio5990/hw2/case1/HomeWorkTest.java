package com.github.sergio5990.hw2.case1;

import com.github.sergio5990.hw2.case10.ServiceCase10;
import com.github.sergio5990.hw2.case2.JavaConfigCase2;
import com.github.sergio5990.hw2.case2.ServiceCase2;
import com.github.sergio5990.hw2.case3.ServiceCase3;
import com.github.sergio5990.hw2.case4.ServiceCase4;
import com.github.sergio5990.hw2.case5.ServiceCase5;
import com.github.sergio5990.hw2.case6.ServiceCase6;
import com.github.sergio5990.hw2.case7.ServiceCase7;
import com.github.sergio5990.hw2.case8.ServiceCase8;
import com.github.sergio5990.hw2.case9.ServiceCase9;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.support.ResourcePropertySource;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class HomeWorkTest {

    @Test
    public void case1Test() {
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        final ServiceCase1 bean = context.getBean(ServiceCase1.class);

        assertNotNull(bean);
    }

    @Test
    public void case2Test() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(JavaConfigCase2.class);
        context.refresh();

        final ServiceCase2 bean = context.getBean(ServiceCase2.class);

        assertNotNull(bean);
    }

    @Test
    public void case3Test() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.github.sergio5990.hw2.case3");
        context.refresh();

        final ServiceCase3 bean = context.getBean(ServiceCase3.class);

        assertNotNull(bean);
    }

    @Test
    public void case4Test() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.github.sergio5990.hw2.case4");
        context.refresh();

        final ServiceCase4 bean = context.getBean(ServiceCase4.class);

        assertNotNull(bean.getDaoCase());
    }

    @Test
    public void case5Test() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.github.sergio5990.hw2.case5");
        context.refresh();

        final ServiceCase5 bean = context.getBean(ServiceCase5.class);

        assertNotNull(bean.getDaoCase());
    }

    @Test
    public void case6Test() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.github.sergio5990.hw2.case6");
        context.refresh();

        final ServiceCase6 bean = context.getBean(ServiceCase6.class);

        assertNotNull(bean.getDaoCase());
    }

    @Test
    public void case7Test() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.github.sergio5990.hw2.case7");
        context.refresh();

        final ServiceCase7 bean = context.getBean(ServiceCase7.class);

        assertNotNull(bean.getDaoCase7());
        assertNotNull(bean.getDaoCase71());
        assertNotEquals(bean.getDaoCase7(), bean.getDaoCase71());
    }

    @Test
    public void case8Test() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.github.sergio5990.hw2.case8");
        context.refresh();

        final ServiceCase8 bean = context.getBean(ServiceCase8.class);

        assertNotNull(bean.getDaos());
        assertFalse(bean.getDaos().isEmpty());
        assertEquals(2, bean.getDaos().size());
    }

    @Test
    public void case9Test() throws IOException {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.github.sergio5990.hw2.case9");
        context.getEnvironment().getPropertySources().addLast(new ResourcePropertySource("my.properties"));
        context.refresh();

        final ServiceCase9 bean = context.getBean(ServiceCase9.class);

        assertNotNull(bean.getKey());
        assertEquals("1234", bean.getKey());
    }

    @Test
    public void case10Test() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.github.sergio5990.hw2.case10");
        context.refresh();

        final ServiceCase10 bean = context.getBean(ServiceCase10.class);

        assertNotNull(bean);
        bean.execute();
        System.out.println("___________________");
        bean.execute1();
        System.out.println("___________________");
        bean.execute2();

    }

}