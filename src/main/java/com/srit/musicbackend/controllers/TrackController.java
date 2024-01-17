package com.srit.musicbackend.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.srit.musicbackend.services.TrackDataService;
import com.srit.musicbackend.services.TrackUploadService;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@AllArgsConstructor
public class TrackController {
    
    TrackUploadService uploadService;
    TrackDataService dataService;

@GetMapping("/get")
public ResponseEntity<?> getMethodName() {
    return dataService.getAllTracks();
}


}
