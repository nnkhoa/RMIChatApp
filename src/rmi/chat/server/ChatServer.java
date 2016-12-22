package rmi.chat.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import rmi.chat.client.ChatClientIF;

public class ChatServer extends UnicastRemoteObject implements ChatServerIF{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<ChatClientIF> chatClients;

	protected ChatServer() throws RemoteException {
		//instantiate the chatClients List
		chatClients = new ArrayList<ChatClientIF>();
	}

	@Override
	public synchronized void registerChatClient(ChatClientIF chatClient) throws RemoteException {
		//add chat client to list
		this.chatClients.add(chatClient);
		
	}

	@Override
	public synchronized void broadCastMessage(String message) throws RemoteException {
		int i = 0;
		while(i<chatClients.size()){
			chatClients.get(i++).retrieveMessage(message);
		}
		
	}

}
