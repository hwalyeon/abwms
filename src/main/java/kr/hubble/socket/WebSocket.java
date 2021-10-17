package kr.hubble.socket;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// Set WebSocket Host Address 
@ServerEndpoint("/websocket")
public class WebSocket
{
	/**
	 * WebSocket으로 브라우저가 접속하면 요청되는 함수
	 * */
	@OnOpen
	public void handleOpen()
	{
		log.debug("client was connected!");
	}
	
	/** 
	 * WebSocket으로 메시지가 오면 요청되는 함수
	 */
	@OnMessage
	public String handleMessage(String message)
	{
		log.debug("received Message! " + message);
		
		String reply = "echo " + message;
		
		return reply;
	}
	
	@OnClose
	public void handleClose()
	{
		log.debug("client was disconnected! bye~");
	}
	
	@OnError
	public void handleError(Throwable t)
	{
		log.debug("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEError");
		t.printStackTrace();
	}
}
