package DAO;

import model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.DBHelper;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    private static UserDaoHibernateImpl instance = new UserDaoHibernateImpl();
    private static SessionFactory sessionFactory = DBHelper.getSessionFactory();


    private UserDaoHibernateImpl() {
    }

    public static UserDaoHibernateImpl getInstance() {
        return instance;
    }

    @Override
    public boolean saveUser(User user) {
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
        session.save(user);
        try {
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        session.close();
        return true;
    }

    @Override
    public boolean editUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        try {
            session.close();
            transaction.commit();
            return true;
        } catch (Exception ex) {
            transaction.rollback();
            session.close();
            return false;
        }
    }

    @Override
    public boolean deleteUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        try {
            session.close();
            transaction.commit();
            return true;
        } catch (Exception ex) {
            transaction.rollback();
            session.close();
            return false;
        }
    }

    @Override
    public User findUserById(Long id) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM User WHERE id = :param");
        query.setParameter("param", id);
        User singleResult = (User) query.getSingleResult();
        return singleResult;
    }

    @Override
    public <T> List<T> findAllUsers() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM User");
        List userList = query.list();
        session.close();
        return userList;
    }
}
