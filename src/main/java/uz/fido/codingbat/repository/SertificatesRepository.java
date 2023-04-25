package uz.fido.codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.fido.codingbat.entity.Sertificates;

@Repository
public interface SertificatesRepository extends JpaRepository<Sertificates, Integer> {
    boolean existsByName(String sertificates_name);
}
