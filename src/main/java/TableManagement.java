import entities.Administrator;
import entities.Prisoner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class TableManagement {

    private static final String PERSISTENCE_UNIT_NAME = "PersistenceUnit";
    protected static EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public void startOnce(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void addAdministratorToDatabase() {

        Administrator administrator = new Administrator();
        administrator = administrator.createNewAdministrator();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(administrator);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void removeAdministratorToDatabase() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Type the ID of the administrator that needs to be removed: ");
        int id = scanner.nextInt();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Administrator administrator = entityManager.find(Administrator.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(administrator);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
