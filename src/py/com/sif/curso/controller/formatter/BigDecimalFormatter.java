package py.com.sif.curso.controller.formatter;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.Formatter;

public class BigDecimalFormatter implements Formatter<BigDecimal>{
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public String print(BigDecimal object, Locale locale) {
		logger.info("Print: {}", object);
		String result = null;
    	if(object != null ){
	    	BigDecimal value = object;
	    	if(value != null ){
	    		result = value.toString().replace(".", ",");
	    	}
    	}
    	return result;
	}

	@Override
	public BigDecimal parse(String text, Locale locale) throws ParseException {
		logger.info("Parse: {}", text);
		 if(text != null && !text.isEmpty()){
			 text = text.replace(",", ".");
	    	 BigDecimal result = new BigDecimal(text);
	         return result;
	   	 }
		 return null;
	}


}
