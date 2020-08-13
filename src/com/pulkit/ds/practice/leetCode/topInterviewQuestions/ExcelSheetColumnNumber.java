package com.pulkit.ds.practice.leetCode.topInterviewQuestions;

public class ExcelSheetColumnNumber {

	public static void main(String[] args) {
		int colNum = titleToNumber("AAA");
		System.out.println(colNum);
	}

	private static int titleToNumber(String s) {
		int colNum = 0;
		if (s.isEmpty()) {
			return colNum;
		}
		int n = s.length();
		for (int i = 0; i<n; i++) {
			colNum += (s.charAt(i) - 64) * Math.pow(26,n-i-1);
		}
		return colNum;
	}

}
