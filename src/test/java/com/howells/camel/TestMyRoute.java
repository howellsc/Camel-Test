package com.howells.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.AdviceWithRouteBuilder;
import org.apache.camel.builder.NotifyBuilder;
import org.apache.camel.model.RouteDefinition;
import org.apache.camel.test.spring.CamelSpringRunner;
import org.apache.camel.test.spring.MockEndpointsAndSkip;
import org.apache.camel.test.spring.UseAdviceWith;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.concurrent.TimeUnit;

/**
 * Created by chrish on 14/10/2017.
 */
@RunWith(CamelSpringRunner.class)
@ContextConfiguration({"/camel-context.xml"})
@UseAdviceWith
public class TestMyRoute {
    @Autowired
    private CamelContext camelContext;

    @Test
    public void test()
    {
        NotifyBuilder notify = new NotifyBuilder(camelContext).fromRoute("Chris-Test").whenDone(2).create();
        boolean matches = notify.matches(5, TimeUnit.SECONDS);
        Assert.assertTrue(matches);
    }

//    @Test
//    public void test2() throws Exception
//    {
//        RouteDefinition definition = camelContext.getRouteDefinition("Chris-Test");
//        definition.adviceWith(camelContext, new AdviceWithRouteBuilder() {
//            @Override
//            public void configure() throws Exception {
//                mockEndpointsAndSkip("file:target/messages/others");
//            }
//        });
//
//    }

    public void test3()
    {

    }
}
