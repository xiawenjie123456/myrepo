package com.gallery.websoket.handler;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.concurrent.CopyOnWriteArrayList;

public class WebSocketHandler extends TextWebSocketHandler {

    // 用于存储所有连接的 WebSocketSession
    private static final CopyOnWriteArrayList<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // 连接建立后，保存 session
        sessions.add(session);
        System.out.println("New WebSocket connection established: " + session.getId());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // 接收到消息后，可以进行处理
        System.out.println("Received message: " + message.getPayload());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        // 连接关闭后，移除 session
        sessions.remove(session);
        System.out.println("WebSocket connection closed: " + session.getId());
    }

    // 向所有连接的客户端发送消息
    public static void sendToAll(String message) {
        for (WebSocketSession session : sessions) {
            try {
                if (session.isOpen()) {
                    session.sendMessage(new TextMessage(message));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 向指定 session 发送消息
    public static void sendToSession(String sessionId, String message) {
        for (WebSocketSession session : sessions) {
            if (session.getId().equals(sessionId)) {
                try {
                    session.sendMessage(new TextMessage(message));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}