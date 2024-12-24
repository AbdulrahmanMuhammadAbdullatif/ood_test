package ood_test;
//Main.java
import javax.persistence.*;
import java.util.List;

public class Main {
 public static void main(String[] args) {
     EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb:test.odb");
     EntityManager em = emf.createEntityManager();

     try {
         // Create entities
         em.getTransaction().begin();
         Department dept = new Department("Engineering");
         Project project = new Project("Project Alpha", dept);
         Employee emp1 = new Employee("John Doe", 50000, dept);
         Employee emp2 = new Employee("Jane Smith", 60000, dept);
         em.persist(dept);
         em.persist(project);
         em.persist(emp1);
         em.persist(emp2);
         em.getTransaction().commit();

         // Read entities
         TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e", Employee.class);
         List<Employee> employees = query.getResultList();
         employees.forEach(System.out::println);

         TypedQuery<Project> projectQuery = em.createQuery("SELECT p FROM Project p", Project.class);
         List<Project> projects = projectQuery.getResultList();
         projects.forEach(System.out::println);

         // Update entity
         em.getTransaction().begin();
         emp1.setSalary(55000);
         em.merge(emp1);
         em.getTransaction().commit();

         // Delete entity
         em.getTransaction().begin();
         em.remove(emp2);
         em.getTransaction().commit();

     } finally {
         em.close();
         emf.close();
     }
 }
}
