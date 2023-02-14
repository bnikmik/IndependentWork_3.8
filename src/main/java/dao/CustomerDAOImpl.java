package dao;

import config.HibernateSessionFactoryUtil;
import model.Customer;
import model.Role;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CustomerDAOImpl implements CustomerDAO{

    @Override
    public void add(Customer customer) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
        }
    }

    @Override
    public Customer getById(int id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.get(Customer.class, id);
        }
    }
    @Override
    public Role getRoleById(int id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.get(Role.class, id);
        }
    }

    @Override
    public String getByIdWithRoles(int id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.get(Customer.class, id).toString() + session.get(Customer.class, id).getRoles().toString();
        }
    }

    @Override
    public List<Customer> getCustomerByRole(int roleId) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.get(Role.class, roleId).getCustomers();
        }
    }

    @Override
    public List<Customer> getAll() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("From Customer").list();
        }
    }

    @Override
    public void update(Customer customer) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(customer);
            transaction.commit();
        }
    }

    @Override
    public void delete(Customer customer) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(customer);
            transaction.commit();
        }
    }
}
