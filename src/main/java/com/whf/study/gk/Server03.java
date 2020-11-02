package com.whf.study.gk;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class Server03 {
    public void startServer() throws Exception {

        ExecutorService executorService = Executors.newFixedThreadPool(40);
        ServerSocket socket = new ServerSocket(8808);
        while(true) {
            Socket accept = socket.accept();
            executorService.submit(() -> {
                try {
                    service(accept);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        }
    }

    public void service(Socket s) throws IOException {
        try(OutputStream outputStream = s.getOutputStream()) {
            Thread.sleep(20);
            String str = "HELLO NIO\n";
            PrintWriter print = new PrintWriter(outputStream, true);
            outputStream.write("HTTP/1.1 200 OK\n".getBytes());
            outputStream.write("Content-Type: text/html;charset=utf-8\n".getBytes());
            outputStream.write(String.format("Content-Length: %d\n", str.length()).getBytes());
            outputStream.write("\n".getBytes());
            outputStream.write(str.getBytes());
            outputStream.flush();
            outputStream.close();
            s.close();
        }catch ( IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server03 s = new Server03();
        try {
            s.startServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
