package com.udea.testing.program1.statisticsServiceConsumer.model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticsRepository extends MongoRepository<NumberSet, String> {
}
