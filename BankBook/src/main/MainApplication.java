package main; //전체 시스템의 실행

import main.java.bankbook.BankBookRunner;

public class MainApplication {
    public static void main(String[] args) { //시작지점
        System.out.println("통장 관리 시스템을 실행합니다.\n");
        BankBookRunner.run();
    }
}
