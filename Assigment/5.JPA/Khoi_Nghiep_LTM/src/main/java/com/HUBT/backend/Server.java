package com.HUBT.backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(8080);
        Socket client = server.accept();

        BufferedReader br = new BufferedReader(new
                InputStreamReader(client.getInputStream()));
        PrintWriter pw = new PrintWriter(client.getOutputStream());

        String st = br.readLine();

        String kq = CutSpace(st);

        pw.write(kq);
        pw.write("\n");
        pw.flush();

        pw.close();
        br.close();
        client.close();
        server.close();
    }

    public static String CutSpace(String st) {
        String str = "";
        String space = " ";
        st = st.trim();
//        st = st.replace(" ", " ");
        String arr[] = st.split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].substring(0, 1).toUpperCase().concat(arr[i].substring(1));
            str += arr[i] + space;
        }
        return str;
    }

}