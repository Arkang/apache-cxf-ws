package com.optumrx.soap.demo.config;

import com.optumrx.soap.demo.service.GreetingServiceImpl;
import com.optumrx.soap.demo.service.InfoServiceImpl;
import com.optumrx.soap.demo.service.interceptors.AppInboundInterceptor;
import com.optumrx.soap.demo.service.interceptors.AppOutboundInterceptor;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.ext.logging.LoggingFeature;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class CXFConfig {

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        SpringBus springBus = new SpringBus();
        springBus.getInInterceptors().add(new AppInboundInterceptor());
        springBus.getOutInterceptors().add(new AppOutboundInterceptor());
        return springBus;
    }

    @Bean("InfoService")
    public Endpoint infoServiceEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), new InfoServiceImpl());
        endpoint.getFeatures().add(new LoggingFeature());
        endpoint.publish("/InfoService");
        return endpoint;
    }

    @Bean("GreetingService")
    public Endpoint greetingServiceEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), new GreetingServiceImpl());
        endpoint.getFeatures().add(new LoggingFeature());
        endpoint.publish("/GreetingService");
        return endpoint;
    }
}
