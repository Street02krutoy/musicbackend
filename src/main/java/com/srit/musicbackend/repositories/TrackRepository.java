package com.srit.musicbackend.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srit.musicbackend.models.TrackModel;


@Repository
public interface TrackRepository extends JpaRepository<TrackModel, String>{
    
}
