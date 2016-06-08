package py.com.sif.curso.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class GuiApplicationContextProvider implements ApplicationContextAware {

	private static ApplicationContext guiApplicationContext;
	private Logger log = LoggerFactory.getLogger(getClass());
		
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		log.info("setting spring context");
		guiApplicationContext = applicationContext;		
	}

	public static ApplicationContext getContext() {
		return guiApplicationContext;
	}
	
}
