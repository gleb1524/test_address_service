package ru.karaban.test_address_service.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.karaban.test_address_service.entity.Address;
import ru.karaban.test_address_service.entity.Hierarchy;
import ru.karaban.test_address_service.repository.HierarchyRepository;
import ru.karaban.test_address_service.service.AddressService;
import ru.karaban.test_address_service.service.HierarchyService;
import ru.karaban.test_address_service.xml.Hierarchys;
import ru.karaban.test_address_service.xml.attribute.HierarchyXml;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HierarchyServiceImpl implements HierarchyService {

    private final HierarchyRepository repository;
    private final AddressService addressService;

    @Override
    public List<Hierarchy> saveAll(Hierarchys elements) {
        List<HierarchyXml> hierarchyXmlList = elements.getHierarchyXmls();
        List<Hierarchy> hierarchies = hierarchyXmlList.stream().map(hierarchyXml -> Hierarchy.builder()
                .id(hierarchyXml.getID())
                .objectAddress(hierarchyXml.getOBJECTID())
                .parentObjectAddress(hierarchyXml.getPARENTOBJID())
                .startDate(hierarchyXml.getSTARTDATE())
                .endDate(hierarchyXml.getENDDATE())
                .isActive(hierarchyXml.getISACTIVE())
                .build()
        ).toList();
        return repository.saveAll(hierarchies);
    }


    public List<String> findAllByTypeName(String typeName) {
        List<Address> allByTypeName = addressService.findAllByTypeName(typeName);
        List<List<Address>> result = new ArrayList<>();
        List<String> string = new ArrayList<>();

        for (Address address : allByTypeName) {
            List<Address> addresses = new ArrayList<>();
            List<Hierarchy> allAddresses = findAllAddresses(address.getObjectId());
                for (Hierarchy hierarchy : allAddresses) {
                    addresses.add(addressService.findByObjectId(hierarchy.getObjectAddress()));
            }
            result.add(addresses);
        }
        for (List<Address> addresses : result) {
            StringBuilder sb = new StringBuilder();
            for (int i = addresses.size() - 1; i >= 0; i--) {
                Address address = addresses.get(i);
                sb.append(String.format("%s %s,",address.getTypeName(), address.getName()));
                sb.append(" ");
            }
            string.add(sb.toString());
        }
        return string;
    }

    private List<Hierarchy> findAllAddresses(Long id) {
        List<Hierarchy> hierarchyList = new ArrayList<>();
        return findAll(id, hierarchyList);
    }

    private List<Hierarchy> findAll(Long id, List<Hierarchy> result) {

        List<Hierarchy> list = repository.findAllByObjectAddressAndIsActive(id, 1L);
        for (Hierarchy hierarchy : list) {
            result.add(hierarchy);
            findAll(hierarchy.getParentObjectAddress(), result);
            if(hierarchy.getParentObjectAddress()==0) break;
        }
        return result;
    }
}
