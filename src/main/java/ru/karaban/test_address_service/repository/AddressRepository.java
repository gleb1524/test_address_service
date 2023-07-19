package ru.karaban.test_address_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.karaban.test_address_service.entity.Address;
import java.util.List;


@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{
    List<Address> findAllByTypeName(String typeName);
    Address findByObjectIdAndIsActive(Long id, Long isActive);
}
