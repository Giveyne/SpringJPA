package JpaImplementation.JpaDAO;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import JpaImplementation.system.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class JpaDao {

    @PersistenceContext
    private EntityManager em; // Для внедрения EntityManager

    public void addUser(User user) {
        em.persist(user); // Использование EntityManager
    }
    public User getUserById(long id) {
        return em.find(User.class, id); // Использование EntityManager
    }
    public void updateUser(User user) {
        em.merge(user);
    }

    public void delateUser(Long id){
            User user = em.find(User.class, id);
            em.remove(user);
        }
    public List<User> getListUsers(){
           /* CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<User> q = cb.createQuery(User.class);
            Root<User> c = q.from(User.class);
            q.select(c);*/
            TypedQuery<User> query = em.createQuery("SELECT p FROM User p", User.class);
            List<User> users = query.getResultList();
            return users;
        }

}

