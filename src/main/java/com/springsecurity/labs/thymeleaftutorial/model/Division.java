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
public class Division {

    @Id
    public String divisionId;
    public String conferenceId;
    public String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conferenceId", referencedColumnName = "conferenceId", insertable = false, updatable = false)
    private Conference conference;
}
