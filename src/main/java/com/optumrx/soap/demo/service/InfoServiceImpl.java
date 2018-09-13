package com.optumrx.soap.demo.service;

import com.optumrx.soap.demo.model.Greeting;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.logging.Logger;

@Service
public class InfoServiceImpl implements InfoService {

    private static final Logger LOG = Logger.getLogger(InfoServiceImpl.class.getName());

    @Override
    public Greeting sayHowAreYou(String name) {
        LOG.info("Executing operation sayHowAreYou with" + name);
        Greeting greeting = new Greeting();
        greeting.setMessage("How are you " + name + "!!!");
        greeting.setDate(new Date());
        LOG.info("Returning operation sayHowAreYou response");
        return greeting;
    }
}
