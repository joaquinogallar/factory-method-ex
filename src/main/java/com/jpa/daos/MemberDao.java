package com.jpa.daos;

import com.jpa.entities.Member;

import java.util.List;

public interface MemberDao {
    public void insertMember(Member member);
    public void updateMember(Member member);
    public void deleteMember(Member member);
    public List<Member> getAllMembers();
    public Member getMemberById(int id);
}
