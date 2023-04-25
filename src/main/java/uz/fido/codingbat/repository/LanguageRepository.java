package uz.fido.codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.fido.codingbat.entity.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {
    boolean existsByLanguageName(String languageName);
}
