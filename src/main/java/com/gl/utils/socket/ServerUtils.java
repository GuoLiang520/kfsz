package com.gl.utils.socket;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 *
 * @author 郭亮
 * @date 2021/1/21 9:09
 **/
public class ServerUtils {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(30000));
        serverSocketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            selector.select();
            System.out.println("获取select");
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey next = iterator.next();
                iterator.remove();
                if (!next.isValid()) {
                    System.out.println("continue");
                    continue;
                }
                if (next.isAcceptable()) {
                    ServerSocketChannel channel = (ServerSocketChannel) next.channel();
                    System.out.println("isAcceptable");
                    SocketChannel sc = channel.accept();
                    sc.configureBlocking(false);
                    sc.register(selector, SelectionKey.OP_READ);
                } else if (next.isReadable()) {
                        try {
                            SocketChannel channel = (SocketChannel) next.channel();
                            channel.configureBlocking(false);
                            ByteBuffer buffer = ByteBuffer.allocate(1024);
                            StringBuffer sb = new StringBuffer();
                            while (true) {
                                buffer.clear();
                                byte[] b = new byte[1024];
                                int read = channel.read(buffer);
                                if (read <= 0) {
                                    break;
                                }
                                buffer.flip();
                                buffer.get(b,0, buffer.limit());
                                String s = new String(b);
                                sb.append(s + "\n");
                            }
                            String ss = sb.toString();
                            System.out.println(ss.trim() + "!23");
                            buffer.flip();
                            //channel.write(buffer);
                            //channel.close();
                            if ("end".equals(ss.trim())) {
                                channel.close();
                                //return;
                            }
                        } catch (Exception e) {

                        }

                    //channel.register(selector, SelectionKey.OP_ACCEPT);
                    //next.cancel();
                } else {
                    next.cancel();
                }
            }
        }
    }
}
