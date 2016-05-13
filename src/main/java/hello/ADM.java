package hello;

public class ADM {

	
	private String userName;
	private String password;
	private String name;
	private String institution;
	
	
	
	public ADM(String userName, String password, String name, String institution) {
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.institution = institution;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	
}
