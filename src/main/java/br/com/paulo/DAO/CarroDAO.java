/**
 * @author João Paulo
 */

package br.com.paulo.DAO;

import br.com.paulo.domain.Carro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CarroDAO implements ICarroDAO{

    @Override
    public Carro cadastrar(Carro carro) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("teste1");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(carro);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return carro;
    }
}
