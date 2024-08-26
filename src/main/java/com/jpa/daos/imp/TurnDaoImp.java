package com.jpa.daos.imp;

import com.jpa.daos.TurnDao;
import com.jpa.entities.Turn;

import javax.persistence.EntityManager;
import java.util.List;

public class TurnDaoImp implements TurnDao {

    private EntityManager em;
    private static TurnDaoImp instance;

    private TurnDaoImp(EntityManager em) {
        this.em = em;
    }

    public static TurnDaoImp getInstance(EntityManager em) {
        if (instance == null) {
            instance = new TurnDaoImp(em);
        }
        return instance;
    }

    @Override
    public void insertTurn(Turn turn) {
        em.persist(turn);
    }

    @Override
    public void updateTurn(Turn turn) {
        em.merge(turn);
    }

    @Override
    public void deleteTurn(Turn turn) {
        em.remove(turn);
    }

    @Override
    public List<Turn> getAllTurns() {
        return em.createQuery("SELECT t FROM Turn t", Turn.class).getResultList();
    }

    @Override
    public Turn getTurnById(int id) {
        return em.find(Turn.class, id);
    }
}
