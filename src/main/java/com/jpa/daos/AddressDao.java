package com.jpa.daos;

import com.jpa.entities.Address;

import java.util.List;

public interface AddressDao {
    public void insertAddress(Address address);

    public void updateAddress(Address address);

    public void deleteAddress(Address address);

    public List<Address> getAddresses();

    public Address getAddressById(Long id);

    public Address getAddressesByCity(String cityName);
}
