package com.jpa.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Turn {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Timestamp time = new Timestamp(System.currentTimeMillis());

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Person> players = new ArrayList<>();

    public Turn() {}

    public Long getId() {
        return id;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public List<Person> getPlayers() {
        return players;
    }

    public void setPlayers(List<Person> players) {
        this.players = players;
    }

    public void addPlayer(Person person) {
        this.players.add(person);
    }
}
