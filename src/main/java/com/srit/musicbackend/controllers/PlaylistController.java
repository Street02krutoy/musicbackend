package com.srit.musicbackend.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.srit.musicbackend.dtos.PlaylistDto;
import com.srit.musicbackend.services.PlaylistService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@AllArgsConstructor
@RequestMapping("/playlists")
public class PlaylistController {

    PlaylistService service;

    @GetMapping("/get")
    public ResponseEntity<?> getAllPlaylists() {
        return service.getAllPlaylists();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getPlaylistById(@PathVariable("id") String id) {
        return service.getPlaylistById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createPlaylist(@RequestBody PlaylistDto.Create dto) {
        return service.createPlaylist(dto);
    }

    @PutMapping("/add/{id}")
    public ResponseEntity<?> addTracksToPlaylist(@PathVariable("id") String id, @RequestBody PlaylistDto.Update dto) {
        return service.addTracksToPlaylist(id, dto);
    }
}
