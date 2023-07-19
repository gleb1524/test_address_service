package ru.karaban.test_address_service.service;

import ru.karaban.test_address_service.entity.Address;
import ru.karaban.test_address_service.xml.Addresses;

import java.time.LocalDate;
import java.util.List;

public interface AddressService {

    List<Address> saveAll(Addresses elements);

    List<Address> findAllByTypeName(String typeName);

    Address findByObjectId(Long id);

    List<Address> getAllAddressByDateAndObjectId(List<Long> ids, LocalDate date);

    List<Address> findAllByObjectId(List<Long> ids);
}
