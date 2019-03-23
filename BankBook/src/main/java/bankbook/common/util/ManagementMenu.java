package main.java.bankbook.common.util;

import main.java.bankbook.BankBookRunner;
import main.java.bankbook.common.view.ConsoleView;
import main.java.bankbook.member.model.Member;

public class ManagementMenu {

    Member loginMember = new Member();

    public Member managementMenu() {
        Member loginMember = new Member();

        int selectedMenu;

        ConsoleView.managementMenu(); // 로그인 시작메뉴화면 출력
        selectedMenu = ScannerService.getScanner().nextInt(); // 사용자의 콘솔 입력으로부터 받은 정수값을 받음

        do {

            if (selectedMenu == -1) {           //로그아웃
                BankBookRunner.run();
            }

            if (selectedMenu == 1) {            //계좌조회
                System.out.println("점검중입니다.");
                continue;
            }

            if (selectedMenu == 2) {            //입금
                System.out.println("점검중입니다.");
                continue;
            }

            if (selectedMenu == 3) {            //출금
                System.out.println("점검중입니다.");
                continue;
            }

            if (selectedMenu == 0) {            //사용자메뉴
                System.out.println("점검중입니다.");
                continue;
            }

            else {                                                                                  //메뉴에 없는 정보 입력
                System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                continue;
            }
        }

        while (selectedMenu > 0 && !loginMember.existMember());
        return loginMember;
    }
}
