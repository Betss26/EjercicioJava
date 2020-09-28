package ar.com.exercise.application.service;

import static java.lang.Math.toIntExact;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.exercise.application.model.dto.AdvertisementUserRequestDTO;
import ar.com.exercise.application.model.dto.AdvertisementUserResponseDTO;
import ar.com.exercise.application.model.entity.AdvertisementEntity;
import ar.com.exercise.application.model.entity.UserEntity;
import ar.com.exercise.application.repository.AdvertisementRepository;

@Service
public class AdvertisementService {

	@Autowired
	private AdvertisementRepository repository;

	@Autowired
	private Calculate calculate;
	

	public void createAdvertisement(AdvertisementUserRequestDTO data, UserEntity user) throws Exception {

		AdvertisementEntity advertisement = new AdvertisementEntity();
		
		Long lDays = calculate.getNumberOfDatesBetweenDates(data);
		int numberOfAds = calculate.getNumberOfAds(data);
		float numberAdsDay = calculate.getNumberOfAdsPerDay(numberOfAds, lDays);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date newDate = format.parse(data.getDateEnd());
		LocalDate date = calculate.convertToLocalDateTimeViaInstant(newDate);
		advertisement.setPrice(Integer.parseInt(data.getPrice()));
		advertisement.setDateEnd(date);
		advertisement.setCreateDay(LocalDate.now());
		advertisement.setTitle(data.getTitle());
		advertisement.setDescription(data.getDescription());
		advertisement.setMaxPrice(Integer.parseInt(data.getMaxPrice()));
		advertisement.setNumberAdsDay(numberAdsDay);
		advertisement.setCreateDay(LocalDate.now());
		advertisement.setNumberAds(numberOfAds);
		advertisement.setNumberDay(toIntExact(lDays));
		advertisement.setUserId(user.getId());

		repository.save(advertisement);

	}

	public List<AdvertisementUserResponseDTO> getAds() throws Exception {

		List<AdvertisementUserResponseDTO> listAdvertisementDTO = new ArrayList<AdvertisementUserResponseDTO>();
		
		
		List<AdvertisementEntity> aList = repository.findAll();
		
		
		if (aList.size() > 3) {
			int totalPrice = calculate.sumTotalPrice(aList);
			List<Long> adsListDTO = calculate.getFinalAds(aList, totalPrice);
			this.filterById(listAdvertisementDTO, aList, adsListDTO);
		} else {
			this.returnList(listAdvertisementDTO, aList);
		}

		return listAdvertisementDTO;
	}

	public List<AdvertisementUserResponseDTO> filterById(List<AdvertisementUserResponseDTO> listAdvertisementDTO,
			List<AdvertisementEntity> aList, List<Long> adsListDTO) {
		aList.stream().filter(Objects::nonNull).filter(x -> adsListDTO.contains(x.getId())).forEach(x -> {
			AdvertisementUserResponseDTO advertisementDTO = new AdvertisementUserResponseDTO();
			advertisementDTO.setTitle(x.getTitle());
			advertisementDTO.setDescription(x.getDescription());
			advertisementDTO.setUserId(String.valueOf(x.getUserId()));
			listAdvertisementDTO.add(advertisementDTO);
		});
		return listAdvertisementDTO;
	}

	public List<AdvertisementUserResponseDTO> returnList(List<AdvertisementUserResponseDTO> listAdvertisementDTO,
			List<AdvertisementEntity> aList) {
		aList.stream().filter(Objects::nonNull).forEach(x -> {
			AdvertisementUserResponseDTO advertisementDTO = new AdvertisementUserResponseDTO();
			advertisementDTO.setTitle(x.getTitle());
			advertisementDTO.setDescription(x.getDescription());
			advertisementDTO.setUserId(String.valueOf(x.getUserId()));
			listAdvertisementDTO.add(advertisementDTO);
		});
		return listAdvertisementDTO;
	}

}
