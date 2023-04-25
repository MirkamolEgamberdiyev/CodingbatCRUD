package uz.fido.codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.fido.codingbat.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
