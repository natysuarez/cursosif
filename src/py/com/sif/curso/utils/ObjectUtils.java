package py.com.sif.curso.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

public class ObjectUtils {
	
	private static Logger logger = LoggerFactory.getLogger(ObjectUtils.class);
	
	public static void copyValues(Object source, Object target){
		try{
			BeanUtils.copyProperties(source, target);
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
	
  public static File byteToFile(byte[] data) throws IOException {
    String tmpFilename = UUID.randomUUID().toString();
    File file = File.createTempFile(tmpFilename, null);
    file.deleteOnExit();
    OutputStream out = new FileOutputStream(file);
    out.write(data);
    out.close();
    return file;
  }
  
  public static File byteToFile(byte[] data, String type) throws IOException {
    String tmpFilename = UUID.randomUUID().toString();
    File file = File.createTempFile(tmpFilename, type);
    file.deleteOnExit();
    OutputStream out = new FileOutputStream(file);
    out.write(data);
    out.close();
    return file;
  }
  
  public static boolean isEmpty(Object obj){
//   logger.info("OBJECTTTTTTTTTTTT: {}", obj);
    if (obj == null){
      return true;
    }
    
    if (obj instanceof String) {
      String cadena = (String) obj;
      if (cadena == null || cadena.equals(""))
        return true;
      else if(StringUtils.trimToNull(cadena) == null)
        return true;
    }
    else if (obj instanceof Long){
      Long entero = (Long) obj;
      if (entero == null || entero.compareTo(0L) == 0)
        return true;
    } else if ( obj instanceof BigDecimal) {
    	BigDecimal num = (BigDecimal) obj;
    	if ( num == null || BigDecimal.ZERO.compareTo(num) == 0) {
    		return true;
    	}
    }
    
    return false;
  }
  
  public static boolean isNotEmpty(Object obj){
    return !isEmpty(obj);
  }
  
  public static String toNumInUnits(long bytes) {
    int u = 0;
    for (;bytes > 1024*1024; bytes >>= 10) {
        u++;
    }
    if (bytes > 1024)
        u++;
    return String.format("%.1f %cB", bytes/1024f, " KMGTPE".charAt(u));
  }
  
  public static String parseString(String s){
    return StringUtils.upperCase(StringUtils.trimToNull(s));
  }
  
  public static Boolean toBoolean(String s){
	s = parseString(s);
    if(s == null)
    	return false;
    return "S".equals(s);
  }

	public static String hash(String clave) throws Exception { 
        MessageDigest md = MessageDigest.getInstance("MD5"); 
        md.reset();
        byte[] b = md.digest(clave.trim().toUpperCase().getBytes()); 
        int size = b.length; 
        StringBuffer h = new StringBuffer(size); 
        for (int i = 0; i < size; i++) { 
        	int u = b[i] & 255; 
            if (u<16) { 
              h.append("0"+Integer.toHexString(u)); 
            }else { 
              h.append(Integer.toHexString(u)); 
            } 
        } 
        return h.toString(); 	
	}
  
}
