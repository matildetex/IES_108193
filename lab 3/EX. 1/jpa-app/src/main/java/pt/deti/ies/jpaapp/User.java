package pt.deti.ies.jpaapp;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity(name = "tbl_user")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @NotBlank(message = "Name is mandatory")
    private String name;
    
    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotBlank(message = "Phone is mandatory")
    private String phone;

    // standard constructors / setters / getters / toString

    public User() {
    }

    public User(long id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;        
    }

    public User(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;        
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;        
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;        
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;        
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;        
    }

    @Override
    public String toString() {
        return "User{" + "id=" + this.id + ", name='" + this.name + '\'' + ", email='" + this.email + '\'' + ", phone='" + this.phone + '\'' + '}';
    }

}