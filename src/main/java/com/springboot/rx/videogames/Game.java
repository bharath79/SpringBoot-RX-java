package com.springboot.rx.videogames;


import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Game {
    private String name;
    private double price;
    private int storage;
}
