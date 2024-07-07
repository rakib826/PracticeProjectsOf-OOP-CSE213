package com.midterm2220936sec6;

public class Computer {
    private int serialNo;
    private String brand;
    private String model;
    private float price;
    private boolean hasGPU;
    private int noOfGPUCore;

    public Computer(int serialNo, String brand, String model, float price, boolean hasGPU, int noOfGPUCore) {
        this.serialNo = serialNo;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.hasGPU = hasGPU;
        this.noOfGPUCore = noOfGPUCore;
    }

    public Computer(int serialNo, String brand, String model, float price) {
        this.serialNo = serialNo;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }
    public updatePriceWithVat(price){

    }

    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isHasGPU() {
        return hasGPU;
    }

    public void setHasGPU(boolean hasGPU) {
        this.hasGPU = hasGPU;
    }

    public int getNoOfGPUCore() {
        return noOfGPUCore;
    }

    public void setNoOfGPUCore(int noOfGPUCore) {
        this.noOfGPUCore = noOfGPUCore;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "serialNo=" + serialNo +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", hasGPU=" + hasGPU +
                ", noOfGPUCore=" + noOfGPUCore +
                '}';
    }
}
