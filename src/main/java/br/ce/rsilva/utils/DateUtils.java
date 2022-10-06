package br.ce.rsilva.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	public static Date obterDataDiferencaDias(int dias) {
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, dias);
		return cal.getTime();		
	}
	
//	public static Date formatarData(Date data) {
//		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//		format.format(data);
//		return data;
//	}
}
