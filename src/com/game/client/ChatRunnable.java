package com.game.client;

import com.game.GlobalValues;

import javax.swing.*;

public class ChatRunnable implements Runnable {

    private JTextArea chatRoom;
    private GlobalValues gv;

    public ChatRunnable(JTextArea chatRoom, GlobalValues gv){
        this.chatRoom = chatRoom;
        this.gv = gv;
    }

    @Override
    public void run() {
        try {
            DrLuckyClient.start(chatRoom, gv);
        } catch (Exception e) {
            chatRoom.append("Chat failed to connect!");
        }
    }
}
