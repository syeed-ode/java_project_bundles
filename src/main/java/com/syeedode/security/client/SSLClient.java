package com.syeedode.security.client;

import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.Socket;

import static com.syeedode.security.common.ArgumentValidator.OUTPUT_STRING;
import static com.syeedode.security.common.ArgumentValidator.fromStringArray;

/**
 * O'Reilly Java Security Second Edition
 * SSL Client and Server Sockets - Chapter 14: SSL and HTTPS
 * <p>
 * Author: syeedode
 * Date: 9/6/17
 */
public class SSLClient {
// javax.net.ssl.trustStorePassword
    public static void executeSSLClient(String [] args) {
        SocketFactory socketFactory = SSLSocketFactory.getDefault();
        String hostname = fromStringArray(args,0, "localhost");
        String port = fromStringArray(args,1, "9096");
        try {
            Socket socket = socketFactory.createSocket(hostname, Integer.parseInt(port));
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);

            System.out.println(OUTPUT_STRING);
            printWriter.println(OUTPUT_STRING);
            printWriter.flush();
            System.out.println(bufferedReader.readLine());
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
