package com.srit.musicbackend.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.srit.musicbackend.dtos.TrackDto;
import com.srit.musicbackend.services.TrackDataService;
import com.srit.musicbackend.services.TrackUploadService;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@AllArgsConstructor
public class TrackController {
    
    TrackUploadService uploadService;
    TrackDataService dataService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllTracks() {
        return dataService.getAllTracks();
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadTrack(@RequestParam("file") MultipartFile file, @RequestParam("name") String name){
        return uploadService.upload(file, name);
    }

}
