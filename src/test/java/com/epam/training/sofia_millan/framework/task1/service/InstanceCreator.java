package com.epam.training.sofia_millan.framework.task1.service;

import com.epam.training.sofia_millan.framework.task1.model.Instance;

public class InstanceCreator {
    private static final String NUMBER_INSTANCES = "testdata.instances.number";
    private static final String OPERATING_SYSTEM = "testdata.instances.os";
    private static final String PROVISIONING_MODEL = "testdata.instances.model";
    private static final String MACHINE_FAMILY = "testdata.instances.machinefamily";
    private static final String SERIES = "testdata.instances.series";
    private static final String MACHINE_TYPE = "testdata.instances.machinetype";
    private static final String GPU_MODEL = "testdata.instances.gpumodel";
    private static final String NUMBER_GPUS = "testdata.instances.numbergpus";
    private static final String REGION = "testdata.instances.region";
    private static final String COMMITTED_USE = "testdata.instances.committeduse";
    private static final String LOCAL_SSD = "testdata.instances.localssd";

    public static Instance getInstance(){
        return new Instance(
                TestDataReader.getTestData(NUMBER_INSTANCES),
                TestDataReader.getTestData(OPERATING_SYSTEM),
                TestDataReader.getTestData(PROVISIONING_MODEL),
                TestDataReader.getTestData(MACHINE_FAMILY),
                TestDataReader.getTestData(SERIES),
                TestDataReader.getTestData(MACHINE_TYPE),
                TestDataReader.getTestData(GPU_MODEL),
                TestDataReader.getTestData(NUMBER_GPUS),
                TestDataReader.getTestData(LOCAL_SSD),
                TestDataReader.getTestData(REGION),
                TestDataReader.getTestData(COMMITTED_USE));
    }
}
