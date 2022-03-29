package com.examples.flightbooking.services;

import com.examples.flightbooking.models.Destination;
import com.examples.flightbooking.utils.Util;
import com.examples.flightbooking.repos.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DestinationService
{
    private final DestinationRepository destinationRepository;

    @Autowired
    public DestinationService(final DestinationRepository destinationRepository)
    {
        this.destinationRepository = destinationRepository;
    }

    public Destination getDestinationById(Integer destinationId) throws IllegalArgumentException
    {
        if(Util.validateNumber(destinationId))
        {
            Optional<Destination> destination = destinationRepository.findById(destinationId);
            return destination.isPresent() ? destination.get() : null;
        }
        return null;
    }

    public Destination addDestination(Destination destination) throws IllegalArgumentException
    {
        if(Util.validateDestination(destination))
        {
            return destinationRepository.save(destination);
        }
        return null;
    }
}
