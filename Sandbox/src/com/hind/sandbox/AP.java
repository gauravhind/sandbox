package com.hind.sandbox;

import java.util.Scanner;

/*
Sample Input
5
1 3 5 9 11
Sample Output
7
*/

public class AP {
	public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        String temp = null;
        String temp2 = null;
        while(in.hasNext()){
            temp = in.nextLine();
            temp2 = in.nextLine();
        }
        in.close();
        
        int totalNum = Integer.parseInt(temp);
        if(totalNum <= 3) {return;}
        
        String[] tempNums = temp2.split(" ");
        //parse the integer array
        int[] nums = new int[totalNum];
        for(int i = 0; i < totalNum; i++) {
            nums[i] = Integer.parseInt(tempNums[i]);
        }
        
        int SUM = (nums[0] + nums[totalNum - 1]) * (totalNum + 1)/ 2;
        
        for(int i = 0; i < totalNum; i++) {
            SUM -= nums[i];
        }
        
        System.out.println(SUM);
    }
}