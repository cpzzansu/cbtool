package com.ksmart47.cbtool.config;

import com.ksmart47.cbtool.handler.MyWebSocketHandler;
import com.ksmart47.cbtool.service.CollaborationToolService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
@AllArgsConstructor
public class WebSocketConfig implements WebSocketConfigurer {

    private final CollaborationToolService collaborationToolService;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new MyWebSocketHandler(collaborationToolService), "/my-websocket-endpoint")
                .setAllowedOrigins("*");
    }
}
