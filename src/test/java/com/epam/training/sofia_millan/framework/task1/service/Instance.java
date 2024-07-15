package com.epam.training.sofia_millan.framework.task1.service;

public class Instance {

    public static String instance(){
        return TestDataReader.getTestData("testdata.instances.number");
    }
}
