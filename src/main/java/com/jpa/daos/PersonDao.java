package com.jpa.daos;

import com.jpa.entities.Person;

import java.util.List;

public interface PersonDao {
    public void insertPerson(Person person);
    public void updatePerson(Person person);
    public void deletePerson(Person person);
    public List<Person> getPersons();
    public Person getPersonById(int id);
}
