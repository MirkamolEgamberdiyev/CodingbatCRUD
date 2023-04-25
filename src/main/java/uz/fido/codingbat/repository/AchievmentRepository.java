package uz.fido.codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.fido.codingbat.entity.Achievment;
@Repository
public interface AchievmentRepository extends JpaRepository<Achievment, Integer> {
    boolean existsByName(String name);
}
