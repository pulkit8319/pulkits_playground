package com.pulkit.ds.practice;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
	public static void main(String[] args) {
		PC pc = new PC();
		Thread p = new Thread() {
			@Override
			public void run() {
				pc.produce();
			}
		};
		Thread c = new Thread() {
			@Override
			public void run() {
				pc.consume();
			}
		};
		p.start();
		c.start();
	}
}

class PC {
	Queue<Integer> q = new LinkedList();
	int capacity = 10;

	public void produce() {
		int num = 1;
		while (true) {
			synchronized (this) {
				while (q.size() == capacity) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Producer producing : " + num);
				q.add(num++);
				notify();
			}
		}
	}

	public void consume() {
		while (true) {
			synchronized (this) {
				while (q.isEmpty()) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Consumer consuming : " + q.poll());
				notify();
			}
		}
	}
}
