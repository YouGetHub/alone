package com.controller;

public class test {
    public static void main(String[] args) {
        String reg = "0?(13|14|15|18)[0-9]{9}";
        String str = "15611202171";
        boolean matches = str.matches(reg);
        System.out.println(matches);
    }
}
