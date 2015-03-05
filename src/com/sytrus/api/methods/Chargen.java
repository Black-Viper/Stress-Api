package com.sytrus.api.methods;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

import com.sytrus.api.Method;
import com.sytrus.api.Type;

public class Chargen extends Method {
	
	public Chargen() {
		this.type = Type.CHARGEN;
	}
	
	@Override
	public void attack(Socket socket) {
		PrintWriter pw;
		try {
			pw = new PrintWriter(socket.getOutputStream());
		} catch (IOException e) {
			log("Couldn't cast PrintWriter from Socket outpustream. Socket null?");
			return;
		}
		
		sendChars(pw);
		System.out.print(".");
		
	}
	
	private void sendChars(PrintWriter pw) {
		ArrayList<String> chars = new ArrayList<String>();
		chars.add("a");
		chars.add("b");
		chars.add("c");
		chars.add("d");
		chars.add("e");
		chars.add("f");
		chars.add("g");
		chars.add("h");
		chars.add("i");
		chars.add("j");
		chars.add("k");
		chars.add("l");
		chars.add("m");
		chars.add("n");
		chars.add("o");
		chars.add("p");
		chars.add("q");
		chars.add("r");
		chars.add("s");
		chars.add("t");
		chars.add("u");
		chars.add("v");
		chars.add("w");
		chars.add("x");
		chars.add("y");
		chars.add("z");
		chars.add("0");
		chars.add("1");
		chars.add("2");
		chars.add("3");
		chars.add("4");
		chars.add("5");
		chars.add("6");
		chars.add("7");
		chars.add("8");
		chars.add("9");
		chars.add("#");
		chars.add("<");
		chars.add(" ");
		chars.add(">");
		chars.add(".");
		chars.add(",");
		chars.add("/");
		chars.add("(");
		chars.add(")");
		String theMessage = "";
		for(String s : chars) {
			if(new Random().nextBoolean()) {
				theMessage = theMessage + s;
			}
		}
		for(String s : chars) {
			if(!theMessage.contains(s)) {
				theMessage = theMessage + s;
			}
		}
		pw.println(theMessage);
	}

}
