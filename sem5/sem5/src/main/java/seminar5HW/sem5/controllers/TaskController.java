package seminar5HW.sem5.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import seminar5HW.sem5.module.Task;
import seminar5HW.sem5.module.TaskStatus;
import seminar5HW.sem5.service.TaskService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;
    @PostMapping
    public Task addTask(@RequestBody Task task) {
        task.setCreateTaskDate(LocalDateTime.now());
        return taskService.add(task);
    }
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.findAll();
    }
    @GetMapping("/{status}")
    public List<Task> getTaskByStatus(@PathVariable TaskStatus status) {
        return taskService.getTaskByStatus(status);
    }
    @PutMapping("/{id}")
    public Task updateTaskById(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateById(id, task);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        taskService.deleteById(id);
    }
}
