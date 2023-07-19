package ru.karaban.test_address_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.karaban.test_address_service.entity.Hierarchy;

import java.util.List;

public interface HierarchyRepository extends JpaRepository<Hierarchy, Long> {
    List<Hierarchy> findAllByObjectAddressAndIsActive(Long id, Long isActive);
}
