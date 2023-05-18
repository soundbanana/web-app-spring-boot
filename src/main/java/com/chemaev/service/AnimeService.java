package com.chemaev.service;

import com.chemaev.model.Anime;

import java.util.List;

public interface AnimeService {
    List<Anime> searchAnime(String searchText);
}
