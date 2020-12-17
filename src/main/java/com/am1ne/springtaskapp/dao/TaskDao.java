package com.am1ne.springtaskapp.dao;

import com.am1ne.springtaskapp.beans.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDao extends JpaRepository<Task, Long> {
}