package com.cognizant.truyum.util;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class DateUtil {

	public static Date convertToDate(String s) {
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
		Date d;
		try {
			d=simpleDateFormat.parse(s);
			return d;
		}
		catch(ParseException e){
			e.printStackTrace();
			
		}
	return null;
	}

}
