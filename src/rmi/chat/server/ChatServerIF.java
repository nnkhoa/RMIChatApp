package rmi.chat.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import rmi.chat.client.ChatClientIF;

public interface ChatServerIF extends Remote{
	//register chat Clients
	void registerChatClient(ChatClientIF chatClient) throws RemoteException;
	
	//broadcast messages
	void broadCastMessage(String message) throws RemoteException;
}
