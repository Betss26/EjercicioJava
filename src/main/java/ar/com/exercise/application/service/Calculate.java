package ar.com.exercise.application.service;

import static java.lang.Math.toIntExact;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import ar.com.exercise.application.model.dto.AdvertisementUserRequestDTO;
import ar.com.exercise.application.model.entity.AdvertisementEntity;

@Component
public class Calculate {

	public List<Long> getFinalAds(List<AdvertisementEntity> aList, int totalPrice) throws Exception {

		List<Long> listId = new ArrayList<Long>();
		do {
			for (AdvertisementEntity item : aList) {
				double percentage = calculatePorcentage(item.getPrice(), totalPrice);
				int id = findRandom(percentage, item.getId());
				if (id != 0) {
					listId.add((long) id);
				}
			}
		} while (listId.size() < 3);
		
		return listId;

	}

	public int sumTotalPrice(List<AdvertisementEntity> aList) {
		int totalPrice = 0;
		for (AdvertisementEntity advertisementEntity : aList) {
			totalPrice += advertisementEntity.getPrice();
		}
		return totalPrice;
	}

	public float calculatePorcentage(int price, int totalPrice) throws Exception {
		float percentage = 0;
		if (totalPrice != 0) {
			percentage = (float) price / totalPrice;
			return percentage;
		}
		return percentage;
	}

	
	public long getNumberOfDatesBetweenDates(AdvertisementUserRequestDTO data) throws ParseException {
		LocalDate actualDate = LocalDate.now();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(data.getDateEnd());
		LocalDate endDate = convertToLocalDateTimeViaInstant(date);
		long lDays = ChronoUnit.DAYS.between(actualDate, endDate);
		return lDays;

	}

	public int getNumberOfAds(AdvertisementUserRequestDTO data) throws Exception {

		int maxPrice = Integer.parseInt(data.getMaxPrice());
		int unitPrice = Integer.parseInt(data.getPrice());
		int numberOfAds = maxPrice / unitPrice;

		return numberOfAds;
	}
	public float getNumberOfAdsPerDay(int numberOfAds, Long lDays) {
		int numberAdsDay= 0;
		int days = toIntExact(lDays);
		
		if (numberOfAds >= days && days != 0) {
			numberAdsDay = numberOfAds / days;
		}
		return numberAdsDay;
	}

	public LocalDate convertToLocalDateTimeViaInstant(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public int findRandom(double percentage, Long id) throws Exception {
		int max = 50;
		int num = toIntExact(id);
		Random r = new Random();
		double x;
		int randN = r.nextInt(max) + 1;
		x = max * percentage;
		
		if (randN <= x) {
			return num;
		} else {
			return 0;
		}
	}
}
