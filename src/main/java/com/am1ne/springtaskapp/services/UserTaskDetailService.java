package com.am1ne.springtaskapp.services;

import com.am1ne.springtaskapp.beans.Task;
import com.am1ne.springtaskapp.beans.User;
import com.am1ne.springtaskapp.beans.UserTaskDetail;

import java.util.List;

public interface UserTaskDetailService {

    public List<UserTaskDetail> findAll();

    public UserTaskDetail findById(Long id);

    public UserTaskDetail save(UserTaskDetail userTaskDetail);

    public int deleteById(Long id);

    public UserTaskDetail update(Long id, UserTaskDetail userTaskDetail);

    public List<User> findAllByTask_Id(Long taskId);

    public List<Task> findAllByUser_Id(Long userId);

    public int deleteAllByTask_Id(Long taskId);

    public int deleteAllByUser_Id(Long userId);

}
