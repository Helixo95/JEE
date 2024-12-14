package com.example.websocket;

import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

import java.io.StringReader;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint("/text")
public class Text {

    private static final Set<Session> clients = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session) {
        clients.add(session);
        System.out.println("Connexion ouverte, client : " + session.getId());
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("Message reçu : " + message);

        // Lire le message JSON
        try (JsonReader reader = Json.createReader(new StringReader(message))) {
            JsonObject jsonMessage = reader.readObject();
            String username = jsonMessage.getString("username");
            String userMessage = jsonMessage.getString("message");

            // Créer un nouveau message JSON pour la diffusion
            JsonObject broadcastMessage = Json.createObjectBuilder()
                    .add("username", username)
                    .add("message", userMessage)
                    .build();

            // Diffuser le message à tous les clients connectés
            for (Session client : clients) {
                if (client.isOpen()) {
                    client.getAsyncRemote().sendText(broadcastMessage.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose(Session session) {
        clients.remove(session);
        System.out.println("Session fermée : " + session.getId());
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.err.println("Erreur pour le client " + session.getId() + " : " + throwable.getMessage());
    }
}
