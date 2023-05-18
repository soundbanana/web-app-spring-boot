package com.chemaev.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity(name = "anime")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String title;
    @Column(length = 1000)
    private String description;
    private String pictureLink;
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties(value = {"animeList", "hibernateLazyInitializer", "handler"}, allowSetters = true)
    @JsonManagedReference
    @JoinColumn(name = "user_id")
    private User user;
}
