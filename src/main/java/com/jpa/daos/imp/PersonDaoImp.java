package com.jpa.daos.imp;

import com.jpa.daos.AddressDao;
import com.jpa.daos.PersonDao;
import com.jpa.daos.TurnDao;
import com.jpa.dtos.PersonDTO;
import com.jpa.entities.Address;
import com.jpa.entities.Person;
import com.jpa.entities.Turn;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoImp implements PersonDao {

    private EntityManager em;
    private static PersonDao instace;

    private PersonDaoImp(EntityManager em) {
        this.em = em;
    }

    public static PersonDao getInstance(EntityManager em) {
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
    public Person getPersonById(Long id) {
        return em.find(Person.class, id);
    }

    @Override
    public List<Person> getPersonsByTurn(Long id) {
        return em.createQuery("SELECT p FROM Turn t JOIN t.players p WHERE t.id = :turnId", Person.class)
        .setParameter("turnId", id)
        .getResultList();
    }

    @Override
    public void setTurn(Long idPerson, Turn turn) {
        turn.addPlayer(getPersonById(idPerson));

        em.merge(turn); // merge() actualiza el estado de una entidad
    }

    @Override
    public List<Person> getPersonsByCity(String city) {
        return em.createQuery("SELECT p FROM Person p JOIN p.address a WHERE a.city = :cityName", Person.class)
                .setParameter("cityName", city)
                .getResultList();
    }

    @Override
    public List<PersonDTO> getMemberPersonsByTurn(Long id) {
        List<Person> persons = em.createQuery("SELECT p FROM Turn t JOIN t.players p JOIN Member m WHERE t.id = :turnId AND p.id = m.person.id", Person.class)
                .setParameter("turnId", id)
                .getResultList();

        List<PersonDTO> result = new ArrayList<>();
        persons.forEach(p -> {
            PersonDTO dto = new PersonDTO(p.getName(), p.getSurname(), p.getAge(), p.getAddress(), true);
            result.add(dto);
        });

        return result;
    }


}
