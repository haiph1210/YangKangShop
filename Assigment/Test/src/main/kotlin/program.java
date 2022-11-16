

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class program {
    public static void main(String[] args) {

        for (int i = 0; i < args.length; i++) {
            try {
                 Socket socket = new Socket(args[i],80);
                 System.out.print("Connected to " + socket.getInetAddress());
                 System.out.print(" on port " + socket.getPort());
                 System.out.print(" from port " + socket.getLocalPort());
                 System.out.println(" of " + socket.getLocalAddress());
                 } catch (UnknownHostException e) {
                 e.printStackTrace();
            } catch (SocketException e) {e.printStackTrace();
            } catch (IOException e) {e.printStackTrace();
            }
            }

    }
}
