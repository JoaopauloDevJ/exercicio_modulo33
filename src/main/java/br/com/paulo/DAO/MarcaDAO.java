/**
 * @author João Paulo
 */

package br.com.paulo.DAO;

import br.com.paulo.domain.Marca;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MarcaDAO implements IMarcaDAO{

    @Override
    public Marca cadastrar(Marca marca) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("teste1");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(marca);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return marca;
    }
}
