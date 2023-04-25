package uz.fido.codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.fido.codingbat.entity.Sololearn;
@Repository
public interface SololearnRepository extends JpaRepository<Sololearn, Integer> {
}
