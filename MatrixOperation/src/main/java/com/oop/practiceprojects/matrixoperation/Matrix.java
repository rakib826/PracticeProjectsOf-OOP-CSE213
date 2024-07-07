package com.oop.practiceprojects.matrixoperation;

import java.util.Arrays;

public class Matrix {
    int[][] vals;

    public Matrix(int[][] vals) {
        this.vals = vals;
    }
    public Matrix(int row, int col) {
        this.vals = new int[row][col];
    }

    public int[][] getVals() {
        return vals;
    }

    public void setVals(int[][] vals) {
        this.vals = vals;
    }

    @Override
    public String toString() {
        String str = "";
        int i,j;
        for(i=0;i<vals.length;i++){
            for(j=0;j<vals[i].length;j++){
                str += vals[i][j] + " ";
            }
            str += "\n";
        }
        return str;
    }

    public Matrix add( Matrix m){
        Matrix temp = null;
        if(this.vals.length == m.vals.length && this.vals[0].length == m.vals[0].length){
            temp = new Matrix(this.vals.length,this.vals[0].length);
            int i,j;
            for(i=0;i<vals.length;i++) {
                for (j = 0; j < vals[i].length; j++){
                    temp.vals[i][j] = this.vals[i][j] + m.vals[i][j];
                }
            }
        }
        return temp;
    }
}
