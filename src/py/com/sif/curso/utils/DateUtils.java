package py.com.sif.curso.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Clase utilizada para el manejo de operaciones con fechas
 * 
 * @author ncanatta
 * @version 1.0
 *
 */

public class DateUtils {
	
		public static final long DAY_LONG = 1000 * 60 * 60 * 24;
		public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
		private static Logger log = LoggerFactory.getLogger(DateUtils.class);
		  
		public static final String DAY = "DAY";
		public static final String HOUR = "HOUR";
		public static final String MIN = "MIN";
		public static final String SEC = "SEC";
		public static final String MSEC = "MSEC";
		
		public static Long timeBetweenDates(Date date1, Date date2, String mode){
			// Crear 2 instancias de Calendar
	        Calendar cal1 = Calendar.getInstance();
	        Calendar cal2 = Calendar.getInstance();

	        // Establecer las fechas
	        cal1.setTime(date1);
	        cal2.setTime(date2);

	        // conseguir la representacion de la fecha en milisegundos
	        long milis1 = cal1.getTimeInMillis();
	        long milis2 = cal2.getTimeInMillis();

	        // calcular la diferencia en milisengundos
	        long diff = milis2 - milis1;

	        // calcular la diferencia en segundos
	        long diffSeconds = diff / 1000;

	        // calcular la diferencia en minutos
	        long diffMinutes = diff / (60 * 1000);

	        // calcular la diferencia en horas
	        long diffHours = diff / (60 * 60 * 1000);

	        // calcular la diferencia en dias
	        long diffDays = diff / (24 * 60 * 60 * 1000);
	        
	        if(log.isDebugEnabled()){
		        log.debug("miliseconds: {} miliseconds.", diff);
		        log.debug("seconds: {} seconds.", diffSeconds);
		        log.debug("minutes: {} minutes.", diffMinutes);
		        log.debug("hours: {} hours.", diffHours);
		        log.debug("days: {} days.", diffDays);
	        }
	        
	        if(DAY.equals(mode)){
	        	return diffDays;
	        }
	        
	        if(HOUR.equals(mode)){
	        	return diffHours;
	        }
	        
	        if(MIN.equals(mode)){
	        	return diffMinutes;
	        }
	        
	        if(SEC.equals(mode)){
	        	return diffSeconds;
	        }
	        return diff;
		}
	  

	  /**
	   * Obtiene la Fecha Actual con una precision de hasta milisegundos
	   * 
	   * @return Date
	   * 
	   */
	  public static Date getCurrentDate() {
	    Date date = new Date(System.currentTimeMillis());
	    return date;
	  }
	  
	  /**
	   * Obtiene el nro de días entre dos fechas
	   * 
	   * @param date1
	   * @param date2
	   * @return Date
	   */
	  @SuppressWarnings("unused")
	  public static Integer subtractDays(Date date1, Date date2) {
		Integer residue = 0;
	    GregorianCalendar gc1 = new GregorianCalendar();
	    gc1.setTime(date1);
	    GregorianCalendar gc2 = new GregorianCalendar();
	    gc2.setTime(date2);
	    
	    int days1 = 0;
	    int days2 = 0;
	    int maxYear = Math.max(gc1.get(Calendar.YEAR), gc2.get(Calendar.YEAR));
	    
	    /*	
	    GregorianCalendar gctmp = (GregorianCalendar) gc1.clone();
	    for (int f = gctmp.get(Calendar.YEAR); f < maxYear; f++) {
	      days1 += gctmp.getActualMaximum(Calendar.DAY_OF_YEAR);
	      gctmp.add(Calendar.YEAR, 1);
	    }
	    
	    gctmp = (GregorianCalendar) gc2.clone();
	    for (int f = gctmp.get(Calendar.YEAR); f < maxYear; f++) {
	      days2 += gctmp.getActualMaximum(Calendar.DAY_OF_YEAR);
	      gctmp.add(Calendar.YEAR, 1);
	    }
	    */
	    
	    days1 += gc1.get(Calendar.DAY_OF_YEAR)-1;
	    days2 += gc2.get(Calendar.DAY_OF_YEAR)-1;
	    
	    if(gc2.get(Calendar.YEAR) > gc1.get(Calendar.YEAR)){
	    	residue = Math.abs((365-days1)+days2);
	    }else{
	    	residue = Math.abs(days1 - days2);
	    }
	    return residue;
	  }
	  
	  /**
	   * Formatea una fecha y devuelve una fecha sin hh:mm:ss
	   * 
	   * @param date
	   * @return Date
	   * @throws ParseException
	   * 
	   */
	  public static Date getCurrentDateOnly(Date date) throws ParseException {
	    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	    String stringdate = df.format(date);
	    Date actualdate = df.parse(stringdate);
	    return actualdate;
	  }
	  
	  /**
	   * Formatea una fecha y devuelve una fecha con hh:mm:ss
	   * 
	   * @param date
	   * @return Date
	   * @throws ParseException
	   * 
	   */
	  public static Date getCurrentWithTime() {
		Date date = new Date(System.currentTimeMillis());
	    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	    String stringdate = df.format(date);
	    Date actualdate = null;
		try {
			actualdate = df.parse(stringdate);
		} catch (ParseException e) {
			log.error(e.getMessage(), e);
		}
	    return actualdate;
	  }
	  
	  public static String getCurrentTimeAsString() {
			Date date = new Date(System.currentTimeMillis());
		    SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss");
		    String stringtime = df.format(date);
		    return stringtime;
		  }
	  
	  public static Date format(Date date) {
		  	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		    String stringdate = df.format(date);
		    Date formattedDate = null;
			try {
				formattedDate = df.parse(stringdate);
			} catch (ParseException e) {
				log.error(e.getMessage(), e);
			}
		    return formattedDate;
		  }
	  
	  public static String asString(Date date) {
		  	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		    String stringdate = df.format(date);
		    return stringdate;
	  }
	  
	  public static String asStringShort(Date date) {
		  	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		    String stringdate = df.format(date);
		    return stringdate;
	  }	  
	  /**
	   * Obtiene la fecha actual con Horas, minutos y segundos
	   * 
	   * @return Date
	   * 
	   */
	  public static Date getCurrentDateWOHms() {
	    return new Date(setHmsFirst(getCurrentDate().getTime()).getTime().getTime());
	  }
	  
	  public static Boolean daysBetweenDates(Date dateStart, Date dateEnd, int daysQuantity) {
	    Long dayDiff = (dateEnd.getTime() - dateStart.getTime()) / DAY_LONG;
	    return (dayDiff <= daysQuantity);
	  }
	  
	  private static void setCalendarHmsToFirst(Calendar c) {
	    c.set(Calendar.HOUR_OF_DAY, 0);
	    c.set(Calendar.MINUTE, 0);
	    c.set(Calendar.MILLISECOND, 0);
	    c.set(Calendar.SECOND, 0);
	  }
	  
	  private static void setCalendarHmsToLast(Calendar c) {
	    c.set(Calendar.HOUR_OF_DAY, 23);
	    c.set(Calendar.MINUTE, 59);
	    c.set(Calendar.MILLISECOND, 0);
	    c.set(Calendar.SECOND, 59);
	  }
	  
	  /**
	   * Obtiene la fecha con la primera hora del dia
	   * 
	   * @param date
	   * @return Date
	   * 
	   */
	  public static Date getDateWFirstHms(Long date) {
	    return new Date(setHmsFirst(date).getTimeInMillis());
	  }
	  
	  /**
	   * Obtiene la fecha con la última hora del dia
	   * 
	   * @param date
	   * @return Date
	   * 
	   */
	  public static Date getDateWLastHms(Long date) {
	    return new Date(setHmsLast(date).getTimeInMillis());
	  }
	  
	  public static Calendar setHmsFirst(Long dateTime) {
	    Calendar c = Calendar.getInstance();
	    c.setTimeInMillis(dateTime);
	    setCalendarHmsToFirst(c);
	    return c;
	  }
	  
	  public static Calendar setHmsLast(Long dateTime) {
	    Calendar c = Calendar.getInstance();
	    c.setTimeInMillis(dateTime);
	    setCalendarHmsToLast(c);
	    return c;
	  }
	  
	  /*****************************************************************************
	   * 
	   * Verifica si una fecha se encuentra dentro de un determinado rango de fechas
	   * 
	   * @param date
	   * @param startDate
	   * @param endDate
	   * @return Boolean
	   * 
	   */
	  public static Boolean isBetween(Date date, Date startDate, Date endDate) {
	    return ((date.after(startDate) || date.toString().equals(startDate.toString())) && (date.before(endDate) || date
	        .toString().equals(endDate.toString())));
	  }
	  
	  public static Boolean isBetweenW0Hms(Date date, Date startDate, Date endDate) {
	    return ((getDateWFirstHms(date.getTime()).after(getDateWFirstHms(startDate.getTime())) || getDateWFirstHms(
	        date.getTime()).toString().equals(getDateWFirstHms(startDate.getTime()).toString())) && (getDateWFirstHms(
	        date.getTime()).before(getDateWFirstHms(endDate.getTime())) || getDateWFirstHms(date.getTime()).toString()
	        .equals(getDateWFirstHms(endDate.getTime()).toString())));
	  }
	  
	  /*****************************************************************************
	   * Verifica si dos fechas son iguales
	   * 
	   * @param dateOri
	   * @param dateDst
	   * @return Boolean
	   */
	  public static Boolean isEqual(Date dateOri, Date dateDst) {
	    return dateOri.toString().equals(dateDst.toString());
	  }
	  
	  /*****************************************************************************
	   * Verifica si un determinada fecha corresponde a la fecha actual
	   * 
	   * @param date
	   * @return Boolean
	   */
	  public static Boolean isToday(Date date) {
	    return isEqual(date, getCurrentDateWOHms());
	  }
	  
	  /*****************************************************************************
	   * 
	   * @param dateOri
	   * @param dateDst
	   * @return Boolean
	   */
	  public static Boolean isBeforeToday(Date date) {
	    Date dateNow = getCurrentDateWOHms();
	    return date.before(dateNow);
	  }
	  
	  public static Boolean isBefore(Date date, Date when) {
	    if (date == null || when == null)
	      return false;
	    return getDateWFirstHms(date.getTime()).before(getDateWFirstHms(when.getTime()));
	  }
	  
	  public static Boolean isAfter(Date date, Date when) {
	    if (date == null || when == null)
	      return false;
	    return getDateWFirstHms(date.getTime()).after(getDateWFirstHms(when.getTime()));
	  }
	  
	  public static Boolean isEquals(Date date, Date when) {
	    if (date == null || when == null)
	      return false;
	    return getDateWFirstHms(date.getTime()).equals(getDateWFirstHms(when.getTime()));
	  }
	  
	  /*****************************************************************************
	   * 
	   * @param dateOri
	   * @param dateDst
	   * @return
	   */
	  public static Boolean isAfterToday(Date date) {
	    if (date == null) {
	      return false;
	    }
	    Date dateNow = getCurrentDateWOHms();
	    return date.after(dateNow);
	  }
	  
	  /*****************************************************************************
	   * 
	   * @param startDate
	   * @param endDate
	   * @return
	   */
	  public static Boolean isTodayInUse(Date startDate, Date endDate) {
	    Date date = getCurrentDate();
	    
	    if (date.after(startDate) && (date.before(endDate) || date.toString().equals(endDate.toString()))) {
	      return true;
	    }
	    return false;
	  }
	  
	  /**
	   * Agrega dias a una Determinada fecha
	   * 
	   * @param startDate
	   * @param days
	   * @return Date
	   */
	  public static Date addDays(Date startDate, int days) {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(startDate);
	    cal.add(Calendar.DATE, days);
	    return new Date(cal.getTime().getTime());
	  }
	  
	  /**
	   * 
	   * @param myDate
	   * @return myDate in the nex year
	   */
	  public static Date addYear(Date myDate) {
	    Calendar myCalendar = Calendar.getInstance();
	    myCalendar.setTimeInMillis(myDate.getTime());
	    int myDay = myCalendar.get(Calendar.DAY_OF_MONTH);
	    int myMonth = myCalendar.get(Calendar.MONTH);
	    int myYear = myCalendar.get(Calendar.YEAR) + 1;
	    myCalendar.set(myYear, myMonth, myDay);
	    return new Date(myCalendar.getTime().getTime());
	  }
	  
	  /**
	   * 
	   * @param myDate
	   * @return myDate in the previous year
	   */
	  public static Date minorYear(Date myDate) {
	    Calendar myCalendar = Calendar.getInstance();
	    myCalendar.setTimeInMillis(myDate.getTime());
	    int myDay = myCalendar.get(Calendar.DAY_OF_MONTH);
	    int myMonth = myCalendar.get(Calendar.MONTH);
	    int myYear = myCalendar.get(Calendar.YEAR) - 1;
	    myCalendar.set(myYear, myMonth, myDay);
	    return new Date(myCalendar.getTime().getTime());
	  }
	  
	  public static Boolean isWeekEnd(Date fecha) {
	    GregorianCalendar cal = new GregorianCalendar();
	    cal.setTime(fecha);
	    int we = cal.get(Calendar.DAY_OF_WEEK);
	    return (we == Calendar.SUNDAY || we == Calendar.SATURDAY);
	  }
	  public static String getStringTime(Date fecha) {
	    Calendar c = Calendar.getInstance();
	    c.setTimeInMillis(fecha.getTime());
	    return String.format("%tR", c);
	  }
	  
	  public static int getYearByDate(Date myDate){
		  Calendar cal = Calendar.getInstance();
		  cal.setTime(myDate);
		  return cal.get(Calendar.YEAR);		  
	  }
	  
	  public static Date getInitMonth(Date myDate) {
		  Calendar c = Calendar.getInstance();
		  c.setTimeInMillis(myDate.getTime());		  
		  c.set(Calendar.DAY_OF_MONTH, 1);
		  return c.getTime();
	  }

}
