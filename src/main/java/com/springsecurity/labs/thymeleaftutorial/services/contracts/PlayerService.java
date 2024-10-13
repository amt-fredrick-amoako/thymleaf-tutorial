package com.springsecurity.labs.thymeleaftutorial.services.contracts;

import com.springsecurity.labs.thymeleaftutorial.model.Player;
import com.springsecurity.labs.thymeleaftutorial.model.Team;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface PlayerService {

     List<Player> players = new ArrayList<>();
     List<String> teams = new ArrayList<>();
     List<String> positions = new ArrayList<>();
     String searchString = "";
     String selectedTeam = "";
     String selectedPosition = "";
     String sortField = "Name";
     String favoriteTeam = "";

     void setPlayers(List<Player> players);
     void setSearchString(String searchString);
     void setSelectedTeam(String selectedTeam);
     void setSelectedPosition(String selectedPosition);
     void setSortField(String sortField);
     void setFavoriteTeam(String favoriteTeam);
     void setTeams(List<String> teams);
     void setPositions(List<String> positions);
     void setPlayersList(String selectedTeam,
                         String selectedPosition,
                         String searchString,
                         String sortField);

     List<Player> getPlayers();
     List<String> getTeams();
     List<String> getPositions();
     String getSelectedTeam();
     String getSelectedPosition();
     String getSortField();
     String getFavoriteTeam();
     String getSearchString();


    String playerClass(Player player);

     List<Player> getAllDummyPlayers();

     List<Player> getAllDummyPlayers(String selectedTeam, String selectedPosition, String searchString, String sortField);
}
