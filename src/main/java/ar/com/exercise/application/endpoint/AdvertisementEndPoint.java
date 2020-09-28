package ar.com.exercise.application.endpoint;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.exercise.application.model.dto.AdvertisementUserRequestDTO;
import ar.com.exercise.application.model.dto.AdvertisementUserResponseDTO;
import ar.com.exercise.application.model.dto.UserDTO;
import ar.com.exercise.application.model.entity.UserEntity;
import ar.com.exercise.application.service.AdvertisementService;
import ar.com.exercise.application.service.UserService;

@RestController
public class AdvertisementEndPoint {

	@Autowired
	private AdvertisementService service;

	@Autowired
	private UserService uService;

	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<List<AdvertisementUserResponseDTO>> getAdvertisement(@PathVariable(value = "id") Long id)
			throws Exception {

		List<AdvertisementUserResponseDTO> list = service.getAds();

		if (list != null) {
			if (uService.validateUser(id)) {

				for (AdvertisementUserResponseDTO item : list) {
					UserDTO user = uService.getUser(Long.parseLong(item.getUserId()));
					item.setUser(user);
				}
			}
			return new ResponseEntity<List<AdvertisementUserResponseDTO>>(list, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

	}

	@PutMapping("/")
	@ResponseBody
	public ResponseEntity<AdvertisementUserRequestDTO> createAdvertisement(
			@Valid @RequestBody AdvertisementUserRequestDTO advertisementUser) throws Exception {
		UserEntity user = uService.createUser(advertisementUser);
		if (user != null) {
			
			service.createAdvertisement(advertisementUser, user);
		}

		return new ResponseEntity<AdvertisementUserRequestDTO>(advertisementUser, HttpStatus.CREATED);
	}

	public UserDTO getUser(Long id) throws Exception {
		UserDTO user = uService.getUser(id);
		return user;
	}

}
