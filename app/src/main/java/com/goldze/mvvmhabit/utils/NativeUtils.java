package com.goldze.mvvmhabit.utils;


public class NativeUtils {

    static {
        System.loadLibrary("native");
    }

    public static native String encrypt(String plaintext, int offset);

}
