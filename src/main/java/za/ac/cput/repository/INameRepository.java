package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Name;

import java.util.List;
import java.util.Set;

@Repository
public interface INameRepository extends JpaRepository<Name,Name.NameId> {
    List<Name> findAll();
    List<Name>findByFirstName(String firstName);
}

