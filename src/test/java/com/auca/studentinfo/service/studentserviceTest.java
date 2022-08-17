package com.auca.studentinfo.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.auca.studentinfo.controller.Dao;
import com.auca.studentinfo.entity.student;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {studentservice.class})
@ExtendWith(SpringExtension.class)
class studentserviceTest {
    @MockBean
    private Dao dao;

    @Autowired
    private studentservice studentservice;

    @Test
    public void testDisplaystudent() {
        ArrayList<student> studentList = new ArrayList<>();
        when(dao.displaystudent()).thenReturn(studentList);
        List<student> actualDisplaystudentResult = studentservice.displaystudent();
        assertSame(studentList, actualDisplaystudentResult);
        assertTrue(actualDisplaystudentResult.isEmpty());
        verify(dao).displaystudent();
    }


    // @Test
    // public void testSearchst() {
    //     student student = new student();
    //     student.setFirstname("Jane");
    //     student.setId(1);
    //     student.setLastname("Doe");
    //     when(dao.searchst(anyInt())).thenReturn(student);
    //     assertSame(student, studentservice.searchst(1));
    //     verify(dao).searchst(anyInt());
    // }

    // @Test
    // public void testSavest() {
    //     doNothing().when(dao).savest((student) any());

    //     student student = new student();
    //     student.setFirstname("Jane");
    //     student.setId(1);
    //     student.setLastname("Doe");
    //     studentservice.savest(student);
    //     verify(dao).savest((student) any());
    // }

    // @Test
    // public void testDeletest() {
    //     doNothing().when(dao).deletest(anyInt());
    //     studentservice.deletest(1);
    //     verify(dao).deletest(anyInt());
    // }
}

