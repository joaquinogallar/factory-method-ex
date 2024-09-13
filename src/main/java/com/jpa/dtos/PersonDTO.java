package com.jpa.dtos;

import com.jpa.entities.Address;

import javax.persistence.*;
import java.io.Serializable;

public class PersonDTO implements Serializable {

    private String name;
    private String surname;
    private int age;
    private Address address;
    private boolean isMember;

    public PersonDTO(String name, String surname, int age, Address address, boolean isMember) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
        this.isMember = isMember;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isMember() {
        return isMember;
    }

    public void setMember(boolean member) {
        isMember = member;
    }
}
