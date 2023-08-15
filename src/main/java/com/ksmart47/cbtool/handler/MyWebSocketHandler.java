package com.ksmart47.cbtool.handler;


import com.ksmart47.cbtool.dto.Brainstorming;
import com.ksmart47.cbtool.service.CollaborationToolService;
import lombok.AllArgsConstructor;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@AllArgsConstructor
public class MyWebSocketHandler extends TextWebSocketHandler {

    private final CollaborationToolService collaborationToolService;
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // 클라이언트로부터 메시지 받기
        String clientMessage = message.getPayload();


        collaborationToolService.changeHtml(clientMessage);

        // 클라이언트에게 메시지 보내기
        session.sendMessage(new TextMessage("Hello, Client!"));
    }
}
