package com.HUBT.fontend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket server = new Socket("127.0.0.1", 8080);

        BufferedReader in = new BufferedReader(new
                InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new
                InputStreamReader(server.getInputStream()));
        PrintWriter pw = new PrintWriter(server.getOutputStream());

        String st;
        System.out.println("Nhóm 2- PM24.07");
        System.out.println(" Input Text : ");
        st = in.readLine();

        pw.write(st);
        pw.write("\n");
        pw.flush();

        st = br.readLine();

        System.out.println(" Result : " + st);

        pw.close();
        br.close();
        server.close();

    }

}
