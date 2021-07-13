package com.axsosacademy.demo.models;




import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity ;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.Size;

@Entity
@Table(name = "categories")
public class Category {
	//attribute
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 1, message = "Category must be present and more than 1 char")
	@Column(unique = true)
	private String name;
	

	@Column(nullable=true,length=64)
	private String pic;
	
	@Transient
	public String getPhotosImagePath() {
		if(pic == null || id == null ) return null;
		return"/category-photos/" + id + "/" + pic;
	}
	@Size(min = 1, message = "Description must  be present")
	private String descreption;
	
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	public Category() {
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
	private String description;

	 //relationships
    @OneToMany(mappedBy="category", fetch = FetchType.LAZY)
	private List<Painting> Paintings;


	//getter and setter

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public List<Painting> getPaintings() {
		return Paintings;
	}
	public void setPaintings(List<Painting> paintings) {
		Paintings = paintings;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getDescreption() {
		return descreption;
	}
	public void setDescreption(String descreption) {
		this.descreption = descreption;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", pic=" + pic + ", descreption=" + descreption
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", Paintings=" + Paintings + "]";
	}
	
	

}
