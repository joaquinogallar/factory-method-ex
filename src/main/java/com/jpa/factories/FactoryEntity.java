package com.jpa.factories;

import com.jpa.daos.AddressDao;
import com.jpa.daos.MemberDao;
import com.jpa.daos.PersonDao;
import com.jpa.daos.TurnDao;

public abstract class FactoryEntity {
    public static final int DEFAULT = 1;

    public abstract AddressDao getAddressDao();
    public abstract MemberDao getMemberDao();
    public abstract PersonDao getPersonDao();
    public abstract TurnDao getTurnDao();

    public static FactoryEntity getDaoFactoryEntity(int fNumber) {
        switch (fNumber) {
            case DEFAULT:
                return new DefaultFactoryEntity();
            default:
                return null;
        }
    }
}


