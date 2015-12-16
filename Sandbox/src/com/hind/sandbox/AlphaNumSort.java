package com.hind.sandbox;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author HIND
 *
 */
public class AlphaNumSort {

	private String inputString;
	/**
	 * @param args
	 */
	
	public AlphaNumSort(String test){
		setinputString(test);
	}
	
	
	public static void main(String[] args) {
		
		String str = "";
		Scanner sc = new Scanner(System.in);
	    while (sc.hasNext()) {
	        str = sc.nextLine();
	        if(str!=null){
	        	AlphaNumSort alpha = new  AlphaNumSort(str);
	        	//example string: "NewYork 5 in Atlanta Texas 2 Delhi Mumbai London 4 Frankfurt"
	    		String sortedAlpha = alpha.doAlphaNumSort();
	    		System.out.println("Before Sorting[" + alpha.getinputString() +"]");
	    		System.out.println("After Sorting" + sortedAlpha);
	    		}
			}
	    sc.close();
	}

	/**
	 * @return the testString
	 */
	public String getinputString() {
		return inputString;
	}
	/**
	 * @param testString the testString to set
	 */
	public void setinputString(String testString) {
		this.inputString = testString;
	}
	
	public String doAlphaNumSort(){
		Collection<String> cityNames = createAndSortCollection(this.getinputString());
		return cityNames.toString();
	}
	
	public List<String> createAndSortCollection(String alpha){
		
	List<String> strings = new ArrayList<String>();
	List<String> fullList = new ArrayList<String>();
	List<String> numbers = new ArrayList<String>();
	StringTokenizer tokens = new StringTokenizer(alpha," ");
	String token = null;
	while(tokens.hasMoreTokens()){
		token = tokens.nextToken();
		if(token!=null){
			
			if(this.isInteger(token)){
				numbers.add(token);
			}else{
				strings.add(token);
			}
		fullList.add(token);
		}
	}
	Collections.sort(strings);
	Collections.sort(numbers);
	this.preserveOrderPostSorting(strings,numbers,fullList);
	return fullList;
	}
	
	private boolean isInteger( String input ) {
	    try {
	        Integer.parseInt( input );
	        return true;
	    }
	    catch( Exception e ) {
	        return false;
	    }
	}

	private void preserveOrderPostSorting(List<String> string, List<String> number, List<String> fullList){
	
		int loop = 0;
		while(loop < fullList.size()) {
			if(this.isInteger(fullList.get(loop))){
				fullList.set(loop, number.get(0));
				number.remove(0);
			}else{
				fullList.set(loop, string.get(0));
				string.remove(0);
			}
			++loop;
		}
	}
}
