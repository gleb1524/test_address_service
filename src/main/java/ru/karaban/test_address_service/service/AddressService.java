package ru.karaban.test_address_service.service;

import ru.karaban.test_address_service.entity.Address;
import ru.karaban.test_address_service.xml.Addresses;

import java.util.List;

public interface AddressService {

    List<Address> saveAll(Addresses elements);

    List<Address> findAllByTypeName(String typeName);

    Address findByObjectId(Long id);

}
