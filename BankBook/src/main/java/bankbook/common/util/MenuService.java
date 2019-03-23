package main.java.bankbook.common.util;

import main.java.bankbook.BankBookRunner;
import main.java.bankbook.common.view.ConsoleView;
import main.java.bankbook.member.model.Member;
import main.java.bankbook.member.repository.MemberRepository;
import main.java.bankbook.member.service.MemberService;

import java.sql.SQLOutput;
import java.util.Scanner;

public class MenuService {
    private MemberService memberService;
    public ManagementMenu managementMenu;

    MemberRepository memberRepository = new MemberRepository();

    public Member startLoginMenu() {
        Member loginMember = new Member();

        int selectedMenu;
        String currentId, currentPassword;

        do {
            ConsoleView.startLoginMenu(); // 로그인 시작메뉴화면 출력
            selectedMenu = ScannerService.getScanner().nextInt(); // 사용자의 콘솔 입력으로부터 받은 정수값을 받음

            if (selectedMenu == -1) {
                System.out.println("시스템을 종료합니다.");
                return new Member();
            }

            if (selectedMenu == 1) { // 로그인
                System.out.println("아이디를 입력하세요.");               //step1. 아이디와 비밀번호를 입력하라는 유저뷰를 보여준다.
                currentId = ScannerService.getScanner().next();           //step2. 아이디와 비밀번호를 입력받음
                System.out.println("비밀번호를 입력하세요.");
                currentPassword = ScannerService.getScanner().next();
                if (memberRepository.correctMember(currentId, currentPassword)) {                         //step3. 입력받은 값이 올바른 입력값인지 검증
                    System.out.println("회원정보가 일치합니다.");//다음화면으로        //step3.1. 존재하는 회원인지 확인 (id가 존재하고 password가 일치)
                    ManagementMenu.managementMenu();
                }
                if (!memberRepository.correctMember(currentId, currentPassword)) {     //step3.2. 일치하지 않을경우 조건검사를 한번 더 하고 continue 진행
                    System.out.println("회원정보가 일치하지 않습니다.");
                    continue;
                }
                if (!loginMember.existMember()) {
                    System.out.println("정보가 정상적으로 조회되지 않았습니다. 다시 시도해 주세요.");
                    continue;
                }
            }

            if (selectedMenu == 2) { // 회원가입
                System.out.println("사용하고자 하는 아이디를 입력하세요.");                 //step1. 유저뷰를 보여줌
                String newId = ScannerService.getScanner().next();
                if (memberService.existId(newId)) {                                         //step2. 입력받은 아이디가 이미 존재하는 아이디인지 확인
                    System.out.println("이미 존재하는 아이디입니다. 다시 시도해주세요.");   //step3. 존재하면 다시시도 & 존재하지 않으면 회원가입
                    continue;
                }
                else {
                    System.out.println("사용하고자 하는 비밀번호를 입력하세요.");
                    String newPassword = ScannerService.getScanner().next();
                    System.out.println("사용자의 이름을 입력하세요.");
                    String newName = ScannerService.getScanner().next();
                    Member newUser = new Member(newId, newPassword, newName);
                    memberRepository.insertMember(newUser);                                             //새로운 유저의 정보를 입력
                    System.out.println("회원가입이 완료되었습니다. 다시 로그인해주세요.");
                    BankBookRunner.run();                                                               //첫 화면으로 돌아감
                }
            }

            else {                                                                                  //메뉴에 없는 정보 입력
                System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                continue;
            }
        }
        while (selectedMenu > 0 && !loginMember.existMember());
        // 정상적인 메뉴를 입력했으면서 존재하는 회원이 아님
        return loginMember;
    }
}

