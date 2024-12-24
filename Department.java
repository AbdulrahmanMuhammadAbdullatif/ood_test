package ood_test;

//Department.java
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {
 @Id
 @GeneratedValue
 private Long id;
 private String name;

 @OneToMany(mappedBy = "department")
 private List<Employee> employees = new ArrayList<>();

 @OneToMany(mappedBy = "department")
 private List<Project> projects = new ArrayList<>();

 public Department() {}

 public Department(String name) {
     this.name = name;
 }

 public Long getId() { return id; }
 public String getName() { return name; }
 public void setName(String name) { this.name = name; }
 public List<Employee> getEmployees() { return employees; }
 public List<Project> getProjects() { return projects; }

 @Override
 public String toString() {
     return "Department{" +
             "id=" + id +
             ", name='" + name + '\'' +
             '}';
 }
}
