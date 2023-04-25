package uz.fido.codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.fido.codingbat.entity.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
}
