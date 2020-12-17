package com.am1ne.springtaskapp.services;

import com.am1ne.springtaskapp.beans.Task;

import java.util.List;

public interface TaskService {

    public List<Task> findAll();

    public Task findById(Long id);

    public Task save(Task task);

    public int deleteById(Long id);

    Task update(Long id, Task task);
}
