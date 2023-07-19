package ru.karaban.test_address_service.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.karaban.test_address_service.entity.Address;
import ru.karaban.test_address_service.repository.AddressRepository;
import ru.karaban.test_address_service.service.AddressService;
import ru.karaban.test_address_service.xml.attribute.AddressXml;
import ru.karaban.test_address_service.xml.Addresses;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository repository;

    @Override
    public List<Address> saveAll(Addresses elements) {
        List<AddressXml> addressList = elements.getAddressXmls();
        List<Address> addresses = addressList.stream().map(address -> Address.builder()
                .id(address.getID())
                .objectId(address.getOBJECTID())
                .name(address.getNAME())
                .typeName(address.getTYPENAME())
                .startDate(address.getSTARTDATE())
                .endDate(address.getENDDATE())
                .isActive(address.getISACTIVE())
                .isActual(address.getISACTUAL())
                .build()
        ).toList();
       return repository.saveAll(addresses);
    }

    @Override
    public List<Address> findAllByTypeName(String typeName) {
        return repository.findAllByTypeName(typeName);
    }

    @Override
    public Address findByObjectId(Long id) {
        return repository.findByObjectIdAndIsActive(id, 1L);
    }
}
