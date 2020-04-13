package com.whf.study.jzoffer;

public class Power {

    public double power(double base, int exponent) {
        if(exponent == 0) {
            return 1;
        } else if(exponent == 1 ) {
            return base;
        } else if(exponent > 0) {
            return base * power(base,exponent - 1 );
        } else {
             return  power(base,exponent + 1) / base;
        }
    }

    public static void main(String[] args) {
        double power = new Power().power(2, -4);
        System.out.println(power);
    }

}
