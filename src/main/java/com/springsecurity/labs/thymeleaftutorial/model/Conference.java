package com.springsecurity.labs.thymeleaftutorial.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Conference {

    @Id
    private String conferenceId;

    // Assuming leagueId is a foreign key column
    private String leagueId;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leagueId", insertable = false, updatable = false)
    private League league;
}
