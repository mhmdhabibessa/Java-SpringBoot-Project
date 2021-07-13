package com.axsosacademy.demo.models;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
//import javax.persistence.criteria.Order;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "roles")
public class Role {
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@NotBlank
	private String name;
	
//	@NotNull
//	@Pattern(regexp = "^[a-zA-Z0-9_!#$%&â€™*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+.[a-zA-Z0-9.-]+$", message = "Invalid email pattern")
//	private String email;
//	@NotNull
//	@Size(min = 8, message = "Password must be at least 8 characters long")
//	private String password;
 //relationships
	  @OneToMany(mappedBy="role", fetch = FetchType.LAZY)
		private List<User> users;


	public Role() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}

