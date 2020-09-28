package ar.com.exercise.application.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.exercise.application.model.entity.AdvertisementEntity;

@Repository
public interface AdvertisementRepository extends JpaRepository<AdvertisementEntity, Long> {
	
	
}
