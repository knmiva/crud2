package DAO;

import static utils.PropertyReader.getPropertyValue;

public class UserDaoFactory {

    public UserDaoFactory() {
    }

    public UserDao getUserDao() {

        if (getPropertyValue("Driver").equalsIgnoreCase("hibernate")) {
            return UserDaoHibernateImpl.getInstance();
        } else {
            return UserDaoJDBCImpl.getInstance();
        }
    }
}
