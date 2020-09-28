package ar.com.exercise.application.model.entity;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="ADVERTISEMENTS")
public class AdvertisementEntity {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull(message = "Title is mandatory")
	@Column(name="TITLE",nullable = false)
	private String title;
	
	@NotNull(message = "Description is mandatory")
	@Column(name="DESCRIPTION", nullable = false)
	private String description;
	
	@NotNull(message = "Date is mandatory")
	@Future(message = "La fecha Fin debe ser superiror a la actual")
	@DateTimeFormat(pattern="yyyy-mm-dd")
	@Column(name="DATEEND", nullable = false)
	private LocalDate dateEnd;
	
	
	@NotNull(message = "The max price is mandatory")
	@Column(name="MAXPRICE", nullable = false)
	private int maxPrice;
	
	@Digits(integer=4, fraction = 0)
	@Column(name="PRICE", nullable = false)
	private int price;
	
	@Column(name="USERID")
	private Long userId;
	
	@Column(name="CREATE_DAY")
	private LocalDate createDay;
	
	@Column(name="NUMBER_DAY")
	private int numberDay;
	
	@Column(name="NUMBER_ADS")
	private int numberAds;
	
	@Column(name="NUMBER_ADS_DAY")
	private float numberAdsDay;



	public AdvertisementEntity() {
		
	}

	public AdvertisementEntity(String title, String description, LocalDate dateEnd,
			int maxPrice, int price, Long userId, LocalDate createDay, int numberDay, int numberAds, float numberAdsDay) {
		this.title = title;
		this.description = description;
		this.dateEnd = dateEnd;
		this.maxPrice = maxPrice;
		this.price = price;
		this.userId = userId;
		this.createDay = createDay;
		this.numberDay = numberDay;
		this.numberAds = numberAds;
		this.numberAdsDay = numberAdsDay;
	}

	public Long getId() {
		return id;
	}
	
	public int getNumberDay() {
		return numberDay;
	}

	public void setNumberDay(int numberDay) {
		this.numberDay = numberDay;
	}

	public int getNumberAds() {
		return numberAds;
	}


	public void setNumberAds(int numberAds) {
		this.numberAds = numberAds;
	}


	public float getNumberAdsDay() {
		return numberAdsDay;
	}


	public void setNumberAdsDay(float numberAdsDay) {
		this.numberAdsDay = numberAdsDay;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public LocalDate getCreateDay() {
		return createDay;
	}


	public void setCreateDay(LocalDate createDay) {
		this.createDay = createDay;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocalDate getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(LocalDate dateEnd) {
		this.dateEnd = dateEnd;
	}

	public int getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
