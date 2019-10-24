package pl.laptopy.polizingowe.test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Long id;
    private String profilePicPath;

    public Employee(Long id, String profilePicPath) {
        this.id = id;
        this.profilePicPath = profilePicPath;
    }

    public Employee() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProfilePicPath() {
        return profilePicPath;
    }

    public void setProfilePicPath(String profilePicPath) {
        this.profilePicPath = profilePicPath;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id +  ", profilePicPath=" + profilePicPath + "]";
    }

}
