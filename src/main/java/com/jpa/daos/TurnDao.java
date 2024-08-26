package com.jpa.daos;

import com.jpa.entities.Turn;

import java.util.List;

public interface TurnDao {
    public void insertTurn(Turn turn);
    public void updateTurn(Turn turn);
    public void deleteTurn(Turn turn);
    public List<Turn> getAllTurns();
    public Turn getTurnById(int id);
}
