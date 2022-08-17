package com.auca.studentinfo.service;

import com.auca.studentinfo.controller.Dao;
import com.auca.studentinfo.entity.student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class studentservice implements services{
    private Dao dao;

    public studentservice(Dao thedao){
        dao=thedao;
    }

    @Override
    @Transactional
    public List<student> displaystudent() {
        return dao.displaystudent();
    }

    @Override
    @Transactional
    public student searchst(int myid) {
        return dao.searchst(myid);
    }

    @Override
    @Transactional
    public void savest(student mystudent) {
        dao.savest(mystudent);
    }

    @Override
    @Transactional
    public void deletest(int myid) {
      dao.deletest(myid);
    }
}
