package com.srit.musicbackend.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.srit.musicbackend.dtos.PlaylistDto;
import com.srit.musicbackend.models.PlaylistModel;
import com.srit.musicbackend.models.TrackModel;
import com.srit.musicbackend.repositories.PlaylistRepository;
import com.srit.musicbackend.repositories.TrackRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PlaylistService {
    PlaylistRepository playlistRepo;
    TrackRepository trackRepo;

    private PlaylistModel getPlaylist(String id) throws BadRequestException{
        Optional<PlaylistModel> optional = playlistRepo.findById(id);
        if (!optional.isPresent()) {
            throw new BadRequestException("popa");
        }
        return optional.get();
    }

    public ResponseEntity<?> getAllPlaylists(){
        return ResponseEntity.ok(playlistRepo.findAll());
    }

    @SuppressWarnings("null")
    public ResponseEntity<?> getPlaylistById(String id){
        try {
            PlaylistModel playlist = getPlaylist(id);
            return ResponseEntity.ok(Map.of("playlist", playlist, "tracks", playlist.getTracks()));
        } catch (BadRequestException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    public ResponseEntity<?> createPlaylist(PlaylistDto.Create dto){
        PlaylistModel model = new PlaylistModel();

        model.setName(dto.getName());

        playlistRepo.save(model);

        return ResponseEntity.ok(model);
    }

    public ResponseEntity<?> addTracksToPlaylist(String id, PlaylistDto.Update dto){
        try {
            PlaylistModel playlist = getPlaylist(id);

            Set<TrackModel> tracks = playlist.getTracks();

            trackRepo.findAllById(dto.getIds()).forEach(track->{
                tracks.add(track);
            });

            playlist.setTracks(tracks);

            playlistRepo.save(playlist);

            return ResponseEntity.ok(playlist);
        } catch (BadRequestException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
