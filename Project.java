package ood_test;

//Project.java
import javax.persistence.*;

@Entity
public class Project {
 @Id
 @GeneratedValue
 private Long id;
 private String name;

 @ManyToOne
 private Department department;

 public Project() {}

 public Project(String name, Department department) {
     this.name = name;
     this.department = department;
 }

 public Long getId() { return id; }
 public String getName() { return name; }
 public void setName(String name) { this.name = name; }
 public Department getDepartment() { return department; }
 public void setDepartment(Department department) { this.department = department; }

 @Override
 public String toString() {
     return "Project{" +
             "id=" + id +
             ", name='" + name + '\'' +
             ", department=" + department.getName() +
             '}';
 }
}
