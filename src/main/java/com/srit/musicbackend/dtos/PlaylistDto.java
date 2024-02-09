package com.srit.musicbackend.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class PlaylistDto {

    @Getter
    @Setter
    public static class Create {
        public String name;
    }

    @Getter
    @Setter
    public static class Update{
        public List<String> ids;
    }
}
