package py.com.sif.curso.session;

import java.io.Serializable;

import py.com.sif.curso.config.GuiContextListener;
import py.com.sif.curso.session.dto.AppInfoDTO;




public class AppInfoBean implements Serializable {
	
	private static final long serialVersionUID = 6582803663628247288L;    
	private AppInfoDTO dto;
	
	public AppInfoBean(){}
	
	public AppInfoDTO getInfo() {
		if ( dto == null) {
			this.dto = GuiContextListener.getInfo();
		}
		return dto;
	}
	public void setInfo(AppInfoDTO dto) {
		this.dto = dto;
	}
	
	public String getVendor(){
		if ( this.getInfo() == null) {
			return "";
		}
		return this.dto.getVendor();
	}
	
	public String getVersionInfo(){
		if ( this.getInfo() == null) {
			return "";
		}
		return String.format("%s Version %s build #%s", this.dto.getArtifactName(), this.dto.getVersion(), this.dto.getBuildNumber());
	}
	
}
