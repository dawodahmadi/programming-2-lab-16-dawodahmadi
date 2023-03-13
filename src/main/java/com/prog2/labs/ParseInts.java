package com.prog2.labs;

import java.util.Scanner;

public class ParseInts {

	public static void main(String[] args) {
		int val, sum = 0;
		Scanner scan = new Scanner(System.in);
		String line;
		
		System.out.println("Enter a line of text");
		Scanner scanLine = new Scanner(scan.nextLine());
		
		while(scanLine.hasNext()) {
			try {
			val = Integer.parseInt(scanLine.next());
			sum += val;
			} catch (NumberFormatException e) {
				System.out.println("Not an integer: " + e.getMessage());
			}
		}
		
		System.out.println("The sum of the integers on this line is " + sum);
	}

}
