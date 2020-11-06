package me.redbean.stub;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mortbay.jetty.Handler;
import org.mortbay.jetty.HttpHeaders;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.AbstractHandler;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.util.ByteArrayISO8859Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class WebClientTest1 {

    @BeforeClass
    public static void setUp() throws Exception{
        WebClientTest1 t = new WebClientTest1();
        URL.setURLStreamHandlerFactory(t.new SubStreamHandlerFactory());
    }

    private class SubStreamHandlerFactory implements URLStreamHandlerFactory {
        @Override
        public URLStreamHandler createURLStreamHandler(String protocol) {
            return new StubHttpURLStreamHandler();
        }
    }
    @Test
    public void testGetContentOK() throws Exception{
        WebClient webClient = new WebClient();
        String result = webClient.getContent(new URL("http://localhost"));
        assertEquals("It works",result);
    }
}