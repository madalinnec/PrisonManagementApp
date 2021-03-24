import entities.Administrator;
import entities.Prison;
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

    public void createTables(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void addAdministratorToDatabase() {
        Administrator administrator = new Administrator();
        administrator = administrator.insertNewAdministratorDetails();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(administrator);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void removeAdministratorFromDatabase() {
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

    public void addPrisonToDatabase(){
        Prison prison = new Prison();
        prison = prison.insertNewPrisonDetails();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(prison);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void removePrisonFromDatabase(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type the ID of the prison that needs to be removed: ");
        int id = scanner.nextInt();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Prison prison = entityManager.find(Prison.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(prison);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void addPrisonerToDatabase(){
        Prisoner prisoner = new Prisoner();
        prisoner = prisoner.insertNewPrisonerDetails();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(prisoner);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void removePrisonerFromDatabase(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type the ID of the prisoner that needs to be removed: ");
        int id = scanner.nextInt();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Prisoner prisoner = entityManager.find(Prisoner.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(prisoner);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
