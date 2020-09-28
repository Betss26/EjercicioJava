package ar.com.exercise.application.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name="USERS")
public class UserEntity {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="COUNTRY")
	private String country;
	
	@Max(value=100)
	@Min(value=18)
	@Column(name="AGE")
	private int age;
	
	@Column(name="GENDER")
	private String gender;

	
	
	public Long getId() {
		return id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	public UserEntity() {
		
	}

	public UserEntity(Long id, String country, int age, String gender) {
		super();
		this.id = id;
		this.country = country;
		this.age = age;
		this.gender = gender;
	}
	
	
}
