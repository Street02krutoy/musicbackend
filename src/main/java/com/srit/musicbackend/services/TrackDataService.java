package com.srit.musicbackend.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.srit.musicbackend.repositories.TrackRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TrackDataService {

    TrackRepository trackRepo;

    public ResponseEntity<?> getAllTracks(){
        return ResponseEntity.ok(trackRepo.findAll());
    }
}
