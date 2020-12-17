package com.am1ne.springtaskapp.services.jpaservices;

import com.am1ne.springtaskapp.beans.Task;
import com.am1ne.springtaskapp.beans.User;
import com.am1ne.springtaskapp.beans.UserTaskDetail;
import com.am1ne.springtaskapp.dao.UserTaskDetailDao;
import com.am1ne.springtaskapp.services.UserTaskDetailService;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserTaskDetailServiceImpl implements UserTaskDetailService {

    @Autowired
    private UserTaskDetailDao userTaskDetailDao;

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<UserTaskDetail> findAll() {
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedFilter");
        filter.setParameter("isDeleted", false);
        List<UserTaskDetail> userTaskDetails = this.userTaskDetailDao.findAll();
        session.disableFilter("deletedFilter");

        return userTaskDetails;
    }

    @Override
    public UserTaskDetail findById(Long id) {
        Optional<UserTaskDetail> getId = this.userTaskDetailDao.findById(id);
        if (getId.isPresent()) {
            return getId.get();
        }
        return null;
    }

    @Override
    public UserTaskDetail save(UserTaskDetail userTaskDetail) {
        Long currentId = userTaskDetail.getId();
        if (currentId != null && currentId != -1) {
            if (this.userTaskDetailDao.findById(currentId) == null) {
                return this.userTaskDetailDao.save(userTaskDetail);
            } else {
                return null;
            }
        } else {
            return this.userTaskDetailDao.save(userTaskDetail);
        }
    }

    @Transactional
    @Override
    public int deleteById(Long id) {
        if (id != null && id != -1) {
            this.userTaskDetailDao.deleteById(id);
            return 1;
        }
        return 0;
    }

    @Override
    public UserTaskDetail update(Long id, UserTaskDetail userTaskDetail) {
        if (id != -1) {
            UserTaskDetail currentUserTaskDetail = findById(id);
            if (currentUserTaskDetail != null) {
                userTaskDetail.setId(currentUserTaskDetail.getId());
                return this.userTaskDetailDao.save(userTaskDetail);
            }
            return null;
        }

        return null;

    }

    @Override
    public List<User> findAllByTask_Id(Long taskId) {
        List<User> users = new ArrayList<>();
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedFilter");
        filter.setParameter("isDeleted", false);
        List<UserTaskDetail> userTaskDetails = this.userTaskDetailDao.findAllByTask_Id(taskId);
        session.disableFilter("deletedFilter");
        userTaskDetails.forEach(userTaskDetail -> {
            users.add(userTaskDetail.getUser());
        });
        return users;
    }

    @Override
    public List<Task> findAllByUser_Id(Long userId) {
        List<Task> tasks = new ArrayList<>();
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedFilter");
        filter.setParameter("isDeleted", false);
        List<UserTaskDetail> userTaskDetails = this.userTaskDetailDao.findAllByUser_Id(userId);
        session.disableFilter("deletedFilter");
        userTaskDetails.forEach(userTaskDetail -> {
            tasks.add(userTaskDetail.getTask());
        });

        return tasks;
    }

    @Override
    public int deleteAllByTask_Id(Long taskId) {
        return userTaskDetailDao.deleteAllByTask_Id(taskId);
    }

    @Override
    public int deleteAllByUser_Id(Long userId) {
        return userTaskDetailDao.deleteAllByUser_Id(userId);

    }
}
