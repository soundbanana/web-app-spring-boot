package com.chemaev.service.impl;

import com.chemaev.model.Anime;
import com.chemaev.repository.AnimeRepository;
import com.chemaev.service.AnimeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeServiceImpl implements AnimeService {

    private final AnimeRepository animeRepository;

    public AnimeServiceImpl(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public List<Anime> searchAnime(String searchText) {
        return animeRepository.findByTitleContainingIgnoreCase(searchText);
    }
}
