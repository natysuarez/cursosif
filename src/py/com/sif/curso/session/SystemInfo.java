package py.com.sif.curso.session;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;


public class SystemInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	private static final Logger logger = LoggerFactory.getLogger(SystemInfo.class);
	private String  userName;
	private String  nombreUsuario;
	private Boolean client;
	private Long    idUser;
	private String pagePath;
	private Set<String> roles;
	private Boolean authenticated = false;

	
	@DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss")
	private Date fechaHora;
	private Calendar calendar;
	private String version;
	private Boolean systemError = false;
	private String errorMessage;
	
	@PostConstruct
	public void init(){
		logger.info("\n==============\nSystem Info\n==============\n");
	  	loadSystemInfo();
	}

	@PreDestroy
	public void destroy(){
		logger.info("\n==============\nDestroying System Data\n==============\n");
	}
	
	private void loadSystemInfo(){
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public Boolean getClient() {
		return client;
	}

	public void setClient(Boolean client) {
		this.client = client;
	}

	public String getPagePath() {
		return pagePath;
	}

	public void setPagePath(String pagePath) {
		this.pagePath = pagePath;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	public Boolean getAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(Boolean authorized) {
		this.authenticated = authorized;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Boolean getSystemError() {
		return systemError;
	}

	public void setSystemError(Boolean systemError) {
		this.systemError = systemError;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	
	public boolean hasRole(String value){
		if ( this.getRoles() == null || this.getRoles().isEmpty()) {
			return false;
		}
		return this.getRoles().contains(value);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
