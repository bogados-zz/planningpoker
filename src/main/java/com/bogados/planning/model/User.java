package com.bogados.planning.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class User extends BaseBean{

	@NotNull
	@NotEmpty
	@Column(unique = true)
	private String username;
	@NotNull
	@NotEmpty
	private String password;
	private LocalDateTime lastLogin;
	@NotNull
	private Boolean isAdmin = false;

}

