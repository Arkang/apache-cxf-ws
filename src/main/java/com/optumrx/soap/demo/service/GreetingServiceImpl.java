package com.optumrx.soap.demo.service;

import com.optumrx.soap.demo.model.Greeting;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.logging.Logger;

@Service
public class GreetingServiceImpl implements GreetingService {

    private static final Logger LOG = Logger.getLogger(GreetingServiceImpl.class.getName());

    @Override
    public Greeting sayHello(String name) {
        LOG.info("Executing operation sayHello with " + name);
        Greeting greeting = new Greeting();
        greeting.setMessage("Hello " + name + "!!!");
        greeting.setDate(new Date());
        LOG.info("Returning operation sayHello response");
        return greeting;
    }

    @Override
    public Greeting sayBye(String name) {
        LOG.info("Executing operation sayBye with " + name);
        Greeting greeting = new Greeting();
        greeting.setMessage("Bye " + name + "!!!");
        greeting.setDate(new Date());
        LOG.info("Returning operation sayBye response");
        return greeting;
    }
}
