package com.example.demo.common.util;

import java.lang.reflect.Field;
import java.util.Date;

public class PagerUtil {

	public static int seekOffset(int page, int size) {
		if (page > 0) {
			return (page - 1) * size;
		}
		return 0;
	}

	public static void createDate(Object obj) {
		Class<? extends Object> clazz = obj.getClass();

		Field[] fields = clazz.getDeclaredFields();

		for (Field f : fields) {
			if (f.getType().equals(Date.class)) {
				f.setAccessible(true);
				try {
					f.set(obj, new Date());
				} catch (Exception ignore) {
					// Nothing to do
				}
			}
		}
	}

}
