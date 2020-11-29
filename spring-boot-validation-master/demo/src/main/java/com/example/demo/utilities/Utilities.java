package com.example.demo.utilities;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.FlightModel.Flight;

public class Utilities {
	
	public static String isContainDifferentCharAndMasked(String s){
    	String []str1 = s.split("-");
    	String []str2= s.split(",");
    	StringBuilder maskedString = new StringBuilder();
    	int counter = 0;
    	if (str1.length > 1){
    		for (int i = 0; i < str1.length;++i){
    			for (int j = 0; j < str1[i].length();++j){
    				if (counter > 5 && counter < 12 ) {
    	            	maskedString.append("*");
    	            } else {
    	            	maskedString.append(str1[i].charAt(j));
    	            }
    				counter++;
        		}
    		}
    	}
    	else if (str2.length > 1){
    		for (int i = 0; i < str2.length;++i){
    			for (int j = 0; j < str2[i].length();++j){
    				if (counter > 5 && counter < 12 ) {
    	            	maskedString.append("*");
    	            } else {
    	            	maskedString.append(str2[i].charAt(j));
    	            }
    				counter++;
        		}
    		}
    	}
    	else{
    		for (int i = 0; i < s.length(); i++) {
                if (i > 5 && i < 12 ) {
                	maskedString.append("*");
                } else {
                	maskedString.append(s.charAt(i));
                }
            }
    	}
    	return maskedString.toString();
    }

    
    public static Map<Boolean,Long> calculateMinBalance(Flight flight_,String creditCardNumber){
    	Map<Boolean,Long> hashMap = new HashMap<>();
    	int counter = 0;
    	Long min =Long.MAX_VALUE;
    	for (int i = 0; i < flight_.getTicketModel().size(); ++i){
    		if ( flight_.getTicketModel().get(i).getCreditCardNumber().equals(creditCardNumber)
    				&& min > flight_.getTicketModel().get(i).getBalance()){
    			min = flight_.getTicketModel().get(i).getBalance();
    			counter++;
    		}
    	}
    	if ( counter >= 1){
    		hashMap.put(Boolean.TRUE,min);
    	}
    	else{
    		hashMap.put(Boolean.FALSE,min);
    	}
    	return hashMap;
    }
    

}
