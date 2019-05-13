package websocket;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint(value = "/api/ServerEndPoint", encoders = {JsonEncoder.class}, decoders = {JsonDecoder.class})
public class ServerEndPoint {
    //ws://localhost:8080/kwetter/ServerEndPoint
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("client is now connected...");
    }

    @OnMessage
    public void onMessage(Session session, String message) {
        System.out.println("message from client: " + message);
        String reply = "echo " + message;
        try {
            for (Session sess : session.getOpenSessions()) {
                if (sess.isOpen())
                    sess.getBasicRemote().sendText(reply);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("reply to client: " + reply);
    }

    @OnClose
    public void onClose() {
        System.out.println("client is now disconnected...");
    }

    @OnError
    public void onError(Throwable t) {
        t.printStackTrace();
    }
}

//    {
//            "dateTime":"2019-05-06T11:42:47.585Z[UTC]",
//            "postID":3,
//            "reaction":false,
//            "text":"jgdslfd",
//            "user":{
//            "admin":true,
//            "biography":"dit is iets",
//            "location":"uden",
//            "name":"henk",
//            "password":"password",
//            "userID":1,
//            "website":"www.henk.nl"
//            }
//            }
