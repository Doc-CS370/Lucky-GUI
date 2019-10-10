package com.game.client;

import javax.swing.*;

public class ChatRunnable implements Runnable {

    private JTextArea chatRoom;

    public ChatRunnable(JTextArea chatRoom){
        this.chatRoom = chatRoom;
    }

    @Override
    public void run() {
        try {
            DrLuckyClient.start(chatRoom);
        } catch (Exception e) {
            chatRoom.append("Chat failed to connect!");
        }
    }
}
