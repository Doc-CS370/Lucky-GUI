package com.game.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class DrLuckyClientHandler extends SimpleChannelInboundHandler<String> {
    @Override
    public void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        //Just reading responses from the server.
        DrLuckyClient.chatRoom.append(msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
