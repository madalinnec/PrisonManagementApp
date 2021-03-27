package repository;

import entities.Administrator;
import entities.Prison;
import entities.Prisoner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class TableManagement {

    private static final String PERSISTENCE_UNIT_NAME = "PersistenceUnit";
    protected static EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void createTables(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void addAdministratorToDatabase() {// de refactorizat pentru a folosi o singura metoda pentru toate entitatile
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

    public Administrator returnAdministratorById(int id){ //de unit cu returnPrisonByID
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        //query ca sa gasesc administratorul dupa ID si sa il asignez la prison
        Administrator administrator = (Administrator) entityManager.createNamedQuery("returnAdministratorById").setParameter("idAdministrator",id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return administrator;
    }

    public Prison returnPrisonById(int id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        //query ca sa gasesc prison dupa ID si sa il asignez la prisoner
        Prison prison = (Prison) entityManager.createNamedQuery("returnPrisonById").setParameter("idPrison",id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return prison;
    }

    public List<Administrator> returnAdminList(){
        List<Administrator> adminList = entityManager.createQuery("select c from Administrator c", Administrator.class).getResultList();
        return adminList;
    }
}
