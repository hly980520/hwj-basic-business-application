package com.hwj.basic.business.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Program: hwj
 * @Description:
 * @author: peng.huang
 * @since: 2025-03-18 12:03:28
 */
@SpringBootTest(classes = Application.class,
value = {"-Dspring.profiles.active=dev"})
public abstract class BaseTest {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

}
