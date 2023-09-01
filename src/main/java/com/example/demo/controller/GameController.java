package com.example.demo.controller;


import com.example.demo.Game;
import com.example.demo.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GameController {
    @GetMapping("/games")
    public String enterHome(){
        System.out.println("??????????????????");
        return "home";
    }
    @PostMapping("/")
    public String makeGame(){

        return "game";
    }
}
