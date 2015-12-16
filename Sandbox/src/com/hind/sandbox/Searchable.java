package com.hind.sandbox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Searchable {

	private Map <Integer,String> mapforSearch = null;
	private int inputVal;
	
	private Searchable(int x){
		mapforSearch = new HashMap<Integer, String>();
		mapforSearch.put((Integer)1,"10");
		mapforSearch.put((Integer)11,"5");
		mapforSearch.put((Integer)12,"15");
		mapforSearch.put((Integer)111,"foo");
		mapforSearch.put((Integer)112,"bar");
		mapforSearch.put((Integer)121,"bat");
		mapforSearch.put((Integer)122,"baz");
		inputVal = x;
	}
	

	public static void main(String[] args) {
		
		Searchable clazz = new Searchable(0);
		String str = "";
		Scanner sc = new Scanner(System.in);
	    while (sc.hasNext()) {
	        str = sc.nextLine();
	        if(str!=null){
				List<Integer> inputValues = clazz.readInput(str);
				//System.out.println("Input Value ==" + inputValues.toString());
				for (Iterator iterator = inputValues.iterator(); iterator.hasNext();) {
					Integer integer = (Integer) iterator.next();
					clazz.setInputVal(integer.intValue());
					int generatedKey = 1;
					//System.out.println("Input Value ==" + clazz.getInputVal()+ " " + generatedKey);
					clazz.locate(generatedKey);
				}
			}else{
				System.out.println("Please enter a not-null argument");
			}    
	    }
	}
	
	public void locate(int generatedKey){
			String str = this.getMapforSearch().get(new Integer(generatedKey));
			if(str !=null){
			if (this.isInteger(str)){
				if(this.getInputVal() < (Integer.parseInt(str))){
					//System.out.println("Loop-1== " + this.getInputVal() + "  " + str);
					locate(generatedKey*10 +1);
				}else if (this.getInputVal() >= (Integer.parseInt(str))){
					//System.out.println("Loop-2== " + this.getInputVal() + "  " + str);
					locate(generatedKey*10 +2);
				}
			}else{
				System.out.println("Found leaf node== " + str);	
				return;
			}
		}else{
			System.out.println("Search exhausted, did not find the required node, exiting");
			return;
		}
	}
	
	public List<Integer> readInput(String alpha){
	StringTokenizer tokens = new StringTokenizer(alpha," ");
	String token = null;
	List<Integer> numbers = new ArrayList<Integer>();
	while(tokens.hasMoreTokens()){
		token = tokens.nextToken();
		if(token!=null){
			if(this.isInteger(token)){
				numbers.add(Integer.parseInt(token));
		}
	}else{System.out.println("Null input, please provde a valid input");}
	}
		return numbers;
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
	
	private Map<Integer, String> getMapforSearch() {
		return mapforSearch;
	}

	private void setMapforSearch(Map<Integer, String> mapforSearch) {
		this.mapforSearch = mapforSearch;
	}

	private int getInputVal() {
		return inputVal;
	}

	private void setInputVal(int inputVal) {
		this.inputVal = inputVal;
	}


}
