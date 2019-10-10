package com.game.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DrLuckyClient {

    //Configuration
    static final String HOST = "127.0.0.1";
    static final int PORT = 9000;

    public static String currentMessage = null;

    static JTextArea chatRoom;

    public static void start(JTextArea chatRoom) throws Exception {
        DrLuckyClient.chatRoom = chatRoom;
        final SslContext sslCtx = SslContextBuilder.forClient()
                .trustManager(InsecureTrustManagerFactory.INSTANCE).build();

        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new DrLuckyClientInitializer(sslCtx));

            // Start the connection attempt.
            Channel ch = b.connect(HOST, PORT).sync().channel();

            // Read commands from the stdin.
            ChannelFuture lastWriteFuture = null;
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            for (;;) {
                System.out.println(DrLuckyClient.currentMessage);
                if(DrLuckyClient.currentMessage != null && DrLuckyClient.currentMessage.equalsIgnoreCase("bye")){
                    break;
                }
                if (DrLuckyClient.currentMessage != null) { //If a message is sent
                    System.out.println(DrLuckyClient.currentMessage);
                    lastWriteFuture = ch.writeAndFlush(DrLuckyClient.currentMessage + "\r\n");
                    DrLuckyClient.currentMessage = null;
                }
            }

            // Wait until all messages are flushed before closing the channel.
            if (lastWriteFuture != null) {
                lastWriteFuture.sync();
            }
        } finally {
            // The connection is closed automatically on shutdown.
            group.shutdownGracefully();
        }
    }
}

