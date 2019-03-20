package main.java.bankbook; //통장 시스템의 실행

import main.java.bankbook.common.util.MenuService;
import main.java.bankbook.common.util.ScannerService;
import main.java.bankbook.member.model.Member;

import java.util.Scanner;

public class BankBookRunner {
    public static void run() {
        MenuService menuService = new MenuService();
        menuService.startLoginMenu();
//        Member logicMember = menuService.startLoginMenu();  <<??? 확인해보기

//        // 존재하는 회원/로그인 완료된 회원이라면 계좌관리 시스템 시작
//        if (logicMember.existMember()){ // 계좌관리 시스템 시작
//            //menuService.startBankBookManagementMenu(logicMember);
//        }
//        System.out.println("프로그램을 종료합니다.");
    }
 }
