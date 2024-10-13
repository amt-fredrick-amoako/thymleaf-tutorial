package com.springsecurity.labs.thymeleaftutorial.controller;

import com.springsecurity.labs.thymeleaftutorial.model.Player;
import com.springsecurity.labs.thymeleaftutorial.services.contracts.PlayerService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Stream;

@Controller
public class PlayersController {
    PlayerService playerService;

    public PlayersController(PlayerService playerService) {
       this.playerService = playerService;
    }

    List<Player> players;

    @GetMapping("players")
    public String players(Model model,
                          @Param("selectedTeam") String selectedTeam,
                          @Param("selectedPosition") String selectedPosition,
                          @Param("searchString") String searchString,
                          @Param("sortField") String sortField
    ) {
        playerService.setPlayersList(selectedTeam, selectedPosition, searchString, sortField);
        players = playerService.getPlayers();
        model.addAttribute("players", players);
        model.addAttribute("playerService", playerService);
        return "players/index";
    }

    @GetMapping("player/details/{id}")
    public String playerDetails(Model model, @PathVariable String id) {

       //selectedTeam=&selectedPosition=&searchString=&sortField=Number/
//        players = playerService.getAllDummyPlayers(selectedTeam, selectedPosition, searchString, sortField);
        var playerOptional = players.stream().filter(player -> player.getPlayerId().equals(id)).findFirst();
        model.addAttribute("player", playerOptional.orElse(null));
        return "players/player";
    }
}
