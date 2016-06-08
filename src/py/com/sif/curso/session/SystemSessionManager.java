package py.com.sif.curso.session;

import java.io.Serializable;
import java.security.Principal;

import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SystemSessionManager implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2687909912672328393L;

	private static final Logger logger = LoggerFactory
			.getLogger(SystemSessionManager.class);

	public SystemSessionManager() {
	}
	
	public void init(AuthenticationInfo user) throws Exception {
		try{
		  	if(user != null){
				authorize(user.getUsername(), user.getPassword());
		  	}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}	

	public void init(HttpServletRequest request){
//		logger.info("\n==============\nSession Manager\n==============\n");
	  	Principal user = request.getUserPrincipal();
	  	if(user != null){
			try {
				authorize(user.getName(), user.getName());
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
	  	}
	}	
	@PreDestroy
	public void destroy(){
//		logger.info("\n==============\nDestroying System Data\n==============\n");
	}	
	
	private void authorize(String username, String password) throws Exception {

	}	

}
