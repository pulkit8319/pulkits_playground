package com.pulkit.ds.practice;

public class EvenOddThread {
	public static void main(String[] args) {
		OddEvenPrint oep = new OddEvenPrint();
		Thread evenThread = new Thread() {
			@Override
			public void run() {
				oep.printEven();
			}
		};
		Thread oddThread = new Thread() {
			@Override
			public void run() {
				oep.printOdd();
			}
		};
		evenThread.start();
		oddThread.start();
	}
}

class OddEvenPrint {
	int num = 1;
	int max = 15;
	boolean isOdd = true;

	public void printEven() {
		while (num < max) {
			synchronized (this) {
				if (isOdd) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("ET called :" + num++);
				isOdd = true;
				notify();
			}
		}
	}

	public void printOdd() {
		while (num < max) {
			synchronized (this) {
				if (!isOdd) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("OT called :" + num++);
				isOdd = false;
				notify();
			}

		}
	}
}
