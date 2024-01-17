package com.srit.musicbackend.dtos;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrackDto {
    private UUID id;

    private String name;
    private int duration;

    private String url;
}
