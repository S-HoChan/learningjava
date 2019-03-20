package main.java.bankbook.member.model;

public class Member {
    private String id;
    private String password;
    private String name;


    // 정상적인 id 입력인지 확인
    public boolean existMember() {
        if (this.id == null || this.id.equals("")) {
            return false;
        }
        return true;
    }

    public Member(String id, String password) { //constructor
        this.id = id;
        this.password = password;
    }

    public Member(String id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }

    public Member() {
    }

    public String getId() { //getter
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) { //setter
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }
}
