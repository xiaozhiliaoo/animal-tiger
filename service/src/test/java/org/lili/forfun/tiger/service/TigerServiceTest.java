package org.lili.forfun.tiger.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lili.forfun.tiger.TigerTestApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author lili
 * @description
 * @create 2019/7/8 18:16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TigerTestApplication.class)
@Slf4j
public class TigerServiceTest {

    @Autowired
    private TigerService tigerService;

    @Test
    public void request() {
        String hello = tigerService.request("hello");
        System.out.println(hello);
    }
}