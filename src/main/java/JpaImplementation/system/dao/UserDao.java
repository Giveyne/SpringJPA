package JpaImplementation.system.dao;



import JpaImplementation.system.model.User;

import java.util.List;

public interface UserDao {

    User getById(Long id);
    List<User> findAll();
    void save(User user);
    void delete(Long id);
    void update(User user);
}
