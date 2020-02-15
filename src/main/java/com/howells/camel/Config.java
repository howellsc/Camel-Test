package com.howells.camel;

import org.apache.camel.spring.javaconfig.CamelConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by chrish on 15/10/2017.
 */
@Configuration
@ComponentScan("com.howells")
public class Config extends CamelConfiguration {

}
