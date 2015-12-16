package com.hind.sandbox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author HIND
 * DataCopier synch data sets between different data centers using minimum copy operations.
 */
public class DataCopier {

	private int noOfDataCenters=0;
	
	private int getNoOfDataCenters() {
		return noOfDataCenters;
	}

	private void setNoOfDataCenters(int noOfDataCenters) {
		this.noOfDataCenters = noOfDataCenters;
	}

	public static void main(String[] args){

		DataCopier copier = new DataCopier();
		Map<Integer, ArrayList<Integer>> dataSets = new HashMap<Integer, ArrayList<Integer>>();
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		/*Create a map to store mapping of which data set is present in which data centers.*/ 
		/*Key = DataSetId, Value = List of DataCenters where the DataSetId is present */
		copier.readStandardInput(bufferRead, dataSets);
		
		/* read back from the Map */    
		copier.fetchFromMap(dataSets);
	
		/* Complete the copying operation*/
		System.out.println("done");
	}
	
	public void fetchFromMap(Map<Integer, ArrayList<Integer>> dataSets){
		
		for(Map.Entry<Integer, ArrayList<Integer>> entry : dataSets.entrySet()){
			int dataSetId = entry.getKey();
			//System.out.println("Print Id " + dataSetId);
			ArrayList<Integer> dataCenterIds = entry.getValue();
			//System.out.println("Print Id " + dataCenterIds);
			
			for(int j=1 ; j<=noOfDataCenters; j++){
				if(!dataCenterIds.contains(j)){
					//System.out.println("In the loop j=" + j + " Ids " + dataCenterIds);
					/* This means that the data set is not present in the data center and hence we need to copy the data set*/
					System.out.println(dataSetId + " " + dataCenterIds.get(0) + " " + j);
				}
			}
		}

	}
	
	public void readStandardInput(BufferedReader bufferRead, Map<Integer, ArrayList<Integer>> dataSets){
		int i=1;
		try{
			this.setNoOfDataCenters(Integer.parseInt(bufferRead.readLine()));         
		}catch(IOException e){
			e.printStackTrace();
			System.exit(0);
		}

		while(i <= this.getNoOfDataCenters()){
			try{                
				String s = bufferRead.readLine();                                
				String delimiters = new String(" ");
				StringTokenizer tokenizer = new StringTokenizer(s, delimiters, false);
				while (tokenizer.hasMoreTokens()) {    
					int num = Integer.parseInt(tokenizer.nextToken());
					ArrayList<Integer> list = dataSets.get(num);
					if(list!=null){
						list.add(i);
					}else{
						list = new ArrayList<Integer>();
						list.add(i);
					}
					dataSets.put(num, list);    
				}
			}
			catch(IOException e)
			{
				e.printStackTrace();
				System.exit(0);
			}
			i++;        
		}
		//System.out.println("\n" + dataSets.toString());
	}
}