package org.lili.forfun.tiger.api.provider;

import lombok.extern.log4j.Log4j2;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.*;
import java.io.IOException;

@Log4j2
@Provider
public class TigerReadProvider implements ReaderInterceptor, WriterInterceptor {
    @Override
    public Object aroundReadFrom(ReaderInterceptorContext context) throws IOException, WebApplicationException {
        try {
            return context.proceed();
        } catch (IOException | WebApplicationException e) {
            log.error("", e);
            throw e;
        }
    }

    @Override
    public void aroundWriteTo(WriterInterceptorContext context) throws IOException, WebApplicationException {
        try {
            context.proceed();
        } catch (IOException | WebApplicationException e) {
            log.error("", e);
            throw e;
        }
    }
}