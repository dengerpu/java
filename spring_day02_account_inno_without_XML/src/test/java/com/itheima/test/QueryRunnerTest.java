package com.itheima.test;

import com.itheima.config.SpringConfigurtation;
import com.itheima.service.IAccountService;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class QueryRunnerTest {
    @Test
    public void testRunner(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfigurtation.class);
        QueryRunner runner = ac.getBean("runner", QueryRunner.class);
        QueryRunner runner1 = ac.getBean("runner", QueryRunner.class);
        System.out.println(runner == runner1);
    }
}
