package uz.fido.codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.fido.codingbat.entity.Quiz;
@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {
    boolean existsByName(String name);
}
