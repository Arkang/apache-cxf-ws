package com.optumrx.soap.demo.service.interceptors;

import org.apache.cxf.ext.logging.LoggingOutInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.OutInterceptors;
import org.apache.cxf.message.Message;

import java.util.logging.Logger;

@OutInterceptors
public class AppOutboundInterceptor extends LoggingOutInterceptor {

    private static final Logger LOG = Logger.getLogger(AppOutboundInterceptor.class.getName());

    @Override
    public void handleMessage(Message message) throws Fault {
        processPayLoad(message);
        super.handleMessage(message);
    }

    private void processPayLoad(Message message) {
        LOG.warning("PROCESSING PAYLOAD AT OUT-INTERCEPTOR with " + message.getExchange().getBinding());
    }
}
