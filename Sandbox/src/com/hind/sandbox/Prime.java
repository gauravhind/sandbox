package com.hind.sandbox;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prime {

	public static void main(String[] args) {
       
		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number till which the prime numbers are to be calculated: ");
        int input = scanner.nextInt();
        scanner.close();
        List<Integer> primes = new ArrayList<>();
 
        // loop through the numbers one by one
        for (int i = 2; i < input; i++) {
            // check to see if the number is prime
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        String s = primes.toString().replace("[", "").replace("]", "");
        System.out.println("The number of prime is : " + primes.size() + ", and they are: " + s);
    }
	
	public static boolean isPrime(int number){
	    for(int i=2; i<number; i++){
	        if(number%i == 0){
	            return false; //number is divisible so its not prime
	        }
	    }
	    return true; //number is prime now
	}
	
	
}
