package ar.com.exercise.application.model.dto;



import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;


public class AdvertisementUserResponseDTO {

	@JsonProperty("Title")
	private String title;
	
	@JsonProperty("Description")
	private String description;
	
	@JsonInclude(Include.ALWAYS)
	@JsonProperty("UserId")
	private String userId;
	
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("Detail")
	private UserDTO user;

	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	
	
	
	public AdvertisementUserResponseDTO() {
		
	}

	public AdvertisementUserResponseDTO(String title, String description, String dateEnd, String maxPrice, String price,
			String userId, UserDTO user) {
		this.title = title;
		this.description = description;
		this.userId = userId;
		this.user = user;
	}
	
	
	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
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


	
	
	
	
}
