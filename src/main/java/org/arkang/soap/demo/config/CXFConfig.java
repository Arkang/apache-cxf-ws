package org.arkang.soap.demo.config;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.ext.logging.LoggingFeature;
import org.apache.cxf.jaxws.EndpointImpl;
import org.arkang.soap.demo.service.GreetingService;
import org.arkang.soap.demo.service.InfoService;
import org.arkang.soap.demo.service.interceptors.AppInboundInterceptor;
import org.arkang.soap.demo.service.interceptors.AppOutboundInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class CXFConfig {

    @Autowired
    private InfoService infoService;
    @Autowired
    private GreetingService greetingService;

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        SpringBus springBus = new SpringBus();
        springBus.getInInterceptors().add(new AppInboundInterceptor());
        springBus.getOutInterceptors().add(new AppOutboundInterceptor());
        return springBus;
    }

    @Bean("InfoService")
    public Endpoint infoServiceEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), infoService);
        endpoint.getFeatures().add(new LoggingFeature());
        endpoint.publish("/InfoService");
        return endpoint;
    }

    @Bean("GreetingService")
    public Endpoint greetingServiceEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), greetingService);
        endpoint.getFeatures().add(new LoggingFeature());
        endpoint.publish("/GreetingService");
        return endpoint;
    }
}
