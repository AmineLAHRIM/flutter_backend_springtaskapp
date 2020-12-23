package com.am1ne.springtaskapp.services.jpaservices;

import com.am1ne.springtaskapp.beans.User;
import com.am1ne.springtaskapp.dao.UserDao;
import com.am1ne.springtaskapp.services.UserTaskDetailService;
import com.am1ne.springtaskapp.services.UserService;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserTaskDetailService userTaskDetailService;

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> findAll() {
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedFilter");
        filter.setParameter("isDeleted", false);
        List<User> users = this.userDao.findAll();
        session.disableFilter("deletedFilter");

        return users;
    }

    @Override
    public User findById(Long id) {
        Optional<User> getId = this.userDao.findById(id);
        if (getId.isPresent()) {
            User currentUser = getId.get();
            currentUser.loadDetail = true;
            currentUser.setTasks(this.userTaskDetailService.findAllByUser_Id(id));
            return currentUser;
        }
        return null;
    }

    @Override
    public int save(User user) {

        if(this.userDao.findByEmail(user.getEmail())!=null){
            return -1;
        }else {
            this.userDao.save(user);
            return 1;
        }
    }

    @Transactional
    @Override
    public int deleteById(Long id) {
        if (id != null && id != -1) {
            this.userDao.deleteById(id);
            return 1;
        }
        return 0;
    }

    @Override
    public User update(Long id, User user) {
        if (id != -1) {
            User currentUser = findById(id);
            if (currentUser != null) {
                user.setId(currentUser.getId());
                return this.userDao.save(user);
            }
            return null;
        }

        return null;

    }

    @Override
    public User findByEmailAndPassword(String email, String password) {

        return this.userDao.findByEmailAndPassword(email, password);
    }
}
