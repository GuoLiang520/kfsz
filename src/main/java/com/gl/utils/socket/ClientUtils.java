package com.gl.utils.socket;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 *
 * @author 郭亮
 * @date 2021/1/21 9:09
 **/
public class ClientUtils {
    public static void main(String[] args) throws Exception {
        /*for (int i=0;i<1;i++) {
            Socket socket = new Socket("127.0.0.1", 30000);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(("HELLO WORLD " + i).getBytes());
            outputStream.flush();
            outputStream.close();
            Socket socket1 = new Socket("127.0.0.1", 30000);
            InputStream inputStream = socket1.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            System.out.println(bufferedReader.readLine());
            inputStream.close();
            //socket.close();
        }*/
        try (SocketChannel socketChannel = SocketChannel.open()) {
            //连接服务端socket
            SocketAddress socketAddress = new InetSocketAddress("localhost", 30000);
            socketChannel.connect(socketAddress);

            int sendCount = 0;

            ByteBuffer buffer = ByteBuffer.allocate(1024);

            //这里最好使用selector处理   这里只是为了写的简单
            while (sendCount < 1) {
                //向服务端发送消息
                FileReader fileReader = new FileReader("E:\\Zha\\fh.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                while (true) {
                    line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    buffer.put(line.getBytes());
                    buffer.flip();
                    socketChannel.write(buffer);
                    buffer.clear();
                }
                /*//从服务端读取消息
                int readLenth = socketChannel.read(buffer);
                //读取模式
                buffer.flip();
                byte[] bytes = new byte[readLenth];
                buffer.get(bytes);
                System.out.println(new String(bytes, "UTF-8"));
                buffer.clear();*/


                sendCount++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            buffer.clear();
            //向服务端发送消息
            buffer.put("end".getBytes());
            //读取模式
            buffer.flip();
            socketChannel.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
