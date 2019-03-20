package main.java.bankbook.member.repository;

import main.java.bankbook.common.util.ScannerService;
import main.java.bankbook.member.model.Member;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberRepository {
    private static final String MEMBER_FILE_PATH = "C:/Users/User/IdeaProjects/BankBook/src/main/resource/member.txt";
    private static final String SEPARATOR = " ";

    private Scanner scanner;

    private FileWriter fileWriter;

    public MemberRepository() {
        scanner = ScannerService.getFileScanner(MEMBER_FILE_PATH);
    }

    public void openWrite() {
        try {
            fileWriter = new FileWriter(new File(MEMBER_FILE_PATH), true); // appendMode? : 이어쓰기 하는가?
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Member> getAllMembersInFile(){
        List<Member> memberList = new ArrayList<>();

        while(scanner.hasNext()) {
            String readLine = scanner.nextLine();
            String[] memberDataStringArray = readLine.split(SEPARATOR); //text를 쪼개는 함수

            if (memberDataStringArray.length != 3) {
                continue; // 데이터에 오류가 있어서 통과함
            }

            Member readMember = new Member(memberDataStringArray[0], memberDataStringArray[1], memberDataStringArray[2]);
            // 이상이 없을경우 DB에서 읽은 회원정보로 회원 데이터 생성 (parsing)
            memberList.add(readMember); // DB에서 읽은 데이터를 자바 객체로
        }

        return memberList;
    }

    public boolean exist(String id) {  // 회원정보 존재 확인
        List<Member> memberList = getAllMembersInFile(); // txt파일에 있는 회원정보를 전부 돌려줌

        for (Member member : memberList) {
            if (id.equals(member.getId())) {
                return true;
            }
        }
        return false;
    }

    public boolean correctMember(String id, String password) {
        List<Member> memberList = getAllMembersInFile();

        for (Member member : memberList) {
            if (id.equals(member.getId())) {
                if (password.equals(member.getPassword())) {
                    return true;
                }
            }
        }
        return false;
    }
}
