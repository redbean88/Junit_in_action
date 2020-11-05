package me.redbean.stub;

import org.mortbay.jetty.HttpHeaders;
import org.mortbay.jetty.handler.AbstractHandler;
import org.mortbay.util.ByteArrayISO8859Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class TestGetContentOKHandler extends AbstractHandler{
    @Override
    public void handle(String target, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, int dispatch) throws IOException, ServletException {

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
