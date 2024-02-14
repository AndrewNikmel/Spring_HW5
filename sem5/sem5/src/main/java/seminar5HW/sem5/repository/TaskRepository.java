package seminar5HW.sem5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import seminar5HW.sem5.module.Task;
import seminar5HW.sem5.module.TaskStatus;


import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> getTaskByStatus(TaskStatus status);
    @Modifying
    @Query("update Task f set f.shortDesc = ?1, f.description = ?2, f.status = ?3 where f.id = ?4")
    void updateTaskById(String shortDesc, String description, TaskStatus status, Long id);

}