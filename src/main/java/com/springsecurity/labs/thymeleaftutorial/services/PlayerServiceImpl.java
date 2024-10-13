package com.springsecurity.labs.thymeleaftutorial.services;

import com.springsecurity.labs.thymeleaftutorial.model.Player;
import com.springsecurity.labs.thymeleaftutorial.model.Team;
import com.springsecurity.labs.thymeleaftutorial.repositories.PlayerRepository;
import com.springsecurity.labs.thymeleaftutorial.repositories.TeamRepository;
import com.springsecurity.labs.thymeleaftutorial.services.contracts.PlayerService;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@Service
@Scope("singleton")
public class PlayerServiceImpl implements PlayerService {

    private List<Player> players;
    private String searchString;
    private String selectedTeam;
    private String selectedPosition;
    private String sortField = "Name";
    private String favoriteTeam;
    private List<String> teams;
    private List<String> positions;
    private final PlayerRepository repository;
    private final TeamRepository teamRepository;

    public PlayerServiceImpl(PlayerRepository repository, TeamRepository teamRepository) {
       this.repository = repository;
       this.teamRepository = teamRepository;
    }

    public void setPlayersList(String selectedTeam,
                               String selectedPosition,
                               String searchString,
                               String sortField){

        this.selectedTeam = selectedTeam;
        this.selectedPosition=selectedPosition;
        this.searchString = searchString;
        this.sortField = sortField == null || sortField.isEmpty() ? "Name" : sortField;

        var players = repository.findAll();

        if(this.searchString != null && !this.searchString.isEmpty()){
            players = players.stream()
                    .filter(player -> player.getName().contains(searchString))
                    .toList();
        }

        if(this.selectedTeam != null && !this.selectedTeam.isEmpty()){
            players = players.stream()
                    .filter(player -> player.getTeamId().equals(selectedTeam))
                    .toList();
        }

        if(this.selectedPosition != null && !this.selectedPosition.isEmpty()){
            players = players.stream()
                    .filter(player -> player.getPosition().equals(selectedPosition))
                    .toList();
        }

        switch (this.sortField){
            case "Number" :
                players = players.stream()
                        .sorted(Player.getPlayerNumberComparator().thenComparing(Player.getPlayerTeamComparator()))
                        .toList();
                break;
            case "Name":
                players = players.stream()
                        .sorted(Player.getPlayerNameComparator().thenComparing(Player.getPlayerTeamComparator()))
                        .toList();
            case "Position":
                players = players.stream()
                        .sorted(Player.getPlayerPositionComparator().thenComparing(Player.getPlayerTeamComparator()))
                        .toList();
        }

        var teamQuery = teamRepository.findAll().stream()
                .map(Team::getTeamId)
                .toList();

        var positionQuery = players.stream()
                .map(Player::getPosition)
                .toList();

        this.teams = teamQuery;
        this.positions = positionQuery;
        this.players = players;
    }

    public List<Player> getAllDummyPlayers(){
         return new ArrayList<>(List.of(Player.builder()
                .playerId("wsh59")
                .teamId("dal")
                .position("WR")
                .name("Devin Funchess")
                .number(17)
                .height(76)
                .weight(232)
                .age(25)
                .birthDate(LocalDate.of(1994, 5, 21))
                .experience("5th season")
                .draftYear(2015)
                .draftRound(2)
                .draftPick(41)
                .college("Michigan")
                .rank(45)
                .rating(81)
                .depth(2)
                .build()));
    }

    @Override
    public List<Player> getAllDummyPlayers(String selectedTeam, String selectedPosition, String searchString, String sortField) {
        return List.of();
    }

    @Override
    public String playerClass(Player player) {
        String style = "d-flex";
        if (player.depth != null && player.depth == 1 )
            style += " starter";
        if (player.teamId.equals(favoriteTeam))
            style += " favorite";
        return style;
    }
}
