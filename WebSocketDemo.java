package com.accenture.utility;

import java.io.IOException;

import javax.websocket.server.ServerEndpoint;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.OnClose;
import javax.websocket.Session;
@ServerEndpoint("/WebSocket")
public class WebSocketDemo {
	@OnMessage
	public void OnMessage(String message, Session session) throws IOException, InterruptedException
	{
		
		System.out.println("Message Received"+message);
		session.getBasicRemote().sendText("First Message from Server");
	    int count=0;
	    while(count<5)
	    {
	    	session.getBasicRemote().sendText("Message from Server"+count);
	        Thread.sleep(1000);
	    	count++;
	    }
	    session.getBasicRemote().sendText("Final Message from Server");
	
	}
	@OnOpen
	public void OnOpen()
	{
		System.out.println("Connection Esatblished"); 
		
	}
	@OnClose
	public void OnClose()
	{
		System.out.println("Connection Closed"); 
	}
	

}
