package org.arkang.soap.demo.service;

import org.arkang.soap.demo.mapper.WelcomeMessageMapper;
import org.arkang.soap.demo.model.Greeting;
import org.arkang.soap.demo.model.MessageResponse;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.logging.Logger;

@Service
public class InfoServiceImpl implements InfoService {

    private static final Logger LOG = Logger.getLogger(InfoServiceImpl.class.getName());

    private WelcomeMessageMapper welcomeMessageMapper;

    public InfoServiceImpl(WelcomeMessageMapper mapper) {
        welcomeMessageMapper = mapper;
    }

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
            welcomeMessageMapper.updateMessageCount(10, id);
            welcomeMessageMapper.flush();
            MessageResponse updatedResponse = welcomeMessageMapper.getWelcomeMessage(id);
            LOG.info("After count update: " + updatedResponse);
        }
        LOG.info("Welcome Message: " + response);
        return greeting;
    }
}
