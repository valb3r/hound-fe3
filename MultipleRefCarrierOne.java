package com.aurea.antipatterns.featureenvy.usecase;

/**
 * Created by valb3r on 31.05.16.
 */
public class MultipleRefCarrierOne {
    public RefClassOne ref;
    public RefClassTwo ref2;

    MultipleRefCarrierOne cycleRef1;
    MultipleRefCarrierTwo cycleRef2;

    BaseCase baseCase;

    public static String staticOne = "Static";
    public static final String staticFinalOne = "Final";

    public static MultipleRefCarrierOne staticClassOne = new MultipleRefCarrierOne();
    public static final MultipleRefCarrierOne staticClassFinalOne = null;

    public enum EnumCounts {ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN}

    public ReferenceClass reference;

    public int refField;
    public int refField2;

    public int getInt() {return -1;}

    MultipleRefCarrierOne() {}

    public void methodOne() {
        ref = null;
        refField = 0;
    }

    public void methodTwo() {
        ref2 = null;
        refField2 = 0;
    }

    public void methodThree() {
        ref = null;
        ref2 = null;
        refField2 = 0;
    }

    public RefClassOne refMethod() {
        return ref;
    }

    public RefClassTwo refMethod2() {
        return ref2;
    }

    public Object refCycleMethod1MultipleRefCarrierOne() {
        return cycleRef1;
    }

    public Object refCycleMethod2MultipleRefCarrierTwo() {
        return cycleRef2;
    }

    public MultipleRefCarrierOne refCycleMethod1() {
        return cycleRef1;
    }

    public MultipleRefCarrierTwo refCycleMethod2() {
        return cycleRef2;
    }

    public <T> T templated () {
        return null;
    }
}
