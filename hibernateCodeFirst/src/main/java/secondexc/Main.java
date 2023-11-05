package secondexc;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import secondexc.entities.Customer;
import secondexc.entities.Product;
import secondexc.entities.Sale;
import secondexc.entities.StoreLocation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU_name");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

//        TypedQuery<Customer> customerTypedQuery = entityManager.createQuery("Select c from Customer c",Customer.class);
//
//        List<Customer> customers = customerTypedQuery.getResultList();
//
//        System.out.println();

        Customer customer = new Customer();
        customer.setName("Gosho");

        Product product = new Product();
        product.setName("Toothpaste");

        StoreLocation storeLocation = new StoreLocation();
        storeLocation.setLocationName("CBA Izgrev");

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String dateString = "15.10.2023";

        Date date;

        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Sale sale = new Sale(product,customer,storeLocation, date);

        entityManager.persist(customer);
        entityManager.persist(product);
        entityManager.persist(storeLocation);
        entityManager.persist(sale);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
