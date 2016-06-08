package py.com.sif.curso.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class NumberUtils {
	
	   public static Boolean entero(Double number) {
		    if(number == null){
		    	return null;
		    }
	        if (number % 1 == 0) {
	            return true;
	        } else {
	            return false;
	        }
	    }
	   
	   public static Boolean entero(BigDecimal number) {
		    if(number == null){
		    	return null;
		    }
	        if (number.doubleValue() % 1 == 0) {
	        	return true;
	        } else {
	            return false;
	        }
	    }

	    
	    public static BigDecimal add(BigDecimal one, BigDecimal two) {
	    	BigDecimal res = BigDecimal.ZERO;
	    	if ( one == null && two == null) {
	    		return null;
	    	}
	    	if ( one != null) {
	    		res = res.add(one);
	    	}
	    	if ( two != null) {
	    		res = res.add(two);
	    	}	    		    	
	    	return res;
	    }

	    public static Long add(Long one, Long two) {
	    	Long res = 0L;
	    	if ( one == null && two == null) {
	    		return null;
	    	}
	    	if ( one != null) {
	    		res += one;
	    	}
	    	if ( two != null) {
	    		res += two;
	    	}	    		    	
	    	return res;
	    }	 
	    
	    public static String format(BigDecimal number, int scale) {
	    	if ( number == null) {
	    		number = BigDecimal.ZERO;
	    	}
	    	BigDecimal bd = number.setScale(scale, BigDecimal.ROUND_HALF_UP);
	    	DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.getDefault());
	    	otherSymbols.setDecimalSeparator(',');
	    	otherSymbols.setGroupingSeparator('.'); 
	    	
	    	DecimalFormat df = new DecimalFormat();

	    	df.setMaximumFractionDigits(scale);
	    	df.setMinimumFractionDigits(scale);
	    	df.setGroupingUsed(true);
            df.setDecimalFormatSymbols(otherSymbols);
	    	return df.format(bd);	    	
	    }
	    
	    public static String format(Long number) {
	    	if ( number == null) {
	    		number = 0L;
	    	}
	    	return format(new BigDecimal(number), 0);
	    }	    
}
