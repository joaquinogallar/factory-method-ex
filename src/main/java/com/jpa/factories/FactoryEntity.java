package com.jpa.factories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class FactoryEntity {
    public static final int DEFAULT = 1;

    public abstract void open();
    public abstract void close();
    public abstract EntityManagerFactory getEmf();
    public abstract EntityManager getEm();

    public static FactoryEntity getFactoryEntity(int fNumber) {
        switch (fNumber) {
            case DEFAULT:
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_factory_ex");
                return MySqlFactoryEntity.getInstance(emf);
            default:
                return null;
        }
    }
}


