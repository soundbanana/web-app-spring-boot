package com.chemaev.repository;

import com.chemaev.model.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Integer> {
    List<Anime> findAllByUserId(Integer id);

    List<Anime> findByTitleContainingIgnoreCase(String searchTerm);
}
