package main.java.bankbook.common.view;

public class ConsoleView {
    public static void startLoginMenu(){
        System.out.println("통장관리시스템");
        System.out.println("1. 로그인");
        System.out.println("2. 회원가입");
        System.out.println("종료하려면 -1을 입력하세요.");
    }

    public static void managementMenu(){
        System.out.println("통장관리 시스템을 실행합니다.");
        System.out.println("1. 계좌조회");
        System.out.println("2. 입금");
        System.out.println("3. 출금");
        System.out.println("0. 사용자메뉴");
        System.out.println("로그아웃하려면 -1을 입력하세요.");
    }

}
