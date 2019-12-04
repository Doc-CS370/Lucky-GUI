package com.game.client;

import com.game.player;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class DrLuckyClientHandler extends SimpleChannelInboundHandler<String> {



    @Override
    public void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        //Just reading responses from the server.
        if(msg.toLowerCase().contains("chat")){
            String messageToPut = msg.replace("chat", "");
            System.out.println(messageToPut);
            System.out.println(msg);
            DrLuckyClient.chatRoom.append(msg.replace("chat ", ""));
            DrLuckyClient.chatRoom.append("\n");
            DrLuckyClient.chatRoom.setCaretPosition(DrLuckyClient.chatRoom.getDocument().getLength());
        }
        if(msg.toLowerCase().startsWith("lucky")){
            String[] luckyString = msg.split(" ");

            DrLuckyClient.gv.Player[0] = new player();

        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
