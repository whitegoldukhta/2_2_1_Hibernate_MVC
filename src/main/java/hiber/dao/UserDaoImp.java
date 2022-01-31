package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }


    @Override
    public List<User> findOwner(String carModel, Integer carSeries) {

        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("FROM User u WHERE u.car.model=?1 AND u.car.series=?2");
        query.setParameter(1, carModel);
        query.setParameter(2, carSeries);

        return query.getResultList();
    }


}
