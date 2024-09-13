package com.jpa.daos;

import com.jpa.dtos.PersonDTO;
import com.jpa.entities.Address;
import com.jpa.entities.Person;
import com.jpa.entities.Turn;

import java.util.List;

public interface PersonDao {
    public void insertPerson(Person person);

    public void updatePerson(Person person);

    public void deletePerson(Person person);

    public List<Person> getPersons();

    public Person getPersonById(Long id);

    public void setTurn(Long idPerson, Turn turn);

    public List<Person> getPersonsByTurn(Long id);

    public List<Person> getPersonsByCity(String city);

    public List<PersonDTO> getMemberPersonsByTurn(Long id);
}
