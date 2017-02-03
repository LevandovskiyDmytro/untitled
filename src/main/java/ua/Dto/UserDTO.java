package ua.Dto;

public class UserDTO {
	private int id;
	private String name;
	private String email;

	private String phone;
	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", login=" + name + ", email=" + email
				+ ", phone=" + phone + "]";
	}

	


}
