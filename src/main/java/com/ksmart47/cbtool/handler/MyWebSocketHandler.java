package com.ksmart47.cbtool.handler;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MyWebSocketHandler extends TextWebSocketHandler {
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // 클라이언트로부터 메시지 받기
        String clientMessage = message.getPayload();
        System.out.println("Received message: " + clientMessage);

        // 클라이언트에게 메시지 보내기
        session.sendMessage(new TextMessage("Hello, Client!"));
    }
}
