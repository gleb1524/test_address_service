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
        List<HierarchyXml> hierarchyXmls = elements.getHierarchyXmls();
        List<Hierarchy> hierarchies = hierarchyXmls.stream().map(hierarchyXml -> Hierarchy.builder()
                .id(hierarchyXml.getID())
                .objectId(hierarchyXml.getOBJECTID())
                .parentId(hierarchyXml.getPARENTOBJID())
                .startDate(hierarchyXml.getSTARTDATE())
                .endDate(hierarchyXml.getENDDATE())
                .isActive(hierarchyXml.getISACTIVE())
                .build()
        ).toList();
        return repository.saveAll(hierarchies);
    }

@Override
    public List<String> findAllByTypeName(String typeName) {

        List<Address> allByTypeName = addressService.findAllByTypeName(typeName);
        List<List<Address>> result = getAddresses(allByTypeName);
        return buildResponseMessage(result);
    }

    private List<List<Address>> getAddresses(List<Address> allByTypeName) {

        List<List<Address>> result = new ArrayList<>();
        for (Address address : allByTypeName) {
            List<Address> addresses = new ArrayList<>();
            List<Long> objectIds = findAllAddresses(address.getObjectId()).stream().map(Hierarchy::getObjectId).toList();
            addresses.addAll(addressService.findAllByObjectId(objectIds));
            result.add(addresses);
        }
        return result;
    }

    private List<String> buildResponseMessage(List<List<Address>> result) {
        List<String> string = new ArrayList<>();
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

        List<Hierarchy> list = repository.findAllByObjectIdAndIsActive(id, 1L);
        for (Hierarchy hierarchy : list) {
            result.add(hierarchy);
            findAll(hierarchy.getParentId(), result);
            if(hierarchy.getParentId()==0) break;
        }
        return result;
    }
}
