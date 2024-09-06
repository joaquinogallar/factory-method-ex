package com.jpa.daos.imp;

import com.jpa.daos.MemberDao;
import com.jpa.entities.Member;
import com.jpa.entities.Turn;

import javax.persistence.EntityManager;
import java.util.List;

public class MemberDaoImp implements MemberDao {

    private EntityManager em;
    private static MemberDaoImp memberDaoImp;

    private MemberDaoImp(EntityManager em) {
        this.em = em;
    }

    public static MemberDaoImp getInstance(EntityManager em) {
        if (memberDaoImp == null) {
            memberDaoImp = new MemberDaoImp(em);
        }
        return memberDaoImp;
    }

    @Override
    public void insertMember(Member member) {
        em.persist(member);
    }

    @Override
    public void updateMember(Member member) {
        em.merge(member);
    }

    @Override
    public void deleteMember(Member member) {
        em.remove(member);
    }

    @Override
    public List<Member> getAllMembers() {
        return em.createQuery("SELECT m FROM Member m", Member.class).getResultList();
    }

    @Override
    public Member getMemberById(int id) {
        return em.find(Member.class, id);
    }

    @Override
    public List<Member> getMembersByTurn(Turn turn) {
        return List.of();
    }
}
