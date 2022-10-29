package org.serratec.ecommerce.api.security;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

public class LoginDTO {

	@NotBlank
	@ApiModelProperty(value="Login do usuário")
	private String username;

	@NotBlank
	@ApiModelProperty(value="Password do usuário")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
