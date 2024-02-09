package com.srit.musicbackend.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.srit.musicbackend.dtos.TrackDto;
import com.srit.musicbackend.services.TrackDataService;
import com.srit.musicbackend.services.TrackUploadService;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@AllArgsConstructor
@RequestMapping("/tracks")
public class TrackController {
    TrackUploadService uploadService;
    TrackDataService dataService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllTracks() {
        return dataService.getAllTracks();
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadTrack(@RequestParam("file") MultipartFile file){
        return uploadService.upload(file);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTrackInfo(@RequestBody TrackDto dto, @PathVariable("id") String id) {
        return uploadService.putData(id, dto.getName());
    }

}
