package ood_test;

//Employee.java
import javax.persistence.*;

@Entity
public class Employee {
 @Id
 @GeneratedValue
 private Long id;
 private String name;
 private double salary;

 @ManyToOne
 private Department department;

 public Employee() {}

 public Employee(String name, double salary, Department department) {
     this.name = name;
     this.salary = salary;
     this.department = department;
 }

 public Long getId() { return id; }
 public String getName() { return name; }
 public void setName(String name) { this.name = name; }
 public double getSalary() { return salary; }
 public void setSalary(double salary) { this.salary = salary; }
 public Department getDepartment() { return department; }
 public void setDepartment(Department department) { this.department = department; }

 @Override
 public String toString() {
     return "Employee{" +
             "id=" + id +
             ", name='" + name + '\'' +
             ", salary=" + salary +
             ", department=" + department.getName() +
             '}';
 }
}

