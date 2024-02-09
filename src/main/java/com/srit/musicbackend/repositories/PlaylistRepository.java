package com.srit.musicbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srit.musicbackend.models.PlaylistModel;


@Repository
public interface PlaylistRepository extends JpaRepository<PlaylistModel, String>{
    
}
