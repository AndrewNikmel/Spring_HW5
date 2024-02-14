package seminar5HW.sem5.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seminar5HW.sem5.module.Task;
import seminar5HW.sem5.module.TaskStatus;
import seminar5HW.sem5.repository.TaskRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    public Task add(Task task) {
        return taskRepository.save(task);
    }
    public List<Task> findAll() {
        return taskRepository.findAll();
    }
    public List<Task> getTaskByStatus(TaskStatus status) {
        return taskRepository.getTaskByStatus(status);
    }
    @Transactional
    public Task updateById(Long id, Task task) {
        taskRepository.updateTaskById(task.getShortDesc(), task.getDescription(), task.getStatus(), id);
        return taskRepository.findById(id).get();
    }
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }
}
