package com.auca.studentinfo.controller;

import com.auca.studentinfo.entity.student;

import java.util.List;

public interface Dao {

    public List<student> displaystudent();
    public student searchst(int myid);
    public void savest(student mystudent);
    public void deletest(int myid);



}
