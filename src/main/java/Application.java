import dao.CustomerDAOImpl;
import model.Customer;
import model.Role;

import java.util.HashSet;
import java.util.Set;


public class Application {
    public static void main(String[] args) {
        CustomerDAOImpl customerDAO = new CustomerDAOImpl();
        customerDAO.getAll().forEach(System.out::println);
        System.out.println(customerDAO.getByIdWithRoles(5));
//        Role role = new Role("banned");

//        Customer customer = customerDAO.getById(5);
//        customer.addRole(customerDAO.getRoleById(8));
//        customerDAO.update(customer);

//        customerDAO.delete(customerDAO.getById(7));

        Set<Role> roleSet = new HashSet<>();
        roleSet.add(customerDAO.getRoleById(7));
        roleSet.add(customerDAO.getRoleById(8));

//        customerDAO.add(new Customer("Вася", "us", "pass", roleSet));

        Customer customer = customerDAO.getById(8);
        customer.setLogin("123");
        customerDAO.update(customer);

        customerDAO.getCustomerByRole(8).forEach(System.out::println);
    }
}

