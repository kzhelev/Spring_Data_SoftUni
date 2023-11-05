package firstexc;

import firstexc.entities.WizardDeposit;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU_name");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        WizardDeposit wizardDeposit = new WizardDeposit();
        wizardDeposit.setFirstName("Gosho");
        wizardDeposit.setLastName("Pesho");

        entityManager.persist(wizardDeposit);

        entityManager.getTransaction().commit();

        entityManager.close();
    }
}

