package com.epam.training.sofia_millan.framework.task1.model;

/**
 * This class represents the configuration for a Google Cloud instance and provides
 * getter and setter methods to access and modify its attributes.
 * @author Sofía Millán
 */
public class Instance {
    private String number;
    private String operatingSystem;
    private String provisioningModel;
    private String machineFamily;
    private String series;
    private String machineType;
    private String gpuModel;
    private String numberGpus;
    private String localSSD;
    private String region;
    private String committedUse;

    public Instance(String number, String os, String model, String machineFamily, String series,
                    String machineType, String gpuModel, String numberGpus, String localssd, String region, String comittedUse) {
        this.number = number;
        this.operatingSystem = os;
        this.provisioningModel = model;
        this.machineFamily = machineFamily;
        this.series = series;
        this.machineType = machineType;
        this.gpuModel = gpuModel;
        this.numberGpus = numberGpus;
        this.localSSD = localssd;
        this.region = region;
        this.committedUse = comittedUse;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public void setProvisioningModel(String provisioningModel) {
        this.provisioningModel = provisioningModel;
    }

    public void setMachineFamily(String machineFamily) {
        this.machineFamily = machineFamily;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public void setGpuModel(String gpuModel) {
        this.gpuModel = gpuModel;
    }

    public void setNumberGpus(String numberGpus) {
        this.numberGpus = numberGpus;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCommittedUse(String committedUse) {
        this.committedUse = committedUse;
    }

    public String getNumber() {
        return number;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getProvisioningModel() {
        return provisioningModel;
    }

    public String getMachineFamily() {
        return machineFamily;
    }

    public String getSeries() {
        return series;
    }

    public String getMachineType() {
        return machineType;
    }

    public String getGpuModel() {
        return gpuModel;
    }

    public String getNumberGpus() {
        return numberGpus;
    }

    public String getRegion() {
        return region;
    }

    public String getCommittedUse() {
        return committedUse;
    }
    public String getLocalSSD() {
        return localSSD;
    }
}
