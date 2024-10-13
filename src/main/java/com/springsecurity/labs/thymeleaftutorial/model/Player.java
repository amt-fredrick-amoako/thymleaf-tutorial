package com.springsecurity.labs.thymeleaftutorial.model;

import jakarta.persistence.*;
import lombok.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Comparator;

@Setter
@Getter
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Player {
    @Id
    public String playerId;
    public String teamId;
    public Integer number;
    public String position;
    public String name;
    public Integer height;
    public Integer weight;
    public Integer age;
    public LocalDate birthDate;
    public String experience;
    public Integer draftYear;
    public Integer draftRound;
    public Integer draftPick;
    public String college;
    public String state;
    public Integer rank;
    public Integer rating;
    public Integer depth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teamId", insertable = false, updatable = false)
    public Team team;

    public static Comparator<Player> getPlayerNameComparator() {
        return new PlayerNameComparator();
    }

    public static Comparator<Player> getPlayerPositionComparator() {
        return new PlayerPositionComparator();
    }

    public static Comparator<Player> getPlayerNumberComparator() {
        return new PlayerNumberComparator();
    }

    public static Comparator<Player> getPlayerTeamComparator() {
        return Comparator.comparing(Player::getTeamId);
    }

    private static class PlayerNameComparator implements Comparator<Player> {

        @Override
        public int compare(Player o1, Player o2) {
           return o1.name.compareTo(o2.name);
        }
    }

    private static class PlayerNumberComparator implements Comparator<Player> {

        @Override
        public int compare(Player o1, Player o2) {
            return o1.number - o2.number;
        }
    }

    private static class PlayerPositionComparator implements Comparator<Player> {

        @Override
        public int compare(Player o1, Player o2) {
           return o1.position.compareTo(o2.position);
        }
    }
}
