package com.oop.courseproject.complexnumberoperation;

public class ComplexNo {
    private int real;
    private int imaginary;

    public ComplexNo(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNo add(ComplexNo other) {
        return new ComplexNo(this.real + other.real, this.imaginary + other.imaginary);
    }

    public ComplexNo subtract(ComplexNo other) {
        return new ComplexNo(this.real - other.real, this.imaginary - other.imaginary);
    }

    @Override
    public String toString() {
        return this.real + " + " + this.imaginary + "i";
    }
}
