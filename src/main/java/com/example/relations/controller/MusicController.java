package com.example.relations.controller;


import com.example.relations.repository.MusicEntityRepository;
import com.example.relations.repository.MusicRepository;
import com.example.relations.twoEntitiesOneTable.model.Music;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wei
 * @date 04.04.20
 */

@RestController
@RequiredArgsConstructor
public class MusicController {
    private final MusicEntityRepository musicEntiryRepository;
    private final MusicRepository musicRepository;

    @GetMapping( value = "/music/addMusic" )
    private void addMusic() {


        com.example.relations.twoEntitiesOneTable.Music music = com.example.relations.twoEntitiesOneTable.Music.builder().author("Wang music1").build();

        Music musicEntir = Music.builder().author("MusicEntity Wang").build();


        musicRepository.save(music);

        musicEntiryRepository.save( musicEntir);

    }

}
