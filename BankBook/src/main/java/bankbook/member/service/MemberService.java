package main.java.bankbook.member.service;

import main.java.bankbook.member.model.Member;
import main.java.bankbook.member.repository.MemberRepository;

public class MemberService {
    private MemberRepository memberRepository;

    Member currentMember = new Member("currentId", "currentPassword");

    public MemberService() {
        memberRepository = new MemberRepository();
    }

    public boolean existId(String id) {
        return memberRepository.exist(id);
    }

}

