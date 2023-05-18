package com.chemaev.controllers;

import com.chemaev.dto.CreateUserRequestDto;
import com.chemaev.dto.UserResponseDto;
import com.chemaev.model.Anime;
import com.chemaev.repository.AnimeRepository;
import com.chemaev.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class MainController {

    private final UserService userService;
    private final AnimeRepository animeRepository;

    @GetMapping("/home")
    public String home(Model model, HttpServletRequest request) {
        if (request.getUserPrincipal() != null){
            String currentPrincipalEmail = request.getUserPrincipal().getName();

            Optional<UserResponseDto> currentUser = userService.findByEmail(currentPrincipalEmail);
            Integer currentPrincipalId = currentUser.map(UserResponseDto::getId).orElse(null);

            if (currentPrincipalId != null) {
                List<Anime> animes = animeRepository.findAllByUserId(currentPrincipalId);
                model.addAttribute("animes", animes);
            }
        }
        return "home";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/sign_up")
    public String signUp(Model model) {
        model.addAttribute("user", new CreateUserRequestDto());
        return "sign_up";
    }
}