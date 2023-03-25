package javaLang.untrusteddatasourceexample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class UntrustedDataSource {

    public void method() throws Throwable{
        Socket socket = null;
        BufferedReader readerBuffered = null;
        InputStreamReader readerInputStream = null;
        
        socket = new Socket("something", 777);
        readerInputStream = new InputStreamReader(socket.getInputStream(), "UTF-8");
        readerBuffered = new BufferedReader(readerInputStream);

        String data = readerBuffered.readLine();

        executeQuery(data);

        readerBuffered.close();
        readerInputStream.close();
        socket.close();
    }

    public void executeQuery(String query){}
}
