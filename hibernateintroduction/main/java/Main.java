import entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("school");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Student student = new Student("Pesho", 22);
        Student student1 = new Student("Gosho", 21);

        entityManager.persist(student);
        entityManager.persist(student1);
        entityManager.detach(student1);

        student.setAge(25);
        student1.setAge(23);

        entityManager.merge(student1);

        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
