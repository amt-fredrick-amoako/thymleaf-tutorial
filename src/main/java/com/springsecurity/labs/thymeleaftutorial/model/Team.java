package com.springsecurity.labs.thymeleaftutorial.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Setter
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    @Id
    public String teamId;
    public String divisionId;
    public String location;
    public String name;
    public int  win;
    public int loss;
    public int tie;
    public int pointsFor;
    public int pointsAgainst;
    public String stadium;
    public int capacity;
    public String address;
    public String city;
    public String state;
    public String zip;
    public double latitude;
    public double longitude;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "divisionId", insertable = false, updatable = false)
    public Division division;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Player> players;
}
