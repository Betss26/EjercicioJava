package ar.com.exercise.application.model.dto;


import com.fasterxml.jackson.annotation.JsonProperty;


public class AdvertisementUserRequestDTO {
	
	@JsonProperty("Title")
	private String title;
	
	@JsonProperty("Description")
	private String description;
	

	@JsonProperty("DateEnd")
	private String dateEnd;
	
	@JsonProperty("MaxPrice")
	private String maxPrice;
	
	@JsonProperty("Price")
	private String price;
	
	@JsonProperty("Country")
	private String country;
	
	@JsonProperty("Age")
	private int age;
	
	@JsonProperty("Gender")
	private String gender;
	
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

	public AdvertisementUserRequestDTO() {
		
	}

	

	public AdvertisementUserRequestDTO(String title, String description, String dateEnd, String maxPrice, String price,
			String country, int age, String gender) {
		this.title = title;
		this.description = description;
		this.dateEnd = dateEnd;
		this.maxPrice = maxPrice;
		this.price = price;
		this.country = country;
		this.age = age;
		this.gender = gender;
	}

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	
}
