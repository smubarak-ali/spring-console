/*
 *
 * Copyright 2014 IzzatTaqiuddin. All Rights Reserved.
 * 
 * This software is the proprietary information of IzzatTaqiuddin.  
 * Use is subject to license terms.
 * 
 */
package com.bigledger.emp_to_db.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class TimeFormat
{
	public static boolean debuggingOn = true;
	public static boolean auditTrailOn = true;

	public static Timestamp getTimestamp()
	{
		String strTS = TimeFormat.strDisplayTimeStamp();
		Timestamp tsRTN = TimeFormat.createTimeStamp(strTS);
		return tsRTN;
	}

	public static String strDisplayTimeStamp()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date bufDate = new java.util.Date();
		String strTimeStamp = formatter.format(bufDate);
		return strTimeStamp;
	}
	
	// 20130621 Joshua #13898 display time for tzId offset from default time zone
	public static String strDisplayTimeStampTZOffset(String tzId)
	{
		DateTime dt = new DateTime();
		DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
		DateTimeZone zone = DateTimeZone.forID(tzId);
		return fmt.print(dt.withZone(zone));
	}

	public static String strDisplayDay()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd");
		java.util.Date bufDate = new java.util.Date();
		String strTimeStamp = formatter.format(bufDate);
		return strTimeStamp;
	}
	
	public static String strDisplayMonth2()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("MMMMM");
		java.util.Date bufDate = new java.util.Date();
		String strTimeStamp = formatter.format(bufDate);
		return strTimeStamp;
	}
	
	public static String strDisplayMonth()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("MM");
		java.util.Date bufDate = new java.util.Date();
		String strTimeStamp = formatter.format(bufDate);
		return strTimeStamp;
	}
	
	public static String strDisplayDay(Timestamp ts)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd");
		java.util.Date bufDate = new java.util.Date(ts.getTime());
		String strTimeStamp = formatter.format(bufDate);
		return strTimeStamp;
	}	
	public static String strDisplayMMM_YY(Timestamp ts)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("MMM/yy");
		java.util.Date bufDate = new java.util.Date(ts.getTime());
		String strTimeStamp = formatter.format(bufDate);
		return strTimeStamp;
	}	

	
	public static String strDisplayMonth(Timestamp ts)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("MM");
		java.util.Date bufDate = new java.util.Date(ts.getTime());
		String strTimeStamp = formatter.format(bufDate);
		return strTimeStamp;
	}	
	
	public static String strDisplayMonth2(Timestamp ts)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("MMMMM");
		java.util.Date bufDate = new java.util.Date(ts.getTime());
		String strTimeStamp = formatter.format(bufDate);
		return strTimeStamp;
	}	
	
// 20121113 #7210 RAYHAN
	public static String strDisplayWeek(Timestamp ts)
	{
		Calendar sDateCalendar = new GregorianCalendar();
		sDateCalendar.setTime(ts);
		sDateCalendar.setMinimalDaysInFirstWeek(4); //20130513 Ain #9230
		sDateCalendar.setFirstDayOfWeek(Calendar.MONDAY); //20130509 Ain #9230
		int iWeek = sDateCalendar.get(Calendar.WEEK_OF_YEAR);
		
		String sWeek = String.valueOf(iWeek);
		return sWeek;
	}	
	
	public static String strDisplayPrevoiusMonth(){
		SimpleDateFormat formatter = new SimpleDateFormat("MM");
		Calendar calendar = new GregorianCalendar();
		int month = calendar.get(Calendar.MONTH);
		if (month == 0)
			month = 11;
		else
			month = month - 1;
		calendar.set(Calendar.MONTH, month);
		String strTimeStamp = formatter.format(calendar.getTime());
		return strTimeStamp;
	}
	
	public static String strDisplaynextMonth(){
		SimpleDateFormat formatter = new SimpleDateFormat("MM");
		Calendar calendar = new GregorianCalendar();
		int month = calendar.get(Calendar.MONTH);
		if (month == 11)
			month = 0;
		else
			month = month + 1;
		calendar.set(Calendar.MONTH, month);
		String strTimeStamp = formatter.format(calendar.getTime());
		return strTimeStamp;
	}
	
	public static String strDisplayYearofPreviousMonth(){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
		Calendar calendar = new GregorianCalendar();
		int month = calendar.get(Calendar.MONTH);
		int year = calendar.get(Calendar.YEAR);
		if (month == 0){
			year = year - 1;
		}
		calendar.set(Calendar.YEAR, year);
		String strTimeStamp = formatter.format(calendar.getTime());
		return strTimeStamp;
	}
	
	public static String strDisplayYearofNextMonth(){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
		Calendar calendar = new GregorianCalendar();
		int month = calendar.get(Calendar.MONTH);
		if (month == 11)
			month = 0;
		else
			month = month + 1;


		int year = calendar.get(Calendar.YEAR);
		if (month == 0){
			year = year + 1;
		}
		calendar.set(Calendar.YEAR, year);
		String strTimeStamp = formatter.format(calendar.getTime());
		return strTimeStamp;
	}	
	
	public static String strDisplayMonthMalay(String month)
	{
		if(month.equals("01"))
		{
			return "Januari";
		}
		if(month.equals("02"))
		{
			return "Februari";
		}
		if(month.equals("03"))
		{
			return "Mac";
		}
		if(month.equals("04"))
		{
			return "April";
		}
		if(month.equals("05"))
		{
			return "Mei";
		}
		if(month.equals("06"))
		{
			return "Jun";
		}
		if(month.equals("07"))
		{
			return "Julai";
		}
		if(month.equals("08"))
		{
			return "Ogos";
		}
		if(month.equals("09"))
		{
			return "September";
		}
		if(month.equals("10"))
		{
			return "Oktober";
		}
		if(month.equals("11"))
		{
			return "November";
		}
		if(month.equals("12"))
		{
			return "Disember";
		}
		return "";
	}
	
	public static String strDisplayYear()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
		java.util.Date bufDate = new java.util.Date();
		String strTimeStamp = formatter.format(bufDate);
		return strTimeStamp;
	}
	
	public static String strDisplayDate()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date bufDate = new java.util.Date();
		String strTimeStamp = formatter.format(bufDate);
		return strTimeStamp;
	}

	public static String strDisplayDate2()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
		java.util.Date bufDate = new java.util.Date();
		String strTimeStamp = formatter.format(bufDate);
		return strTimeStamp;
	}

	public static String strDisplayDate1(Timestamp tsTime)
	{
		try
		{
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
			long a = tsTime.getTime();
			java.util.Date bufDate = new java.util.Date(a);
			// String b = bufDate.toString();
			String strTimeStamp = formatter.format(bufDate);
			return strTimeStamp;
		} catch (Exception ex)
		{
			ex.printStackTrace();
			return new String("errrrrrooooooooorrrrrrrr");
		}
	}

	public static String strDisplayDate2(Timestamp tsTime)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
		long a = tsTime.getTime();
		java.util.Date bufDate = new java.util.Date(a);
		String strTimeStamp = formatter.format(bufDate);
		return strTimeStamp;
	}

	public static String strDisplayDate3(Timestamp tsTime)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy");
		long a = tsTime.getTime();
		java.util.Date bufDate = new java.util.Date(a);
		String strTimeStamp = formatter.format(bufDate);
		return strTimeStamp;
	}

	public static String strDisplayDate4(Timestamp tsTime)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
		long a = tsTime.getTime();
		java.util.Date bufDate = new java.util.Date(a);
		String strTimeStamp = formatter.format(bufDate);
		return strTimeStamp;
	}

	public static String strDisplayDate5(Timestamp tsTime)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("E");
		long a = tsTime.getTime();
		java.util.Date bufDate = new java.util.Date(a);
		String strTimeStamp = formatter.format(bufDate);
		return strTimeStamp;
	}

	public static String strDisplayDate5Long(Timestamp tsTime)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("EEEEE");
		long a = tsTime.getTime();
		java.util.Date bufDate = new java.util.Date(a);
		String strTimeStamp = formatter.format(bufDate);
		return strTimeStamp;
	}
	
	public static String strDisplayDate6(Timestamp tsTime)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
		long a = tsTime.getTime();
		java.util.Date bufDate = new java.util.Date(a);
		String strTimeStamp = formatter.format(bufDate);
		return strTimeStamp;
	}

	public static String strDisplayDate7(Timestamp tsTime)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		long a = tsTime.getTime();
		java.util.Date bufDate = new java.util.Date(a);
		String strTimeStamp = formatter.format(bufDate);
		return strTimeStamp;
	}

	public static String strDisplayDate8(Timestamp tsTime)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		long a = tsTime.getTime();
		java.util.Date bufDate = new java.util.Date(a);
		String strTimeStamp = formatter.format(bufDate);
		return strTimeStamp;
	}
	
	public static String strDisplayDate9(Timestamp tsTime)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("MMM dd");
		long a = tsTime.getTime();
		java.util.Date bufDate = new java.util.Date(a);
		String strTimeStamp = formatter.format(bufDate);
		return strTimeStamp;
	}	

	public static String strDisplayYearWithWeek(Timestamp tsTime)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
		long a = tsTime.getTime();
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.setTime(tsTime);
		//20130513 Ain #9230
		String day = TimeFormat.format(tsTime, "dd");
		String month = TimeFormat.format(tsTime, "MM");
		int week = TimeFormat.getWeek(tsTime); //20130514 Ain #9230
		int yearInt = calendar.get(Calendar.YEAR);
		String yearStr = "";
		if(month.equalsIgnoreCase("12")){
			if(day.equalsIgnoreCase("29") || day.equalsIgnoreCase("30") || day.equalsIgnoreCase("31")){
				if(week == 1){ 
					yearInt++; 
				}
			}
		}
		yearStr = Integer.toString(yearInt); 
		//END Ain #9230
		java.util.Date bufDate = new java.util.Date(a);
		String strTimeStamp = formatter.format(bufDate);
		//return strTimeStamp;
		return yearStr; //20130513 Ain #9230
	}
	
	public static String strDisplayYear(Timestamp tsTime)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
		long a = tsTime.getTime();
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.setTime(tsTime);		
		java.util.Date bufDate = new java.util.Date(a);
		String strTimeStamp = formatter.format(bufDate);
		return strTimeStamp;		
	}
	
	// 20090326
	public static String strDisplayDate10(Timestamp tsTime)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		long a = tsTime.getTime();
		java.util.Date bufDate = new java.util.Date(a);
		String strTimeStamp = formatter.format(bufDate);
		return strTimeStamp;
	}
	
	public static String strDisplayDate11(Timestamp tsTime)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("HHmmss");
		long a = tsTime.getTime();
		java.util.Date bufDate = new java.util.Date(a);
		String strTimeStamp = formatter.format(bufDate);
		return strTimeStamp;
	}
	
	public static String strDisplayDate12(Timestamp tsTime)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
		long a = tsTime.getTime();
		java.util.Date bufDate = new java.util.Date(a);
		String strTimeStamp = formatter.format(bufDate);
		return strTimeStamp;
	}
	
	public static String strDisplayDate13(Timestamp tsTime)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyMMddHHmm");
		long a = tsTime.getTime();
		java.util.Date bufDate = new java.util.Date(a);
		String strTimeStamp = formatter.format(bufDate);
		return strTimeStamp;
	}
	// end
	
	public static String strDisplayDate14(Timestamp tsTime)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd h:mm a");
		long a = tsTime.getTime();
		java.util.Date bufDate = new java.util.Date(a);
		String strTimeStamp = formatter.format(bufDate);
		return strTimeStamp;
	}
	
	public static String strDisplayDate15(Timestamp tsTime)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long a = tsTime.getTime();
		java.util.Date bufDate = new java.util.Date(a);
		String strTimeStamp = formatter.format(bufDate);
		return strTimeStamp;
	}
	
	public static String strDisplayDate16(Timestamp tsTime)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
		long a = tsTime.getTime();
		java.util.Date bufDate = new java.util.Date(a);
		String strTimeStamp = formatter.format(bufDate);
		return strTimeStamp;
	}
	
	public static String strDisplayDate17(Timestamp tsTime)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("MMM");
		long a = tsTime.getTime();
		java.util.Date bufDate = new java.util.Date(a);
		String strTimeStamp = formatter.format(bufDate);
		return strTimeStamp;
	}

	public static String strDisplayDate18(Timestamp tsTime)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("MMMMM");
		long a = tsTime.getTime();
		java.util.Date bufDate = new java.util.Date(a);
		String strTimeStamp = formatter.format(bufDate);
		return strTimeStamp;
	}
	
	public static String strDisplayDate19(Timestamp tsTime)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		long a = tsTime.getTime();
		java.util.Date bufDate = new java.util.Date(a);
		String strTimeStamp = formatter.format(bufDate);
		return strTimeStamp;
	}
	
	public static String strDisplayDate20(Timestamp tsTime)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		long a = tsTime.getTime();
		java.util.Date bufDate = new java.util.Date(a);
		String strTimeStamp = formatter.format(bufDate);
		return strTimeStamp;
	}
	
	/*
	 * 
	 * Date and Time Pattern Result "yyyy.MM.dd G 'at' HH:mm:ss z" 2001.07.04 AD
	 * at 12:08:56 PDT
	 * 
	 * "EEE, MMM d, ''yy" Wed, Jul 4, '01
	 * 
	 * "h:mm a" 12:08 PM
	 * 
	 * "hh 'o''clock' a, zzzz" 12 o'clock PM, Pacific Daylight Time
	 * 
	 * "K:mm a, z" 0:08 PM, PDT
	 * 
	 * "yyyyy.MMMMM.dd GGG hh:mm aaa" 02001.July.04 AD 12:08 PM
	 * 
	 * "EEE, d MMM yyyy HH:mm:ss Z" Wed, 4 Jul 2001 12:08:56 -0700
	 * 
	 * "yyMMddHHmmssZ" 010704120856-0700
	 */
	public static String format(Timestamp tsTime, String dateFormat)
	{
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
		long a = tsTime.getTime();
		java.util.Date bufDate = new java.util.Date(a);
		String strTimeStamp = formatter.format(bufDate);
		return strTimeStamp;
	}

	public static String strDisplayTime()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		java.util.Date bufDate = new java.util.Date();
		String strTimeStamp = formatter.format(bufDate);
		return strTimeStamp;
	}

	public static String strDisplayTime1(Timestamp tsTime)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		long a = tsTime.getTime();
		java.util.Date bufDate = new java.util.Date(a);
		String strTimeStamp = formatter.format(bufDate);
		return strTimeStamp;
	}
	
	public static String strDisplayTimeHour(Timestamp tsTime)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("HH");
		long a = tsTime.getTime();
		java.util.Date bufDate = new java.util.Date(a);
		String strTimeStamp = formatter.format(bufDate);
		return strTimeStamp;
	}
	
	public static String strDisplayTimeMinute(Timestamp tsTime)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("mm");
		long a = tsTime.getTime();
		java.util.Date bufDate = new java.util.Date(a);
		String strTimeStamp = formatter.format(bufDate);
		return strTimeStamp;
	}
	
	public static String strDisplayTime2(Timestamp tsTime)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("h:mm a");
		long a = tsTime.getTime();
		java.util.Date bufDate = new java.util.Date(a);
		String strTimeStamp = formatter.format(bufDate);
		return strTimeStamp;
	}

	public static String strDisplayDate(Timestamp ts)
	{
		return (ts.toString().substring(0, 10));
	}
	public static String strDisplayDateBackDate(Timestamp ts)
	{
		return (ts.toString().substring(0, 10)+" 23:59:59");
	}

	public static String strDisplayTime(Timestamp ts)
	{
		return (ts.toString().substring(11, 19));
	}

	public static Calendar createCalendar(String strTime)
	{
		Calendar cal = Calendar.getInstance();
		Timestamp ts = createTimeStamp(strTime);
		cal.setTime(new Date(ts.getTime()));
		return cal;
	}
	
	public static Timestamp createTimestamp(String strTime)
	{
		return TimeFormat.createTimeStamp(strTime);
	}

	public static Timestamp createTimeStamp(String strTime)
	{
		String strFormat;
		// Log.printDebug("TimeFormat: strTime b4 trim = " + strTime);
		strTime = strTime.trim();
		// Log.printDebug("TimeFormat: strTime after trim = " + strTime);
		if(strTime.length()==6)
		{
			String year = strTime.substring(0, 2);
			String month = strTime.substring(2, 4);
			String date = strTime.substring(4, 6);
			String fullDate = "";
			if(new Integer(year).intValue()>90)
			{
				fullDate += "19";
			}
			else
			{
				fullDate += "20";
			}
			fullDate += year +"-" + month + "-" + date;
			strTime = fullDate;
			strFormat = new String("yyyy-MM-dd");
			
		}
		else if (strTime.length() == 7)
		{
			strTime += "-01";
			strFormat = new String("yyyy-MM-dd");
		} else if (strTime.length() < 12)
		{
			strFormat = new String("yyyy-MM-dd");
		} else
		{
			strFormat = new String("yyyy-MM-dd HH:mm:ss");
		}
		SimpleDateFormat formatter = new SimpleDateFormat(strFormat);
		java.util.Date theDate = new java.util.Date();
		// Log.printDebug("theDate.getTime() ="+theDate.getTime());
		try
		{
			theDate = (java.util.Date) formatter.parse(strTime);
		} catch (Exception ex)
		{
			System.err.println("TimeFormat: " + ex.getMessage());
		}
		Timestamp rtnTS = new Timestamp(theDate.getTime());
		return rtnTS;
	}
	// 20121113 #7210 RAYHAN
	public static Timestamp createTimeStampFromYearWeek(String strTime, int fromOrTo)
	{
		strTime = strTime.trim();
		
		int week = Integer.parseInt(strTime.substring(5, 7));
		int year = Integer.parseInt(strTime.substring(0, 4));

		if(fromOrTo != 0)
			week++;  
		// Get calendar, clear it and set week number and year.
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		calendar.set(Calendar.WEEK_OF_YEAR, week);
		calendar.set(Calendar.YEAR, year);
		
		if(fromOrTo != 0)
			calendar.add(Calendar.DATE, -1);

		// Now get the first day of week.
		java.util.Date idate = calendar.getTime();
		Timestamp rtnTS = new Timestamp(idate.getTime());
		return rtnTS;
	}	
	public static Timestamp createTimeStamp(String strTime, String strFormat) throws Exception
	{
		// String strFormat;
		// Log.printDebug("TimeFormat: strTime b4 trim = " + strTime);
		strTime = strTime.trim();
		// Log.printDebug("TimeFormat: strTime after trim = " + strTime);
		/*
		 * if(strTime.length()<12) { strFormat = new String("yyyy-MM-dd");}
		 * else { strFormat = new String("yyyy-MM-dd HH:mm:ss");}
		 */
		SimpleDateFormat formatter = new SimpleDateFormat(strFormat);
		java.util.Date theDate = new java.util.Date();
		// Log.printDebug("theDate.getTime() ="+theDate.getTime());
		try
		{
			theDate = (java.util.Date) formatter.parse(strTime);
			Timestamp rtnTS = new Timestamp(theDate.getTime());
			return rtnTS;
		} catch (Exception ex)
		{
			System.err.println("TimeFormat: " + ex.getMessage());
			return null;
		}
		
	}
	
	// This function validate the date format-strDate is it same with the format-strFormat.
	public static void validateDate(String strDate, String strFormat) throws Exception
	{
		strDate = strDate.trim();

		if (strDate.length() != 10 
				|| Integer.parseInt(strDate.substring(5, 7)) < 1 
				|| Integer.parseInt(strDate.substring(5, 7)) > 12 
				|| Integer.parseInt(strDate.substring(8, 10)) < 1 
				|| Integer.parseInt(strDate.substring(8, 10)) > 31 )
		{throw new Exception("Date format must be in the following format (yyyy-mm-dd).");}
		
		SimpleDateFormat formatter = new SimpleDateFormat(strFormat);
		java.util.Date theDate = new java.util.Date();

		try
		{
			theDate = (java.util.Date) formatter.parse(strDate);
		} catch (Exception ex)
		{
			System.err.println("TimeFormat: " + ex.getMessage());
			throw new Exception("Date format must be in the following format (yyyy-mm-dd).");
		}		
	}

	public static Timestamp createTimestamp(String strDate, String strHour, String strMinute)
	{
		String buffer = strDate + " " + strHour + ":" + strMinute + ":00.0";
		return TimeFormat.createTimestamp(buffer);
	}

	public static Timestamp getCurrentDate()
	{
		String strFormat = new String("yyyy-MM-dd");
		SimpleDateFormat formatter = new SimpleDateFormat(strFormat);
		java.util.Date theDate = new java.util.Date();
		try
		{
			theDate = (java.util.Date) formatter.parse(formatter.format(theDate));
		} catch (Exception ex)
		{
			System.err.println("TimeFormat: " + ex.getMessage());
		}
		Timestamp rtnTS = new Timestamp(theDate.getTime());
		return rtnTS;
	}
	
	public static Timestamp getCurrentDateAndTime()
	{
		String strFormat = new String("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat formatter = new SimpleDateFormat(strFormat);
		java.util.Date theDate = new java.util.Date();
		try
		{
			theDate = (java.util.Date) formatter.parse(formatter.format(theDate));
		} catch (Exception ex)
		{
			System.err.println("TimeFormat: " + ex.getMessage());
		}
		Timestamp rtnTS = new Timestamp(theDate.getTime());
		return rtnTS;
	}

	public static Timestamp getTimestampMod(Timestamp theDate, int setYear, int setMonth, int setDay, int addYear, int addMonth, int addDay) throws Exception
	{ // TKW20090521: Primarily used in CreditTermsControlLogic.java
		Timestamp result = createTimestamp(theDate.toString()); // Necessarily complex to break ejb referential integrity. Just in case.
		GregorianCalendar gcalDate = new GregorianCalendar();
		gcalDate.setTime(result);
		if(setYear>0)
		{
			gcalDate.set(Calendar.YEAR, setYear);
		}
		if(setMonth>0)
		{
			gcalDate.set(Calendar.MONTH, setMonth);
		}	
		if(setDay>0)
		{
			if(setDay==40) // 40 is the constant that means LAST DAY OF MONTH.
			{
				Timestamp futureDate = getLastDay(new Timestamp(gcalDate.getTimeInMillis()));
				GregorianCalendar gcalFuture = new GregorianCalendar();
				gcalFuture.setTime(futureDate);
				setDay = gcalFuture.get(Calendar.DATE);
			}
			gcalDate.set(Calendar.DATE, setDay);
		}
		if(addYear>0)
		{
			gcalDate.add(Calendar.YEAR, addYear);
		}
		if(addMonth>0)
		{
			gcalDate.add(Calendar.MONTH, addMonth);
		}
		if(addDay>0)
		{
			if(addDay==40) // 40 is the constant that means LAST DAY OF MONTH.
			{
				Timestamp futureDate = getLastDay(new Timestamp(gcalDate.getTimeInMillis()));
				GregorianCalendar gcalFuture = new GregorianCalendar();
				gcalFuture.setTime(futureDate);
				addDay = gcalFuture.get(Calendar.DATE);
			}
			gcalDate.add(Calendar.DATE, addDay);
		}
		result = new Timestamp(gcalDate.getTimeInMillis());
		return result;
	}
	
	public static Timestamp add(Timestamp theDate, int year, int month, int day)
	{
		Timestamp rtnTs = null;
		GregorianCalendar gcalDate = new GregorianCalendar();
		gcalDate.setTime(theDate);
		GregorianCalendar gcalNew = new GregorianCalendar(gcalDate.get(Calendar.YEAR) + year, gcalDate.get(Calendar.MONTH) + month, gcalDate.get(Calendar.DATE) + day);
		rtnTs = new Timestamp(gcalNew.getTimeInMillis());
		return rtnTs;
	}	
	
	public static Timestamp subtract(Timestamp theDate, int year, int month, int day)
	{
		Timestamp rtnTs = null;
		GregorianCalendar gcalDate = new GregorianCalendar();
		gcalDate.setTime(theDate);
		GregorianCalendar gcalNew = new GregorianCalendar(gcalDate.get(Calendar.YEAR) - year, gcalDate.get(Calendar.MONTH) - month, gcalDate.get(Calendar.DATE) - day);
		rtnTs = new Timestamp(gcalNew.getTimeInMillis());
		return rtnTs;
	}	

	public static Timestamp add(Timestamp theDate, int year, int month, int day, int hour, int minute, int second)
	{
		Timestamp rtnTs = null;
		GregorianCalendar gcalDate = new GregorianCalendar();
		gcalDate.setTime(theDate);
		GregorianCalendar gcalNew = new GregorianCalendar(gcalDate.get(Calendar.YEAR) + year, gcalDate.get(Calendar.MONTH) + month, gcalDate.get(Calendar.DATE) + day,
				gcalDate.get(Calendar.HOUR_OF_DAY) + hour, gcalDate.get(Calendar.MINUTE) + minute, gcalDate.get(Calendar.SECOND) + second);
		rtnTs = new Timestamp(gcalNew.getTimeInMillis());
		return rtnTs;
	}		

	public static Timestamp addTime(Timestamp theDate, int hour, int minute, int second)
	{
		Timestamp rtnTs = null;
		GregorianCalendar gcalDate = new GregorianCalendar();
		gcalDate.setTime(theDate);
		GregorianCalendar gcalNew = new GregorianCalendar(gcalDate.get(Calendar.YEAR), gcalDate.get(Calendar.MONTH), gcalDate.get(Calendar.DATE),
				gcalDate.get(Calendar.HOUR_OF_DAY) + hour, gcalDate.get(Calendar.MINUTE) + minute, gcalDate.get(Calendar.SECOND) + second);
		rtnTs = new Timestamp(gcalNew.getTimeInMillis());
		return rtnTs;
	}	
	
	public static Timestamp set(Timestamp theDate, int option, int value)
	{
		GregorianCalendar gcalDate = new GregorianCalendar();
		gcalDate.setTime(theDate);
		// 20121113 #7210 RAYHAN
		GregorianCalendar gcalReturn = new GregorianCalendar((option == Calendar.YEAR) ? value : gcalDate.get(Calendar.YEAR), (option == Calendar.MONTH) ? 
				value : gcalDate.get(Calendar.MONTH), (option == Calendar.DATE) ? value : gcalDate.get(Calendar.DATE));
		// gcalDate.get(Calendar.MONTH),
		// gcalDate.get(Calendar.DATE));
		Timestamp tsReturn = new Timestamp(gcalReturn.getTimeInMillis());
		return tsReturn;
	}
	// 20121113 #7210 RAYHAN
	public static Timestamp setWeek(Timestamp theDate)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.setMinimalDaysInFirstWeek(4); //20130513 Ain #9230
		calendar.setFirstDayOfWeek(Calendar.MONDAY); //20130509 Ain #9230
		calendar.setTime(theDate);
		
		//20130412 Ain #11591
		int week = calendar.get(Calendar.WEEK_OF_YEAR);
		int year = calendar.get(Calendar.YEAR);
		
		calendar.clear();
		calendar.setMinimalDaysInFirstWeek(4); //20130513 Ain #9230
		calendar.setFirstDayOfWeek(Calendar.MONDAY); //20130509 Ain #9230
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.WEEK_OF_YEAR, week);
		
		java.util.Date idate = calendar.getTime();
		Timestamp rtnTS = new Timestamp(idate.getTime());
		return rtnTS;
	}
	
	public static int getWeek(Timestamp theDate)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.setTime(theDate);
		calendar.setMinimalDaysInFirstWeek(4); //20130513 Ain #9230
		calendar.setFirstDayOfWeek(Calendar.MONDAY); //20130509 Ain #9230
		int week = calendar.get(Calendar.WEEK_OF_YEAR);
		
		return week;
	}
	
	public static int get(Timestamp theDate, int option)
	{
		GregorianCalendar gcalDate = new GregorianCalendar();
		gcalDate.setTime(theDate);
		return gcalDate.get(option);
	}

	public static Timestamp createTimeStamp2(String strDate)
	{
		String suffix = " 00:00:00.000000000";
		if (strDate.length() < 11)
		{
			return Timestamp.valueOf(strDate.trim() + suffix);
		} else
		{
			return Timestamp.valueOf(strDate.trim() + ".000000000");
		}
	}

	public static Timestamp createTimeStampNextDay(String strDate)
	{
		Timestamp ts = null;
		String suffix = " 00:00:00.000000000";
		if (strDate.length() < 11)
		{
			strDate = strDate + suffix;
		} else if (strDate.length() > 10)
		{
			strDate = strDate.substring(0, 10) + suffix;
		} else
		{
			strDate = "invalid date";
		}
		Calendar cal = Calendar.getInstance();
		cal.setLenient(true);
		try
		{
			ts = Timestamp.valueOf(strDate);
			cal.setTimeInMillis(ts.getTime());
		} catch (Exception e)
		{
		}
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH) + 1, 0, 0, 0);
		cal.set(Calendar.MILLISECOND, 0);
		ts = new Timestamp(cal.getTimeInMillis());
		return ts;
	}
	
	//20140205 #18821 RAYHAN
	public static String createStrNextDay(String strDate) {
		return TimeFormat.strDisplayDate(createTimeStampNextDay(strDate));
	}

	public static Timestamp createTimeStampPreviousDay(String strDate)
	{
		Timestamp ts = null;
		String suffix = " 00:00:00.000000000";
		if (strDate.length() < 11)
		{
			strDate = strDate + suffix;
		} else if (strDate.length() > 10)
		{
			strDate = strDate.substring(0, 10) + suffix;
		} else
		{
			strDate = "invalid date";
		}
		Calendar cal = Calendar.getInstance();
		cal.setLenient(true);
		try
		{
			ts = Timestamp.valueOf(strDate);
			cal.setTimeInMillis(ts.getTime());
		} catch (Exception e)
		{
		}
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH) - 1, 0, 0, 0);
		cal.set(Calendar.MILLISECOND, 0);
		ts = new Timestamp(cal.getTimeInMillis());
		return ts;
	}

	public static int compareDates(Timestamp ts1, Timestamp ts2)
	{
		// Return <0 if ts1 < ts2
		// 0 if ts1 = ts2
		// >0 if ts1 > ts2
		//Log.printVerbose("ts1 before conversion: " + ts1.toString());
		//Log.printVerbose("ts2 before conversion: " + ts2.toString());
		Timestamp ts1DateOnly = createTimestamp(strDisplayDate(ts1));
		Timestamp ts2DateOnly = createTimestamp(strDisplayDate(ts2));
		//Log.printVerbose("ts1 after conversion: " + ts1.toString());
		//Log.printVerbose("ts2 after conversion: " + ts2.toString());
		return ts1DateOnly.compareTo(ts2DateOnly);
	}

	public static String strDisplayHour()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("HH");
		java.util.Date bufDate = new java.util.Date();
		String strTimeStamp = formatter.format(bufDate);
		return strTimeStamp;
	}


	public static int dayDifference(Timestamp buf1, Timestamp buf2)
	{   
		// TKW20091026: This is now the de facto standard for determining day difference.
		Timestamp tmp1 = createTimestamp("0001-01-01");
		Timestamp tmp2 = createTimestamp("0001-01-02");
		// TKW20091026: In order to get difference in days, time of day should not be a factor.
		// Therefore, removing time portion of date before performing calculation.
		buf1 = createTimestamp(strDisplayDate(buf1));
		buf2 = createTimestamp(strDisplayDate(buf2));
		// End TKW20091026
		long DAY_LONG = tmp2.getTime() - tmp1.getTime();
		long count = (buf1.getTime() - buf2.getTime()) / DAY_LONG;
		if(count < 0){ count = -count;}
		return (int) count;
	}
	
	public static int minuteDifference(Timestamp endDate, Timestamp startDate)
	{
		Timestamp tmp1 = createTimestamp("0001-01-01 00:00:00");
		Timestamp tmp2 = createTimestamp("0001-01-01 00:01:00 ");
		long MINUTE_LONG = tmp2.getTime() - tmp1.getTime();
		long count = (endDate.getTime() - startDate.getTime()) / MINUTE_LONG;
		if(count < 0){ count = -count;}
		return (int) count;
	}
	
/*	// 20080820 Jimmy
	public static int monthDifference(Timestamp buf1, Timestamp buf2)
	{
		int intTodayYear = buf1.getYear();
		int intTodayMonth = buf1.getMonth();
		int intTodayTotalMonth = (intTodayYear * 12) + intTodayMonth;
	
		int intTotalYear2 = buf2.getYear();
		int intTotalMonth2 = buf2.getMonth();
		int intTodayTotalMonth2 = (intTotalYear2 * 12) + intTotalMonth2;
	
		return intTodayTotalMonth2 - intTodayTotalMonth;
	}*/
	
	// 20121113 #7210 RAYHAN
	public static int weekDifference(Timestamp buf1, Timestamp buf2)
	{
		float dayCount = dayDifference(buf1, buf2);
		
	    int week = (int) (dayCount / 7) + 1;
	    return week;
		
	}
	
/*	//20140415 #26368 RAYHAN
	public static int quarterYearDifference(Timestamp buf1, Timestamp buf2)
	{
		int intTodayYear = buf1.getYear();
		int intTodayMonth = buf1.getMonth();
		int intTodayTotalMonth = (intTodayYear * 12) + intTodayMonth;
	
		int intTotalYear2 = buf2.getYear();
		int intTotalMonth2 = buf2.getMonth();
		int intTodayTotalMonth2 = (intTotalYear2 * 12) + intTotalMonth2;
	
		return (intTodayTotalMonth2 - intTodayTotalMonth)/3;
	}
	
	//20140415 #26368 RAYHAN
	public static int yearDifference(Timestamp buf1, Timestamp buf2)
	{
		int intTodayYear = buf1.getYear();
		int intTotalYear2 = buf2.getYear();
	
		return intTotalYear2 - intTodayYear;
	}*/
	
	public static int dayDiffNoGetTime(Timestamp buf1, Timestamp buf2)
	{
		int diff = 0;
		buf1 = createTimestamp(strDisplayDate(buf1));
		buf2 = createTimestamp(strDisplayDate(buf2));
	    while(buf1.before(buf2) || buf1.equals(buf2))
	    {
	    	buf1 = add(buf1,0,0,1);
	    	diff++;
	    }
	    return diff;
	}
	public static Timestamp getNextMonthLastDay(Timestamp date)
	{
		// 20140624 Constance #29648 get proper last day of next month.		
		//Timestamp resDate = add(date,0,1,0); // add(date,0,1,0) is adding 30 days instead of increment month by 1.		
		Timestamp resDate = getLastDay(date);
		resDate = add(date,0,0,1);
		resDate = getLastDay(resDate);
		return resDate;
	}
	public static Timestamp getLastDay(Timestamp date)
	{
		// TKW20080103: to get the last day of the date given.
		
		// First, set the date to the 28.
		Timestamp resDate = set(date,Calendar.DATE,28);
		// Then add 4 days. This ensures that you will get the next month, no matter what.
		resDate = add(resDate,0,0,4);
		// Then set the date of the new month to the 1st.
		resDate = set(resDate, Calendar.DATE,1);
		// Then minus one day. You will now get the last day of the month you want.
		resDate = add(resDate,0,0,-1);
		return resDate;
	}
	
	public static Timestamp getFirstDay(Timestamp date)
	{
		Timestamp resDate = set(date, Calendar.DATE,1);
		return resDate;
	}
	
	public static String getFirstDayOfTheYear(String date)
	{
		int year = Integer.parseInt(date.substring(0, 4));;
		Calendar calendarStart=Calendar.getInstance();
	    calendarStart.set(Calendar.YEAR,year);
	    calendarStart.set(Calendar.MONTH,0);
	    calendarStart.set(Calendar.DAY_OF_MONTH,1);
		
	    Date startDate=calendarStart.getTime();
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    String strStartDate = formatter.format(startDate);
	    return strStartDate;
	}
	
	public static String getFirstDayOfTheYear(Timestamp dateTime)
	{
		String date = String.valueOf(dateTime);
		int year = Integer.parseInt(date.substring(0, 4));
		Calendar calendarStart=Calendar.getInstance();
	    calendarStart.set(Calendar.YEAR,year);
	    calendarStart.set(Calendar.MONTH,0);
	    calendarStart.set(Calendar.DAY_OF_MONTH,1);
		
	    Date startDate=calendarStart.getTime();
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    String strStartDate = formatter.format(startDate);
	    return strStartDate;
	}
	
	public static Timestamp getTimestampSetAndAdd(Timestamp theDate, int setYear, int setMonth, int setDay, int addYear, int addMonth, int addDay) throws Exception
	{ 
		Timestamp result = createTimestamp(theDate.toString()); 
		GregorianCalendar gcalDate = new GregorianCalendar();
		gcalDate.setTime(result);
		if(setYear>0)
		{
			gcalDate.set(Calendar.YEAR, setYear);
		}
		if(setMonth>0)
		{
			gcalDate.set(Calendar.MONTH, setMonth);
		}	
		if(setDay>0)
		{
			if(setDay==40) // 40 is the constant that means LAST DAY OF MONTH.
			{
				Timestamp futureDate = getLastDay(new Timestamp(gcalDate.getTimeInMillis()));
				GregorianCalendar gcalFuture = new GregorianCalendar();
				gcalFuture.setTime(futureDate);
				setDay = gcalFuture.get(Calendar.DATE);
			}
			gcalDate.set(Calendar.DATE, setDay);
		}
		if(addYear!=0)
		{
			gcalDate.add(Calendar.YEAR, addYear);
		}
		if(addMonth!=0)
		{
			gcalDate.add(Calendar.MONTH, addMonth);
		}
		if(addDay!=0)
		{
			if (setDay==1) addDay = addDay - 1;
			
			gcalDate.add(Calendar.DATE, addDay);
		}
		result = new Timestamp(gcalDate.getTimeInMillis());
		return result;
	}
	
	// 20130620 Joshua #13898
   public static List getTimeZoneIds()
   {
	   final String TIMEZONE_ID_PREFIXES =
		      "^(Africa|America|Asia|Atlantic|Australia|Europe|Indian|Pacific)/.*";
	   final String[] timeZoneIds = TimeZone.getAvailableIDs();
	   List<String> zones = new ArrayList<String>();
       
       int i = 0;
       for (String id : timeZoneIds) {
           if (id.matches(TIMEZONE_ID_PREFIXES)) {
        	   zones.add(TimeZone.getTimeZone(id).getID());
           }
       } 
       Collections.sort(zones);
	   return zones;
   }
   
   public static String getDefaultTimeZoneId()
   {
	   return DateTimeZone.getDefault().toString();
   }
   // END 20130620 Joshua
	
   // 20130726 Jimmy: #15245
   // return negative or positive days
   public static int calculateDifference(Timestamp ts1, Timestamp ts2)
   {
	   LocalDate date1 = new LocalDate(ts1.getTime());
	   LocalDate date2 = new LocalDate(ts2.getTime());
	   return Days.daysBetween(date1, date2).getDays();
   }
   // End 20130726 Jimmy
   
 //20140312 #25953 RAYHAN
   public static Timestamp getyyyy_mm_dd(Timestamp date)
	{
	   return createTimestamp(strDisplayDate19(date));
	}
   
   public static Timestamp getFirstDayOfWeek(Timestamp date)
   {
	   DateTime dateTime = new DateTime(date);
	   DateTime startOfWeek = dateTime.weekOfWeekyear().roundFloorCopy();
	   
	   System.out.print("startOfWeek "+startOfWeek);
	   Timestamp ts = createTimestamp(startOfWeek.toString("yyyy-MM-dd"));
		
	   return  ts;
   }
   
   public static Timestamp getLastDayOfWeek(Timestamp date)
   {
	   DateTime dateTime = new DateTime(date);
	   
	   DateTime endOfWeek = dateTime.weekOfWeekyear().roundCeilingCopy();
	   System.out.print("endOfWeek "+endOfWeek);
	   Timestamp ts = createTimestamp(endOfWeek.toString("yyyy-MM-dd"));
		
	   return  ts;
   }
   
   public static Timestamp getPlusMonths(Timestamp date, int months)
   {
	   DateTime dateTime = new DateTime( date );
	   DateTime month = dateTime.plusMonths(months); // Smartly handles various month lengths, leap year, and so on.
	   Timestamp ts = createTimestamp(month.toString("yyyy-MM-dd"));
	   return  ts;
   }
   
   public static String getYear(Timestamp date)
   {
	   GregorianCalendar gcalDate = new GregorianCalendar();
	   gcalDate.setTime(date);
	   
	   return String.valueOf(gcalDate.get(Calendar.YEAR));
   }
   
   public static XMLGregorianCalendar toXMLGregorianCalendar(Timestamp date){
       GregorianCalendar gCalendar = new GregorianCalendar();
       gCalendar.setTime(date);
       XMLGregorianCalendar xmlCalendar = null;
       try {
           xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
       } catch (DatatypeConfigurationException ex) {
           //Logger.getLogger(StringReplace.class.getName()).log(Level.SEVERE, null, ex);
       }
       return xmlCalendar;
   }   
} // TimeFormat