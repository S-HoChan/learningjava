package main.java.bankbook; //통장 시스템의 실행

import main.java.bankbook.common.util.ManagementMenu;
import main.java.bankbook.common.util.MenuService;
import main.java.bankbook.common.util.ScannerService;
import main.java.bankbook.member.model.Member;

import java.util.Scanner;

public class BankBookRunner {
    public static void run() {
        MenuService menuService = new MenuService();
        ManagementMenu managementMenu = new ManagementMenu();

        menuService.startLoginMenu();
        Member loginMember = menuService.startLoginMenu();
    }
}
