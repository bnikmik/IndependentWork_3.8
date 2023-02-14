package dao;

import config.HibernateSessionFactoryUtil;
import model.Customer;
import model.Role;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    /**
     * Add a new user to the database
     *
     * @param customer - user object
     */
    @Override
    public void add(Customer customer) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
        }
    }

    /**
     * get a user from the database by id
     *
     * @param id - user id
     * @return user from database
     */
    @Override
    public Customer getById(int id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.get(Customer.class, id);
        }
    }

    /**
     * get the role of a user from the database by ID
     *
     * @param id - user id
     * @return user role
     */
    @Override
    public Role getRoleById(int id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.get(Role.class, id);
        }
    }

    /**
     * Print the user and his roles by ID
     *
     * @param id - user id
     * @return text information about the user and his roles
     */
    @Override
    public String getByIdWithRoles(int id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.get(Customer.class, id).toString() + session.get(Customer.class, id).getRoles().toString();
        }
    }

    /**
     * get a collection of users by role
     *
     * @param roleId - role id
     * @return collection of users by role
     */
    @Override
    public List<Customer> getCustomerByRole(int roleId) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.get(Role.class, roleId).getCustomers();
        }
    }

    /**
     * get a collection of all users from the database
     *
     * @return list of users
     */
    @Override
    public List<Customer> getAll() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("From Customer").list();
        }
    }

    /**
     * update user information in database
     *
     * @param customer - user object
     */
    @Override
    public void update(Customer customer) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(customer);
            transaction.commit();
        }
    }

    /**
     * delete user from database
     *
     * @param customer - user object
     */
    @Override
    public void delete(Customer customer) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(customer);
            transaction.commit();
        }
    }
}
