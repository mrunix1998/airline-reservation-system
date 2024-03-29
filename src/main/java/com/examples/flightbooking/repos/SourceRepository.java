package com.examples.flightbooking.repos;

import com.examples.flightbooking.models.Source;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SourceRepository extends CrudRepository<Source, Integer> {
}
