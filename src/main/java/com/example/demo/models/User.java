package com.example.demo.models;
import javax.persistence.*;

@Entity
@Table(name = "User")

public class User {
    @Id
    @Column(name = "id")
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "password")
    private String Password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Employee employee;


    public void setId(Integer id){
        Id = id;
    }

    public Integer getId(){
        return Id;
    }

    public void setPassword(String password){
        Password = password;
    }
    
    public String getPassword(){
        return Password;
    }

    public void setEmployee(Employee employee){
        this.employee = employee;
    }

    public Employee getEmployee(){
        return employee;
    }

    public void setRole(Role role){
        this.role = role;
    }

    public Role getRole(){
        return role;
    }
}
