package ar.com.exercise.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import ar.com.exercise.application.model.dto.AdvertisementUserRequestDTO;
import ar.com.exercise.application.model.dto.UserDTO;
import ar.com.exercise.application.model.entity.UserEntity;
import ar.com.exercise.application.repository.UserRepository;
import javassist.NotFoundException;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	
	public boolean validateUser (Long id) throws NotFoundException {
		boolean isAutenticated = false;
		Optional<UserEntity> user = repository.findById(id);
		if (user.isPresent()) {
			isAutenticated = true;
		}
		return isAutenticated;
	}
	
	
	public UserEntity createUser(AdvertisementUserRequestDTO userDTO) throws Exception {
		
		UserEntity user = new UserEntity();
			
			user.setCountry(userDTO.getCountry());
			user.setAge(userDTO.getAge());
			user.setGender(userDTO.getGender());
			
			repository.save(user);
		return user;
	}
	
	public UserDTO getUser(Long id) throws Exception{
		UserDTO newUser = new UserDTO();
		Optional<UserEntity> user = repository.findById(id);
		
		if(user.isPresent()) {
			newUser.setAge(String.valueOf(user.get().getAge()));
			newUser.setCountry(user.get().getCountry());
			newUser.setGender(user.get().getGender());
		}
		return newUser;
	}
	
}
