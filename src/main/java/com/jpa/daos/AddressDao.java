package com.jpa.daos;

import com.jpa.entities.Address;

import java.util.List;

public interface AddressDao {
    public void insertAddress(Address address);
    public void updateAddress(Address address);
    public void deleteAddress(int id);
    public List<Address> getAddresses();
    public Address getAddressById(int id);
}
