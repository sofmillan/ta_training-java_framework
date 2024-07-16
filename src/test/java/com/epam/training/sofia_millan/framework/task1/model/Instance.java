package com.epam.training.sofia_millan.framework.task1.model;

public class Instance {
    private String number;
    private String os;
    private String model;
    private String machineFamily;
    private String series;
    private String machineType;
    private String gpuModel;
    private String numberGpus;
    private String localSSD;
    private String region;
    private String comittedUse;

    public Instance(String number, String os, String model, String machineFamily, String series,
                    String machineType, String gpuModel, String numberGpus, String localssd, String region, String comittedUse) {
        this.number = number;
        this.os = os;
        this.model = model;
        this.machineFamily = machineFamily;
        this.series = series;
        this.machineType = machineType;
        this.gpuModel = gpuModel;
        this.numberGpus = numberGpus;
        this.localSSD = localssd;
        this.region = region;
        this.comittedUse = comittedUse;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setModel(String model) {
        this.model = model;
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

    public void setComittedUse(String comittedUse) {
        this.comittedUse = comittedUse;
    }

    public String getNumber() {
        return number;
    }

    public String getOs() {
        return os;
    }

    public String getModel() {
        return model;
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

    public String getComittedUse() {
        return comittedUse;
    }
}
