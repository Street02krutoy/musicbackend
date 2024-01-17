package com.srit.musicbackend.repositories;

import java.util.UUID;

import org.springframework.data.repository.Repository;

import com.srit.musicbackend.models.TrackModel;

public interface TrackRepository extends Repository<TrackModel, UUID>{
    
}
