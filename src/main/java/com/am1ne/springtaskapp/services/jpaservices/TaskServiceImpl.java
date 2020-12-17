package com.am1ne.springtaskapp.services.jpaservices;

import com.am1ne.springtaskapp.beans.Task;
import com.am1ne.springtaskapp.dao.TaskDao;
import com.am1ne.springtaskapp.services.TaskService;
import com.am1ne.springtaskapp.services.UserTaskDetailService;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private UserTaskDetailService userTaskDetailService;

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Task> findAll() {
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedFilter");
        filter.setParameter("isDeleted", false);
        List<Task> tasks = this.taskDao.findAll();
        session.disableFilter("deletedFilter");

        return tasks;
    }

    @Override
    public Task findById(Long id) {
        Optional<Task> getId = this.taskDao.findById(id);
        if (getId.isPresent()) {
            Task currentTask =getId.get();
            currentTask.loadDetail=true;
            currentTask.setUsers(this.userTaskDetailService.findAllByTask_Id(id));
            return currentTask;
        }
        return null;
    }

    @Override
    public Task save(Task task) {
        Long currentId = task.getId();
        if (currentId != null && currentId != -1) {
            if (this.taskDao.findById(currentId) == null) {
                return this.taskDao.save(task);
            } else {
                return null;
            }
        } else {
            return this.taskDao.save(task);
        }
    }

    @Transactional
    @Override
    public int deleteById(Long id) {
        if (id != null && id != -1) {
            this.taskDao.deleteById(id);
            return 1;
        }
        return 0;
    }

    @Override
    public Task update(Long id, Task task) {
        if (id != -1) {
            Task currentTask = findById(id);
            if (currentTask != null) {
                task.setId(currentTask.getId());
                return this.taskDao.save(task);
            }
            return null;
        }

        return null;

    }
}
