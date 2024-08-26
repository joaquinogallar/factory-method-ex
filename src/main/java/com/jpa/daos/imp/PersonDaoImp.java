package com.jpa.daos.imp;

import com.jpa.daos.PersonDao;
import com.jpa.entities.Person;

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
}
