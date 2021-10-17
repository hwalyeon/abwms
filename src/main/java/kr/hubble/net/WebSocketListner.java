package kr.hubble.net;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@ServerEndpoint(value = "/ws")
public class WebSocketListner {
	private Session wsSession;
	public static Set<WebSocketListner> listeners = new CopyOnWriteArraySet<>();
	private static int onlineCount = 0;

    @OnOpen //클라이언트가 소켓에 연결되때 마다 호출
    public void onOpen(Session session) {
        onlineCount++;
        this.wsSession = session;
        listeners.add(this);
        log.info("onOpen called, userCount:" + onlineCount);
    }

    @OnClose //클라이언트와 소켓과의 연결이 닫힐때 (끊길떄) 마다 호
    public void onClose(Session session) {
        onlineCount--;
        listeners.remove(this);
        log.info("onClose called, userCount:" + onlineCount);
    }

    @OnMessage
    public void onMessage(String message) {
        log.info("onMessage called, message:" + message);
        broadcast(message);
    }

    @OnError //의도치 않은 에러 발생
    public void onError(Session session, Throwable throwable) {
        log.warn("onClose called, error:" + throwable.getMessage());
        listeners.remove(this);
        onlineCount--;
    }

    public static void broadcast(String message) {
        for (WebSocketListner listener : listeners) {
            listener.sendMessage(message);
        }
    }

    private void sendMessage(String message) {
        try {
            this.wsSession.getBasicRemote().sendText(message);
        } catch (IOException e) {
            log.warn("Caught exception while sending message to Session " + this.wsSession.getId() + "error:" + e.getMessage());
        }
    }
}
