package org.arkang.soap.demo.service;

import org.arkang.soap.demo.mapper.WelcomeMessageMapper;
import org.arkang.soap.demo.model.Greeting;
import org.arkang.soap.demo.model.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.logging.Logger;

@Service
public class InfoServiceImpl implements InfoService {

    private static final Logger LOG = Logger.getLogger(InfoServiceImpl.class.getName());

    @Autowired
    private WelcomeMessageMapper welcomeMessageMapper;

    @Override
    public Greeting sayHowAreYou(String name) {
        LOG.info("Executing operation sayHowAreYou with" + name);
        Greeting greeting = new Greeting();
        greeting.setMessage("How are you " + name + "!!!");
        greeting.setDate(new Date());
        LOG.info("Returning operation sayHowAreYou response");
        String id = "001";
        MessageResponse response = welcomeMessageMapper.getWelcomeMessage(id);
        if (response != null) {
            welcomeMessageMapper.updateMessageCount(response.getCount() + 1, id);
            MessageResponse updatedResponse = welcomeMessageMapper.getWelcomeMessage(id);
            LOG.info("After count update: " + updatedResponse);
        }
        LOG.info("Welcome Message: " + response);
        return greeting;
    }
}
