package com.axsosacademy.demo.models;



import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
	//attribute
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@Size(min = 1, message = "Frist name must  be present")
	private String firstname;

	@Size(min = 1, message = "Last name must  be present")
	private String lastname;
	

	@Pattern(regexp = "^[a-zA-Z0-9_!#$%&â€™*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+.[a-zA-Z0-9.-]+$", message = "Invalid email pattern")
	@Column(unique = true)
	private String email;
	

	@Size(min = 8, message = "Password must be at least 8 characters long")
	private String password;
	
	@Transient
	private String passwordConfirmation;
	
	@Column(updatable = false)
	private Date createdAt;
	
	private Date updatedAt;
	
//	Constructors
	public User() {
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
	
	public User(String firstname, String lastname, String email, String password, String passwordConfirmation, Role role) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
	}
	
	 //relationships
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	private List<Order> orders;
    
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "role_id")
	private Role role;
	
	



	//getter and setter

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}
	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}


}