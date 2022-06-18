package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.City;

import java.util.List;


@Repository
public interface ICityRepository extends JpaRepository<City,String> {

}
