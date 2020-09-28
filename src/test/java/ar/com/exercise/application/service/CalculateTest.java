package ar.com.exercise.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import ar.com.exercise.application.model.dto.AdvertisementUserRequestDTO;
import ar.com.exercise.application.model.entity.AdvertisementEntity;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {Calculate.class} )
public class CalculateTest {

	@Autowired
	Calculate calculate;
	
	
	@Test
	public void testGetFinalAds() throws Exception {
		Calculate calculate = new Calculate();
		List<AdvertisementEntity> aList = new ArrayList<AdvertisementEntity>();
		AdvertisementEntity entity = new AdvertisementEntity();
		entity.setPrice(200);
		entity.setId((long) 1);
		aList.add(entity);
		
		int totalPrice = 200;
		
		List<Long> resultadoReal = calculate.getFinalAds(aList, totalPrice);
		
		List<Long> resultadoEsperado = new ArrayList<>();
		resultadoEsperado.add((long) 1);
		
		assertEquals(resultadoReal, resultadoEsperado);
		
	}

	@Test
	public void testCalculatePorcentage() throws Exception {
		Calculate calculate = new Calculate();
		float resultadoReal = calculate.calculatePorcentage(200, 1000);
		float resultadoEsperado = 0.2f;
		assertEquals(resultadoEsperado, resultadoReal);
	}
	
	@Test
	public void testCalculatePorcentageWithCero() throws Exception {
		Calculate calculate = new Calculate();
		float resultadoReal = calculate.calculatePorcentage(200, 0);
		float resultadoEsperado = 0;
		assertEquals(resultadoEsperado, resultadoReal);
	}
	
	@Test
	public void testGetNumberOfDatesBetweenDates() throws Exception {
		Calculate calculate = new Calculate();
		AdvertisementUserRequestDTO data = new AdvertisementUserRequestDTO();
		data.setDateEnd("2020-10-26");
		int resultadoReal = (int) calculate.getNumberOfDatesBetweenDates(data);
		int resultadoEsperado = 30;
		assertEquals(resultadoEsperado, resultadoReal);
	}

}
