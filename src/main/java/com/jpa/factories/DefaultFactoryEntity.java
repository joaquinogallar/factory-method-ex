package com.jpa.factories;

import com.jpa.daos.AddressDao;
import com.jpa.daos.MemberDao;
import com.jpa.daos.PersonDao;
import com.jpa.daos.TurnDao;
import com.jpa.daos.imp.AddressDaoImp;
import com.jpa.daos.imp.MemberDaoImp;
import com.jpa.daos.imp.PersonDaoImp;
import com.jpa.daos.imp.TurnDaoImp;

public class DefaultFactoryEntity extends FactoryEntity {
    @Override
    public AddressDao getAddressDao() {
        return new AddressDaoImp();
    }

    @Override
    public MemberDao getMemberDao() {
        return new MemberDaoImp();
    }

    @Override
    public PersonDao getPersonDao() {
        return new PersonDaoImp();
    }

    @Override
    public TurnDao getTurnDao() {
        return new TurnDaoImp();
    }
}
