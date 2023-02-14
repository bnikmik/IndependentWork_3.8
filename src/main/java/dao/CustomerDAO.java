package dao;

import model.Customer;
import model.Role;

import java.util.List;


public interface CustomerDAO {
    /**
     * Add a new user to the database
     *
     * @param customer - user object
     */
    void add(Customer customer);

    /**
     * get a user from the database by id
     *
     * @param id - user id
     * @return user from database
     */
    Customer getById(int id);

    /**
     * get the role of a user from the database by ID
     *
     * @param id - user id
     * @return user role
     */
    Role getRoleById(int id);

    /**
     * Print the user and his roles by ID
     *
     * @param id - user id
     * @return text information about the user and his roles
     */
    String getByIdWithRoles(int id);

    /**
     * get a collection of users by role
     *
     * @param roleId - role id
     * @return collection of users by role
     */
    List<Customer> getCustomerByRole(int roleId);

    /**
     * get a collection of all users from the database
     *
     * @return list of users
     */
    List<Customer> getAll();

    /**
     * update user information in database
     *
     * @param customer - user object
     */
    void update(Customer customer);

    /**
     * delete user from database
     *
     * @param customer - user object
     */
    void delete(Customer customer);
}
