package com.sytrus.api;

import java.net.Socket;

public abstract class Method {
	
	public Type type;
	
	public abstract void attack(Socket socket);

	public Type getType() {
		return this.type;
	}
	
	public void log(String str) {
		System.out.println(str);
	}
	
}
