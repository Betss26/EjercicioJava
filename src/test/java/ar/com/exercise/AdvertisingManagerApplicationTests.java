package ar.com.exercise;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import ar.com.exercise.application.endpoint.AdvertisementEndPoint;
import ar.com.exercise.application.model.entity.AdvertisementEntity;
import ar.com.exercise.application.model.entity.UserEntity;
import ar.com.exercise.application.repository.AdvertisementRepository;
import ar.com.exercise.application.service.AdvertisementService;
import ar.com.exercise.application.service.UserService;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { AdvertisementEndPoint.class, AdvertisementService.class,
		AdvertisementRepository.class, AdvertisementEntity.class, UserEntity.class, UserService.class })
class AdvertisingManagerApplicationTests {

	@Test
	public void saveAds() throws ParseException {

		AdvertisementEntity entity = new AdvertisementEntity();
		entity.setTitle("");
		entity.setDescription("Descripcion");

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date newDate = format.parse("2020-09-23");
		LocalDate date = convertToLocalDateTimeViaInstant(newDate);
		entity.setDateEnd(date);

		entity.setMaxPrice(1000);
		entity.setUserId((long) 2);
		entity.setCreateDay(LocalDate.now());

		assertThat(entity.getMaxPrice()).isNotNull();
	}

	public LocalDate convertToLocalDateTimeViaInstant(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	@Test
	public void saveUser() {
		UserEntity user = new UserEntity();

		user.setAge(23);
		user.setCountry("Argentina");
		user.setGender("famale");

		assertThat(user.getAge()).isNotNull();

	}

}
