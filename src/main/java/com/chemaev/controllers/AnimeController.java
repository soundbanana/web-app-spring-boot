package com.chemaev.controllers;

import com.chemaev.dto.UserResponseDto;
import com.chemaev.model.Anime;
import com.chemaev.repository.AnimeRepository;
import com.chemaev.service.AnimeService;
import com.chemaev.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class AnimeController {
    private final UserService userService;
    private final AnimeRepository animeRepository;
    private final AnimeService animeService;

    @GetMapping("/add_anime")
    public String signUp(Model model) {
        model.addAttribute("anime", new Anime());
        return "add_anime";
    }

    @PostMapping(value = "/anime")
    public String createAnime(@ModelAttribute Anime anime, HttpServletRequest request) {
        String currentPrincipalEmail = request.getUserPrincipal().getName();
        System.out.println(anime.toString());

        Optional<UserResponseDto> currentUser = userService.findByEmail(currentPrincipalEmail);
        Integer currentPrincipalId = currentUser.map(UserResponseDto::getId).orElse(null);

        if (currentPrincipalId != null) {
            anime.setUser(currentUser.map(UserResponseDto::toEntity).orElse(null));
            animeRepository.save(anime);
            return "add_anime_success";
        }
        return "home";
    }

    @GetMapping("/search")
    @ResponseBody
    public List<Anime> searchAnime(@RequestParam("term") String searchTerm) {
        System.out.println(searchTerm);
        return animeService.searchAnime(searchTerm);
    }
}
