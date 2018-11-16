package com.example.demo.util;

public class MyUtil {
	// page 값을 skip 값으로 변환해서 리턴한다.
	public static String pageToSkip(String pageString, String sizeString) {
		int page = Integer.parseInt(pageString);
		int size = Integer.parseInt(sizeString);
		
		int skip = 0;
		if (page > 0) {
			skip = (page - 1) * size;
		}
		
		return String.valueOf(skip);
	}
}
