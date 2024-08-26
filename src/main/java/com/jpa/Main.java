package com.jpa;

import com.jpa.daos.AddressDao;
import com.jpa.daos.PersonDao;
import com.jpa.daos.TurnDao;
import com.jpa.daos.imp.AddressDaoImp;
import com.jpa.daos.imp.PersonDaoImp;
import com.jpa.daos.imp.TurnDaoImp;
import com.jpa.entities.Address;
import com.jpa.entities.Person;
import com.jpa.entities.Turn;
import com.jpa.factories.FactoryEntity;

import javax.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        /*EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my_factory_ex");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Address a = new Address("1475 Luck Hoof Avenue", "Los Angeles");
        entityManager.persist(a);

        Person bojack = new Person("Bojack", "Horseman", 20, a);
        Person pCarolyn = new Person("Princess", "Carolyn", 20, a);
        entityManager.persist(bojack);
        entityManager.persist(pCarolyn);

        Turn t = new Turn();
        t.addPlayer(bojack);
        t.addPlayer(pCarolyn);
        entityManager.persist(t);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();*/
        FactoryEntity defaultFactoryEntity = FactoryEntity.getFactoryEntity(FactoryEntity.DEFAULT);


        if (defaultFactoryEntity != null) {

            defaultFactoryEntity.open();

            EntityManager em = defaultFactoryEntity.getEm();
            AddressDao addressDao = AddressDaoImp.getInstance(em);
            PersonDao personDao = PersonDaoImp.getInstance(em);
            TurnDao turnDao = TurnDaoImp.getInstance(em);

            Address a = new Address("1475 Luck Hoof Avenue", "Los Angeles");

            Person bojack = new Person("Bojack", "Horseman", 20, a);
            Person pCarolyn = new Person("Princess", "Carolyn", 20, a);

            Turn t = new Turn();


            addressDao.insertAddress(a);

            personDao.insertPerson(bojack);
            personDao.insertPerson(pCarolyn);

            turnDao.insertTurn(t);

            defaultFactoryEntity.close();

        }


    }
}