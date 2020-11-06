package me.redbean.stub;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 프로세스 흐름
 * setDoInput(false) >> getInputStream >> ProtocolException
 * @return
 * @throws Exception
 */
public class StubHttpURLConnection extends HttpURLConnection {

    private boolean isInput = true;

    public StubHttpURLConnection(URL u) {
        super(u);
    }

    public InputStream getInputStream() throws IOException{
        if(!isInput){
            throw new ProtocolException("URL Connection을 읽을수 없습니다.");
        }
        ByteArrayInputStream stream = new ByteArrayInputStream(new String("It works").getBytes());
        return stream;
    }

    public void disconnect(){}
    public void connect() throws IOException {
    }
    public boolean usingProxy(){
        return false;
    }

}
