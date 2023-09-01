package com.example.demo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class User {
    private String id;
    private String nickname;
    private int inGameId;
}
