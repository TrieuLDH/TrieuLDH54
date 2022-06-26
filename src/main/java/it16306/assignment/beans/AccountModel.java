package it16306.assignment.beans;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountModel {
	
	@NotEmpty(message = "Không để trống")
	private String username;
	
	@NotBlank(message = "Không để trống")
	@Size(min = 6, message = "Mật khẩu có ít nhất 6 ký tự")
	private String password;
	
	@NotBlank(message = "Không để trống")
	private String fullname;
	
	@Email
	@Pattern(regexp = "\\w+@gmail.com", message = "Email sai định dạng")
	@NotBlank(message = "Không để trống")
	private String email;
	
	@NotBlank(message = "Không để trống")
	private String photo;
	
	private int activated;
	
	private int admin;
}
