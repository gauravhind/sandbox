package com.hind.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		//Sort the array in descending order of string length
        String[] w = new String [6];
        w[0]="a";
        w[1]="b";
        w[2]="ba";
        w[3]="bca";
        w[4]="bda";
        w[5]="bdca";
        
		sortArrayDesc(w);
        List listofStrings = new ArrayList <String>();
        for (int i = 0; i < w.length; i++) {
            listofStrings.add(w[i]);
        }
        
        char[] longestArray = w[0].toCharArray();
        System.out.println("longest Array " +String.valueOf(longestArray)); 
        int counter=1;
        int maxChain=0;
        for (int i = 0; i < longestArray.length; i++) {
            char[] newArray = charArrayCopy(i, longestArray); 
            System.out.println("new Array " +String.valueOf(newArray)); 
            counter=1;
            for (int j = 0; j < newArray.length; j++) {
            	char[] reducedArray = new char[newArray.length];
            	System.arraycopy(newArray, j,reducedArray, 0, newArray.length-j-1);
            	 System.out.println("reduced Array " +String.valueOf(reducedArray)); 
            	 String output = new String(String.valueOf(reducedArray).trim());
            	 output = output.replaceAll(" ", "");
            	 if(listofStrings.contains(output)){
            		counter++;
            		System.out.println("Counter Value==" +counter);
            	}if(counter > maxChain){	maxChain = counter;}
                }
        }
      
        System.out.println("longest chain "+maxChain);    

	}
	
	public static char[] charArrayCopy(int postionToBeSkipped, char[] x) {
		char[] reducedArray = new char[x.length]; 
		int j=0;
		for (int i = 0; i < x.length; i++) {
			if(i != postionToBeSkipped){
				reducedArray[j++]=x[i];	
			}
		}
	return reducedArray;	
	}
	
	

	private static void sortArrayDesc (String[] w){
	     // String[] str={"umbrella","apple", "baby", "cat","rat","obnoxious"};
			System.out.println("Before Sorting  ");
			for (int i = 0; i < w.length; i++) {
				System.out.print(w[i] + " ");
			}System.out.print("\n");
			
	        Arrays.sort(w, new Comparator<String>() {
	        public int compare(String o1, String o2) {
	            return o2.length()-o1.length();
	        } });
	        
	        System.out.println("After Sorting  ");
			for (int i = 0; i < w.length; i++) {
				System.out.print(w[i] + " ");
			}System.out.print("\n");
	}

}
