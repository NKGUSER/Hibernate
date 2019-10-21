package model;

public class JwtUser {

	private String UserName;
	private Long Id;
	private String Role;
	
    public void setUserName(String userName) {
        this.UserName = userName;
    }

    public void setId(long id) {
        this.Id = id;
    }

    public void setRole(String role) {
        this.Role = role;
    }

	public String getUserName() {
		return UserName;
	}

	public Long getId() {
		return Id;
	}

	public String getRole() {
		return Role;
	}

}
