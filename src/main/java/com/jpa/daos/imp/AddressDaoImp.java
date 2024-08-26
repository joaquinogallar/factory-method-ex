package com.jpa.daos.imp;

import com.jpa.daos.AddressDao;
import com.jpa.entities.Address;

import javax.persistence.EntityManager;
import java.util.List;

public class AddressDaoImp implements AddressDao {

    private EntityManager em;
    private static AddressDaoImp instance;

    private AddressDaoImp(EntityManager em) {
        this.em = em;
    }

    public static AddressDaoImp getInstance(EntityManager em) {
        if(instance == null) {
            instance = new AddressDaoImp(em);
        }
        return instance;
    }

    @Override
    public void insertAddress(Address address) {
        em.persist(address);
    }

    @Override
    public void updateAddress(Address address) {
        em.merge(address);
    }

    @Override
    public void deleteAddress(Address address) {
        em.remove(address);
    }

    @Override
    public List<Address> getAddresses() {
        return em.createQuery("SELECT a FROM Address a", Address.class).getResultList();
    }

    @Override
    public Address getAddressById(int id) {
        return em.find(Address.class, id);
    }
}
