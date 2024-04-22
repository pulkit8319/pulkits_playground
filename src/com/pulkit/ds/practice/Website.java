package com.pulkit.ds.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Website {

	String url;
	static final Map<String,Integer> map = new HashMap<>();
	
	public Website(String url) {
		this.url = url;
		if(map.containsKey(url)){
    		map.put(url, map.get(url)+1);
    	}else{
    		map.put(url, 1);
    	}
	}
	
	public static List<String> getMostVisitedPages(){
		 List<Map.Entry<String, Integer> > list = 
	                new LinkedList<Map.Entry<String, Integer> >(map.entrySet()); 
	        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() { 
	            public int compare(Map.Entry<String, Integer> o1,  
	                               Map.Entry<String, Integer> o2) 
	            { 
	                return (o2.getValue()).compareTo(o1.getValue()); 
	            } 
	        }); 
	        List<String> str = new ArrayList<String>();
	        for (Map.Entry<String, Integer> aa : list) { 
	        	str.add(aa.getKey()); 
	        }
	        return str;
	}

}
