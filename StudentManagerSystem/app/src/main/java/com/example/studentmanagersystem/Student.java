package com.example.studentmanagersystem;

public class Student {
    private String id;
    private String name;
    private String sex;
    private String nativee;
    private String score;

    public  Student(String id,String name,String sex,String nativee,String score){
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.nativee = nativee;
        this.score = score;
    }

    public String getid(){
        return id;
    }

    public String getname(){
        return name;
    }

    public String getsex(){
        return sex;
    }

    public String getnative(){
        return nativee;
    }

    public String getscore(){
        return score;
    }
}
