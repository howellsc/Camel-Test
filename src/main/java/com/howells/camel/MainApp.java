package com.howells.camel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * A Camel Application
 */
public class MainApp {

    /**
     * A main() so we can easily run these routing rules in our IDE
     */
    public static void main(String... args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/camel-context.xml");

    }

}

