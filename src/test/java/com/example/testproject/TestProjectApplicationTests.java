package com.example.testproject;

import cn.hutool.core.lang.UUID;
import com.example.testproject.service.StudentService;
import com.example.testproject.service.SysUserLoginService;
import com.example.testproject.test.PetSell;
import com.example.testproject.test.factory.PetBreedFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class TestProjectApplicationTests {

    @Autowired
    private StudentService studentService;
    @Autowired
    private SysUserLoginService sysUserLoginService;



    @Test
    void contextLoads() {
    }

    @Test
    public void test111() {

        studentService.test111();

    }

    @Test
    public void test222() {

        studentService.test222();

    }

    /*@Test
    public void test333() {

        sysUserLoginService.deleteStudent();

    }*/

    @Test
    public void test444() {
        PetSell catPetProxy = PetBreedFactory.getPetProxy("1");
        catPetProxy.sellCat();
    }

    @Test
    public void test555() {
        /*System.out.println("fastUUID:"+ UUID.fastUUID());
        System.out.println("toString:"+ UUID.randomUUID());
        System.out.println("toString:"+ UUID.randomUUID());*/
        System.out.println("toString:"+ UUID.randomUUID().toString().replace("-",""));

    }



}
