package com.pulkit.ds.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

public class WhichSweetShouldIBring {

	public static void main(String[] args) {
		List<String> sweets = new ArrayList<String>(Arrays.asList("Gulab-jamun", "Laddu", "Jalebi", "Barfi", "Laddu",
				"Gulab-jamun", "Gulab-jamun", "Jalebi", "Gajar-halwa", "Gajar-halwa", "Barfi", "Gajar-halwa"));
		String sweet = whichSweetShldIBring(sweets);
		System.out.println(sweet);
	}

	private static String whichSweetShldIBring(List<String> sweets) {
		String sweet = "";
		TreeMap<String, Integer> map = new TreeMap<String, Integer>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareToIgnoreCase(o2);
			}
		});
		for (String singleSweet : sweets) {
			if(map.get(singleSweet)==null) {
				map.put(singleSweet, 1);
			}else {
				map.put(singleSweet, map.get(singleSweet)+1);
			}
		}
		System.out.println(map);
		int count = Integer.MIN_VALUE;
		for(Entry<String,Integer> entry:map.entrySet()) {
			if(entry.getValue()>=count) {
				sweet = entry.getKey();
				count = entry.getValue();
			}
		}
		return sweet;
	}

}
