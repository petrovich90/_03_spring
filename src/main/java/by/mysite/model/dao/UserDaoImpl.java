package by.mysite.model.dao;

import by.mysite.model.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoImpl implements UserDao{
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> getAllUsers() {
        try (Session session = sessionFactory.openSession()){
            return session.createSQLQuery("SELECT * FROM user")
                    .addEntity(User.class).list();
        }
    }
}
