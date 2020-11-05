package me.redbean.stub;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

//HTTP 커넥션 확인 샘플 메서드
public class WebClient {
    public String getContent(URL url){
        StringBuffer content = new StringBuffer();
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();    // 1. 커넥션 생성
            connection.setDoInput(true);
            InputStream is = connection.getInputStream();                               // 2. contents read
            byte[] buffer = new byte[2048];
            int count;
            while (-1 != (count = is.read(buffer))){
                content.append(new String(buffer , 0 , count));
            }
        } catch (IOException e) {
            return null;                                                                // 3. 오류 발생시 null 반환
        }
        return content.toString();
    }
}
