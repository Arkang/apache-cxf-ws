package org.arkang.soap.demo.service;

import org.arkang.soap.demo.model.Greeting;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(serviceName = "GreetingService")
public interface GreetingService {

    @WebMethod()
    @WebResult(name = "Greeting")
    public Greeting sayHello(@WebParam(name = "GreetingsRequest") String name);

    @WebMethod()
    @WebResult(name = "Greeting")
    public Greeting sayBye(@WebParam(name = "GreetingsRequest") String name);
}
