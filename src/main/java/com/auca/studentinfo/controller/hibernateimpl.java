package com.auca.studentinfo.controller;

import com.auca.studentinfo.entity.student;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;



@Repository
public class hibernateimpl implements Dao{


    private EntityManager entityManager;

    public hibernateimpl(EntityManager themanager){
        entityManager=themanager;
    }

    @Override
    public List<student> displaystudent() {

        // get currect session of hibernate
        Session thesession=entityManager.unwrap(Session.class);
        // create query
        Query<student> thequery= thesession.createQuery("from student",student.class);

        // execute query
        List<student> students=thequery.getResultList();

        return students;
    }

    @Override
    public student searchst(int myid) {
        Session thesession=entityManager.unwrap(Session.class);

        student mystudent= thesession.get(student.class,myid);


        return mystudent;
    }

    @Override
    public void savest(student mystudent) {
        Session thesession= entityManager.unwrap(Session.class);

        thesession.saveOrUpdate(mystudent);

    }

    @Override
    public void deletest(int myid) {

        Session thesession=entityManager.unwrap(Session.class);

        Query thequery= thesession.createQuery("delete from student where id=:studentid");

        thequery.setParameter("studentid",myid);
        thequery.executeUpdate();

    }

}
