package com.srit.musicbackend.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.sql.rowset.serial.SerialBlob;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.srit.musicbackend.models.TrackModel;
import com.srit.musicbackend.repositories.TrackRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TrackUploadService {

    TrackRepository trackRepo;

    public ResponseEntity<?> upload(MultipartFile file){
        TrackModel track = new TrackModel();

        track.setId(UUID.randomUUID().toString());

        track.setName("Unnamed");

        File convFile = new File("src/main/resources/static/"+track.getId()+".mp3");

        track.setUrl("/uploads/"+convFile.getName());

        

        try {
            convFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(file.getBytes());
            fos.close();

            track.setDuration(
                AudioFileIO.read(convFile).getAudioHeader().getTrackLength()
                );
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("status", "Internal Server Error"));
        }
        

        trackRepo.save(track);

        return ResponseEntity.ok(track);
    }

    public ResponseEntity<?> putData(String id, String name){
        Optional<TrackModel> oModel = trackRepo.findById(id);

        if(!oModel.isPresent()) return ResponseEntity.status(404).body(Map.of("error", "Not Found")); 

        TrackModel model = oModel.get();

        model.setName(name);
        //TODO add some fields like author
        
        trackRepo.save(model);

        return ResponseEntity.ok().body(model);
    }
}
