package com.epam.training.sofia_millan.framework.task1.service;

import com.epam.training.sofia_millan.framework.task1.model.Instance;

public class InstanceCreator {

    public static String instance(){
        return TestDataReader.getTestData("testdata.instances.number");
    }

    public static Instance getInstance(){
        return new Instance(
                TestDataReader.getTestData("testdata.instances.number"),
                TestDataReader.getTestData("testdata.instances.os"),
                TestDataReader.getTestData("testdata.instances.model"),
                TestDataReader.getTestData("testdata.instances.machinefamily"),
                TestDataReader.getTestData("testdata.instances.series"),
                TestDataReader.getTestData("testdata.instances.machinetype"),
                TestDataReader.getTestData("testdata.instances.gpumodel"),
                TestDataReader.getTestData("testdata.instances.numbergpus"),
                TestDataReader.getTestData("testdata.instances.region"),
                TestDataReader.getTestData("testdata.instances.committeduse"));
    }
}
