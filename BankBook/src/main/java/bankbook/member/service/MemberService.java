package main.java.bankbook.member.service;

import main.java.bankbook.member.repository.MemberRepository;

public class MemberService {
    private MemberRepository memberRepository;

    public MemberService() {
        memberRepository = new MemberRepository();
    }

    public boolean existId(String id) {
        return memberRepository.exist(id);
    }

}

