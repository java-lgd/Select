package utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class SqlUtils {

	public static String ObjectTowhere(Object o, String tabname) {
		if (o == null)
			return "";
		String where = "";

		Field[] fs = o.getClass().getDeclaredFields();
		for (Field f : fs) {
			if(Modifier.isStatic(f.getModifiers())) continue;
			f.setAccessible(true);
			Object v = null;
			try {
				v=f.get(o);
				if(v==null)continue;
			}catch (Exception e) {
				continue;
			}
			if (v instanceof String) {
				if (v.toString().length() == 0)
					continue;
				where += " " + tabname + "." + f.getName() + " like '%" + v + "%' and ";
			} else {
				if (f.getName().endsWith("id")) {
					if (Double.valueOf(v.toString()) <= 0)
						continue;
				}
				else 
				if (Double.valueOf(v.toString()) <= -1)
						continue;
				where += " " + tabname + "." + f.getName() + " = " + v + " and ";
			}
		}
		if (where.length() > 0) {
			where = where.substring(0, where.length() - 4);
			where = " where " + where;
		}
		return where;
	}
}
