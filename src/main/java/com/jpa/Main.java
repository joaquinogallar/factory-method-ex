package com.jpa;

import com.jpa.entities.Address;
import com.jpa.entities.Person;
import com.jpa.entities.Turn;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my_factory_ex");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Address a = new Address("1475 Luck Hoof Avenue", "Los Angeles");
        entityManager.persist(a);

        Person bojack = new Person("Bojack", "Horseman", 20, a);
        Person pCarolyn = new Person("Princess", "Carolyn", 20, a);
        entityManager.persist(bojack);
        entityManager.persist(pCarolyn);

        Turn t = new Turn();
        t.addPlayer(bojack);
        t.addPlayer(pCarolyn);
        entityManager.persist(t);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

    }
}