package login;

public class idDTO {
	private String id, password, name, jumin, email, confirmPassword;
	
	public idDTO() {
		
	}
	
	public idDTO(String id, String password, String name, String jumin, String email) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.jumin = jumin;
		this.email = email;
	}

	@Override
	public String toString() {
		String str = String.format("%s %s\t", id, password);
		return str;
	}

	public String getJumin() {
		return jumin;
	}

	public void setJumin(String jumin) {
		this.jumin = jumin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
