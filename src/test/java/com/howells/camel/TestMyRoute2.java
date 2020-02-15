package com.howells.camel;

import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringDelegatingTestContextLoader;
import org.apache.camel.test.spring.CamelSpringRunner;
import org.apache.camel.test.spring.MockEndpointsAndSkip;
import org.apache.camel.test.spring.UseAdviceWith;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by chrish on 15/10/2017.
 */
@RunWith(CamelSpringRunner.class)
@ContextConfiguration(loader = CamelSpringDelegatingTestContextLoader.class, classes = Config.class)
@MockEndpointsAndSkip("file:target/messages/others")
@UseAdviceWith
public class TestMyRoute2 {

    @Produce(uri = "file:src/data?noop=true")
    private ProducerTemplate producerTemplate;
    @EndpointInject(uri = "mock:file:target/messages/others")
    private MockEndpoint endpoint;

    @DirtiesContext
    @Test
    @Ignore
    public void test() throws Exception {
        endpoint.expectedMessageCount(1);
        producerTemplate.sendBody("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<person user=\"hiram\">\n" +
                "  <firstName>Hiram</firstName>\n" +
                "  <lastName>Chirino</lastName>\n" +
                "  <city>Tampa</city>\n" +
                "</person>");
        endpoint.assertIsSatisfied();
    }
}
