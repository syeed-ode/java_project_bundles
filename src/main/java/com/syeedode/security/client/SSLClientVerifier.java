package com.syeedode.security.client;

import com.syeedode.security.dname.X500Name;

import javax.net.SocketFactory;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.security.cert.X509Certificate;
import java.io.*;

import static com.syeedode.security.common.ArgumentValidator.OUTPUT_STRING;
import static com.syeedode.security.common.ArgumentValidator.fromStringArray;

/**
 * O'Reilly Java Security Second Edition
 * SSL Sessions - Chapter 14: SSL and HTTPS
 * <p>
 * Author: syeedode
 * Date: 9/6/17
 */
public class SSLClientVerifier {

    public static void executeSSLClientVerifier(String [] args) {
        SocketFactory socketFactory = SSLSocketFactory.getDefault();
        String hostname = fromStringArray(args,0, "localhost");
        String port = fromStringArray(args,1, "9096");
        SSLSocket sslSocket = null;
        String serverHost = "";
        try {
            sslSocket = (SSLSocket) socketFactory.createSocket(hostname, Integer.parseInt(port));
            SSLSession sslSession = sslSocket.getSession();
            serverHost = sslSession.getPeerHost();
            X509Certificate[] certificates = sslSession.getPeerCertificateChain();
            String distinguishedName = certificates[0].getSubjectDN().getName();
            X500Name x500Name = new X500Name.Builder(distinguishedName).build();
            if(!serverHost.equalsIgnoreCase(x500Name.getCN())) {
                System.err.println("Warning: Expected: " + serverHost
                        + ". But got: " + x500Name.getCN());
            }
            InputStream inputStream = sslSocket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            OutputStream outputStream = sslSocket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);

            System.out.println(OUTPUT_STRING);
            printWriter.println(OUTPUT_STRING);
            printWriter.flush();

            System.out.println(bufferedReader.readLine());
            sslSocket.close();
        } catch (SSLPeerUnverifiedException e){
            e.printStackTrace();  // thrown by sslSession.getPeerCertificateChain();
        } catch (IOException  e) {
            e.printStackTrace();
        }

    }
}
