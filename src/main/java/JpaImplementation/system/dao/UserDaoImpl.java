package JpaImplementation.system.dao;


import JpaImplementation.JpaDAO.JpaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import JpaImplementation.system.model.User;

import java.util.List;


@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    public JpaDao jpaDao;

    public UserDaoImpl(JpaDao jpaDao) {
        this.jpaDao = jpaDao;
    }

    @Override
    public List<User> findAll() {
        return jpaDao.getListUsers();
    }

    @Override
    public User getById(Long id) {
        return jpaDao.getUserById(id);
    }

    @Override
    public void save(User user) {
       jpaDao.addUser(user);
    }

    @Override
    public void delete(Long id) {
       jpaDao.delateUser(id);
    }
    @Override
    public void update(User user) {
        jpaDao.updateUser(user);
    }

}
