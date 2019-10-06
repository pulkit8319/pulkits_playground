package com.pulkit.ds.practice;

public class EvenOddThread {

	public static void main(String[] args) {
		PrintNumber pn = new PrintNumber();
		EvenThread th1 = new EvenThread(pn);
		OddThread th2 = new OddThread(pn);
		th1.start();
		th2.start();
	}

}

class EvenThread extends Thread {
	PrintNumber pn;

	public EvenThread(PrintNumber pn) {
		this.pn = pn;
	}

	@Override
	public void run() {
		while (pn.num < 11) {
			if (pn.num % 2 == 0) {
					System.out.print("Even Thread - ");
					pn.printNum();
					pn.num++;
			}
		}
	}

}

class OddThread extends Thread {

	PrintNumber pn;

	public OddThread(PrintNumber pn) {
		this.pn = pn;
	}

	@Override
	public void run() {
		while (pn.num < 11) {
			if (pn.num % 2 == 1) {
					System.out.print("Odd Thread - ");
					pn.printNum();
					pn.num++;
			}
		}
	}

}

class PrintNumber {

	int num = 1;

	public void printNum() {
		System.out.println(num);
	}
}