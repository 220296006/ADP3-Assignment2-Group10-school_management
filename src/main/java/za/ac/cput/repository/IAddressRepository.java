package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Address;

import java.util.List;

@Repository
public interface IAddressRepository extends JpaRepository<Address,Address.AddressId> {
    List<Address> findAll();
    List<Address>findByUnitNumber(String unitNumber);
}

