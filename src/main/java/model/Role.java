package model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table (name = "role")
public class Role {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_role")
    private Integer idRole;
    @Column (name = "name")
    private String nameRole;
    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable (name = "customer_role",
    joinColumns = @JoinColumn(name = "role_id"),
    inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private List<Customer> customers;

    public Role() {
    }

    public Role(String nameRole) {
        this.nameRole = nameRole;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(idRole, role.idRole) && Objects.equals(nameRole, role.nameRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRole, nameRole);
    }

    @Override
    public String toString() {
        return "Role{" +
                "idRole=" + idRole +
                ", nameRole='" + nameRole + '\'' +
                '}';
    }
}
