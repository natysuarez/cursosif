package py.com.sif.curso.utils;

import java.text.SimpleDateFormat;
import java.util.Date;


public class ConvertUtils {
  
  private final String TIPO_DATO_TEXTO = "Texto";
  private final String TIPO_DATO_NUMERICO = "Numérico";
  
  public String tipoDato(String param){
    if(param == null){
      return "";
    }
    if(TIPO_DATO_NUMERICO.equals(param)){
      return "numeric";
    }
    if(TIPO_DATO_TEXTO.equals(param)){
      return "character";
    }
    return "";
  }
  
  
  public String dateToString(Date date, String format){
	  if(date != null){
		  SimpleDateFormat df = new SimpleDateFormat(format);
	      String stringdate = df.format(date);
		  return stringdate;
	  }
	  return "";
  }
  
}
