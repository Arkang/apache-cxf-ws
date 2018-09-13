package org.arkang.soap.demo.service;

import org.arkang.soap.demo.model.Greeting;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(serviceName = "InfoService")
public interface InfoService {
    @WebMethod()
    @WebResult(name = "Greeting")
    public Greeting sayHowAreYou(@WebParam(name = "GreetingsRequest") String name);
}
