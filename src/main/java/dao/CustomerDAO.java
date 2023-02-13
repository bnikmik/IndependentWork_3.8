package dao;

import model.Customer;
import model.Role;

import java.util.List;


public interface CustomerDAO {
    void add(Customer customer);

    Customer getById(int id);

    Role getRoleById(int id);

    String getByIdWithRoles(int id);

    List<Customer> getCustomerByRole(int roleId);

    List<Customer> getAll();

    void update(Customer customer);

    void delete(Customer customer);
}
