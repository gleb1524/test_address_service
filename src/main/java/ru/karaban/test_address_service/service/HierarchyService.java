package ru.karaban.test_address_service.service;

import ru.karaban.test_address_service.entity.Hierarchy;
import ru.karaban.test_address_service.xml.Hierarchys;

import java.util.List;

public interface HierarchyService {

    List<Hierarchy> saveAll(Hierarchys elements);
}
