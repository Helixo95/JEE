package com.example.demo;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint("/chat")
public class ChatEndpoint {

    private static Set<Session> sessions = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);
        System.out.println("Nouvelle connexion : " + session.getId());
    }

    @OnMessage
    public void onMessage(String message, Session sender) throws IOException {
        for (Session session : sessions) {
            if (session.isOpen() && !session.equals(sender)) {
                session.getBasicRemote().sendText(message);
            }
        }
    }

    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);
        System.out.println("Connexion fermée : " + session.getId());
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.err.println("Erreur sur la session " + session.getId() + " : " + throwable.getMessage());
    }
}
