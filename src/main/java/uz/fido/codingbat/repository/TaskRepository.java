package uz.fido.codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.fido.codingbat.entity.Task;
@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
}
