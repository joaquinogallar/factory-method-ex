package com.jpa.daos.imp;

import com.jpa.daos.PersonDao;
import com.jpa.entities.Address;
import com.jpa.entities.Person;
import com.jpa.entities.Turn;

import javax.persistence.EntityManager;
import java.util.List;

public class PersonDaoImp implements PersonDao {

    private EntityManager em;
    private static PersonDaoImp instace;

    private PersonDaoImp(EntityManager em) {
        this.em = em;
    }

    public static PersonDaoImp getInstance(EntityManager em) {
        if (instace == null) {
            instace = new PersonDaoImp(em);
        }
        return instace;
    }

    @Override
    public void insertPerson(Person person) {
        em.persist(person);
    }

    @Override
    public void updatePerson(Person person) {
        em.merge(person);
    }

    @Override
    public void deletePerson(Person person) {
        em.remove(em.merge(person));
    }

    @Override
    public List<Person> getPersons() {
        return em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
    }

    @Override
    public Person getPersonById(int id) {
        return em.find(Person.class, id);
    }

    public List<Person> getPersonsByTurn(Turn turn) {
        // return em.createQuery("SELECT p FROM Turn t JOIN t.players p WHERE t.id =
        // :turnId", Person.class)
        // .setParameter("turnId", turn.getId())
        // .getResultList();

        return turn.getPlayers();
    }

    @Override
    public void setTurn(Turn turn, Person person) {
        // Añadir la persona al turno
        turn.addPlayer(person);

        // Actualizar el turno en la base de datos
        em.merge(turn); // merge() se utiliza para actualizar el estado de una entidad
    }

    @Override
    public List<Person> getPersonsByCity(Address address) {
        return address.getPopulation();
    }

    @Override
    public List<Person> getMembersByTurn(Turn turn) {
        return em.createQuery("SELECT p FROM Person p JOIN Member m JOIN Turn_Person", Person.class).getResultList();
    }


}
