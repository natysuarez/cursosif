package py.com.sif.curso.config;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import py.com.sif.curso.session.dto.AppInfoDTO;



public class GuiContextListener implements ServletContextListener {

	Logger log = LoggerFactory.getLogger(getClass());
	private static AppInfoDTO info;
	
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		if ( info != null) {
		  log.info("Stopped {} {} build {} by {}",new String[]{info.getArtifactName(), info.getVersion(),info.getBuildNumber(),info.getVendor()});
		} else {
			  log.info("Stopped SGC");

		}
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		ApplicationContext ctx =  GuiApplicationContextProvider.getContext();
		info = new AppInfoDTO();
		log.info("Context: {}", ctx);
		Properties props = new Properties();
		
		try {
			props.load(ctx.getResource("classpath:version.properties").getInputStream());
			info.setBuildNumber(props.getProperty("build.number"));
			
			props.load(ctx.getResource("classpath:build.properties").getInputStream());
			info.setArtifactName(props.getProperty("artifact.name"));
			info.setVendor(props.getProperty("implementation.vendor"));
			info.setVersion(props.getProperty("implementation.version"));
		} catch (IOException e) {
			log.warn("no data were found in properties file. not fatal. continuing");			
		} finally {
			props = null;
		}				
		log.info("Started {} {} build {} by {}",new String[]{info.getArtifactName(), info.getVersion(),info.getBuildNumber(),info.getVendor()});		
		
	}
	
	public static AppInfoDTO getInfo(){
		return info;
	}	
	
}	
	

