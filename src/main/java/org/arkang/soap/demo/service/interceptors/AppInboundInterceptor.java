package org.arkang.soap.demo.service.interceptors;

import org.apache.cxf.ext.logging.LoggingInInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.InInterceptors;
import org.apache.cxf.message.Message;

import java.util.logging.Logger;

@InInterceptors
public class AppInboundInterceptor extends LoggingInInterceptor {

    private static final Logger LOG = Logger.getLogger(AppInboundInterceptor.class.getName());

    @Override
    public void handleMessage(Message message) throws Fault {
        processPayLoad(message);
        super.handleMessage(message);
    }

    private void processPayLoad(Message message) {
        LOG.warning("PROCESSING PAYLOAD AT IN-INTERCEPTOR with " + message.getDestination().getAddress());
    }
}
