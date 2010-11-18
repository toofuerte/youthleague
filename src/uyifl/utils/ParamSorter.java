package uyifl.utils;

import java.util.Map;

public class ParamSorter {
	
	private Map<String, String[]> parameterMap;
	
	public ParamSorter(Map<String, String[]> parameterMap) {
		this.parameterMap = parameterMap;
	}

	public String get(String field) {
		if (parameterMap.containsKey(field))
			return parameterMap.get(field)[0];
		else
			return null;
	}	
	

}
