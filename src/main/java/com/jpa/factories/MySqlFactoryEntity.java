package com.jpa.factories;

import com.jpa.daos.AddressDao;
import com.jpa.daos.MemberDao;
import com.jpa.daos.PersonDao;
import com.jpa.daos.TurnDao;
import com.jpa.daos.imp.AddressDaoImp;
import com.jpa.daos.imp.MemberDaoImp;
import com.jpa.daos.imp.PersonDaoImp;
import com.jpa.daos.imp.TurnDaoImp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class MySqlFactoryEntity extends FactoryEntity {

    private final EntityManagerFactory emf;
    private final EntityManager em;
    private static MySqlFactoryEntity instance;

    private MySqlFactoryEntity(EntityManagerFactory emf) {
        this.emf = emf;
        em = emf.createEntityManager();
    }

    public static MySqlFactoryEntity getInstance(EntityManagerFactory emf) {
        if(instance == null) {
            instance = new MySqlFactoryEntity(emf);
        }
        return instance;
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public EntityManager getEm() {
        return em;
    }

    public void open() {
        em.getTransaction().begin();
    }

    public void close() {
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
