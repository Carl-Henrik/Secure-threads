package com.example.main;

import java.util.LinkedList;
import java.util.Scanner;

public class queue {
	
	public class threadPut extends Thread {
		
		int number;
		
		threadPut(int Number){
		this.number = Number;		
		}
		
		public void run(){
			try {put(new object(), number);} 
			catch (InterruptedException e) {e.printStackTrace();}
			}
		}
	
	
	public class threadTake extends Thread {
		
		int number;
		threadTake(int Number){
		this.number = Number;		
		}
		
		
		public void run(){
			try {take(number);} 
			catch (InterruptedException e) {e.printStackTrace();}
			}
		}
	
	
	
	
	public LinkedList<object> queue;
	public int capacity = 10;
	int put;
	int take;
	Scanner in = new Scanner(System.in);
	
	
	public queue(){
		
		System.out.println("Hur många strängar som lägger till objekt vill du skapa? \n");
		put = in.nextInt();
				
		System.out.println("Hur många strängar som tar bort objekt vill du skapa? \n");
		take = in.nextInt();
		
		queue = new LinkedList<object>();
		
		
		for (int i = 1; i <= put; i++){new threadPut(i).start();}
		for (int i = 1; i <= take; i++){new threadTake(i).start();}		
			
		
	}
	
	
	
	
	
	
	public synchronized void put(object obj, int number) throws InterruptedException{
		
		while(true){
		while(queue.size() == capacity){wait();}
		queue.add(obj);
		System.out.println("An object was added to the queue by positive thread number " + number + "!");
		notifyAll();
		}
	}
	
	public synchronized void take(int number) throws InterruptedException{
		
		while(true){
		while(queue.isEmpty()){wait();}
		queue.remove();
		System.out.println("An object was removed from the queue by negativ thread number " + number + "!");
		notifyAll();
		}
	}
}






