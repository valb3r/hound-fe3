package com.aurea.antipatterns.featureenvy.usecase;

/**
 * Created by valb3r on 31.05.16.
 */
public class ReferenceClass {
    public ReferenceClass reference;

    public int someMethod() {
        return 111;
    }

    public int someArgMethod(int value) {
        return 111;
    }

    public int someArg2Method(int value1, int value2) {
        return 111;
    }

    public int someArg2BMethod(boolean value1, boolean value2) {
        return 111;
    }

    public int someArg2SMethod(String value1, String value2) {
        return 111;
    }

    public int someArgMethod(GetSetOnlyClass cl) {
        return 112;
    }

    public int someArg2Method(GetSetOnlyClass cl1, GetSetOnlyClass cl2) {
        return 112;
    }

    public ReferenceClass getRef() {
        return reference;
    }

    public static void staticMtd() {};
}
