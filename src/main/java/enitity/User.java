package enitity;

 
public class User {
	private String loginId;
	private String userName;
	private String password;
	
	public User() {
	}
	 public User(String loginId, String userName, String password) {
	        this.loginId = loginId;
	        this.userName = userName;
	        this.password = password;
	    }

	    public void setUserId(String loginId) {
	        this.loginId = loginId;
	    }

	    public String getLoginId() {
	        return this.loginId;
	    }

	    public void setUserName(String userName) {
	        this.userName = userName;
	    }

	    public String getUserName() {
	        return this.userName;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String getPassword() {
	        return this.password;
	    }
	
}
