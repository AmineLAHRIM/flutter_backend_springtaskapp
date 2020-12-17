package com.am1ne.springtaskapp.dao;

import com.am1ne.springtaskapp.beans.UserTaskDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTaskDetailDao extends JpaRepository<UserTaskDetail, Long> {
    List<UserTaskDetail> findAllByTask_Id(Long taskId);

    List<UserTaskDetail> findAllByUser_Id(Long userId);

    int deleteAllByTask_Id(Long taskId);

    int deleteAllByUser_Id(Long userId);
}