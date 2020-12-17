package com.am1ne.springtaskapp.api;

import com.am1ne.springtaskapp.beans.Task;
import com.am1ne.springtaskapp.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("taskapp/task")
public class TaskRest {

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public List<Task> findAll() {
        return this.taskService.findAll();
    }

    @GetMapping("/{id}")
    public Task findById(@PathVariable Long id) {
        return this.taskService.findById(id);
    }

    @PostMapping("/")
    public Task save(@RequestBody Task task) {
        return this.taskService.save(task);
    }
    @PutMapping("/{id}")
    public Task update(@PathVariable Long id, @RequestBody Task task) {
        return this.taskService.update(id, task);
    }

    @DeleteMapping("/{id}")
    public int deleteById(@PathVariable Long id) {
        return this.taskService.deleteById(id);
    }
}
