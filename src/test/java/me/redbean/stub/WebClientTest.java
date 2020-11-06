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

import static org.junit.Assert.*;

public class WebClientTest {

    @BeforeClass
    public static void setUp() throws Exception{
        Server server = new Server(8080);

        WebClientTest t = new WebClientTest();

        Context context = new Context(server, "/testGetConentOK");
        context.setHandler(t.new TestGetContentOKHandler());

        Context conTentNotFoundContect = new Context(server,"testGetContentNotFound");
        conTentNotFoundContect.setHandler(t.new testGetContentNotFoundHndler());
        server.setStopAtShutdown(true);
        server.start();
    }

    @Test
    public void testGetContentOK() throws Exception{
        WebClient webClient = new WebClient();
        String result = webClient.getContent(new URL("http://localhost:8080/testGetConentOK"));
        assertEquals("It work" , result);
    }

    @Test
    public void testGetContentNotFound() throws Exception{
        WebClient webClient = new WebClient();
        String result = webClient.getContent(new URL("http://localhost:8080/testGetContentNotFound"));
        assertNull(result);
    }

    @AfterClass
    public static void tearDown(){

    }

    private class TestGetContentOKHandler extends AbstractHandler{

        @Override
        public void handle(String s, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, int i) throws IOException, ServletException {
            OutputStream out = httpServletResponse.getOutputStream();
            ByteArrayISO8859Writer writer = new ByteArrayISO8859Writer();
            writer.write("It work");
            writer.flush();
            httpServletResponse.setIntHeader(HttpHeaders.CONTENT_LENGTH, writer.size());
            writer.writeTo(out);
            out.flush();
            out.close();
        }
    }

    private class testGetContentNotFoundHndler implements Handler {
        @Override
        public void handle(String s, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, int i) throws IOException, ServletException {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);    // 404 Not Found
        }

        @Override
        public void setServer(Server server) {

        }

        @Override
        public Server getServer() {
            return null;
        }

        @Override
        public void destroy() {

        }

        @Override
        public void start() throws Exception {

        }

        @Override
        public void stop() throws Exception {

        }

        @Override
        public boolean isRunning() {
            return false;
        }

        @Override
        public boolean isStarted() {
            return false;
        }

        @Override
        public boolean isStarting() {
            return false;
        }

        @Override
        public boolean isStopping() {
            return false;
        }

        @Override
        public boolean isStopped() {
            return false;
        }

        @Override
        public boolean isFailed() {
            return false;
        }

        @Override
        public void addLifeCycleListener(Listener listener) {

        }

        @Override
        public void removeLifeCycleListener(Listener listener) {

        }
    }
}