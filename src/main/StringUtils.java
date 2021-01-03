package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	public static String toSnakeCase(String text) {
		
		if(text==null) throw new NullPointerException("text is null");
		
		Pattern p = Pattern.compile("([A-Z])");
		for(;;) {
			Matcher m = p.matcher(text);
			if(!m.find()) break;
			text = m.replaceFirst("_" + m.group(1).toLowerCase());
		}
		
		return text.replaceFirst("^_", "");
	}

}
