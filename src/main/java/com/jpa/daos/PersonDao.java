package com.jpa.daos;

import com.jpa.entities.Address;
import com.jpa.entities.Person;
import com.jpa.entities.Turn;

import java.util.List;

public interface PersonDao {
    public void insertPerson(Person person);

    public void updatePerson(Person person);

    public void deletePerson(Person person);

    public List<Person> getPersons();

    public Person getPersonById(int id);

    public void setTurn(Turn turn, Person person);

    public List<Person> getPersonsByCity(Address address);

    public List<Person> getMembersByTurn(Turn turn);
}
