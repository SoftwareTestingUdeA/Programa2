package com.udea.testing.program1.statisticsAPI.model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticsRepository extends MongoRepository<NumberSet, String> {

}
