package py.com.sif.curso.session.dto;

public class AppInfoDTO {
	private String buildNumber;
	private String vendor;
	private String version;
	private String artifactName;
	
	public String getBuildNumber() {
		return buildNumber;
	}
	public void setBuildNumber(String buildNumber) {
		this.buildNumber = buildNumber;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getArtifactName() {
		return artifactName;
	}
	public void setArtifactName(String artifactName) {
		this.artifactName = artifactName;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AppInfoDTO [buildNumber=");
		builder.append(buildNumber);
		builder.append(", vendor=");
		builder.append(vendor);
		builder.append(", version=");
		builder.append(version);
		builder.append(", artifactName=");
		builder.append(artifactName);
		builder.append("]");
		return builder.toString();
	}
	
	
}
