package com.aurea.antipatterns.featureenvy.usecase;

import java.util.ArrayList;
import java.util.List;

/**
 * null and literals are ignored by class filter through -l argument of runner script
 * Created by valb3r on 31.05.16.
 */
public class BaseCase extends BaseClass {
    MultipleRefCarrierOne locRef1;
    MultipleRefCarrierTwo locRef2;

    int locField1;
    String locField2;
    String locField3;

    public void localMethod1() {
    }

    public int localMethod2() {
        return 99;
    }

    public void localMethod3() {
    }

    public MultipleRefCarrierOne getLocRef1() {
        return locRef1;
    }

    public MultipleRefCarrierTwo getLocRef2() {
        return locRef2;
    }

    private void notDetected(int value, MultipleRefCarrierOne one) {
        locField1 = 12;
        locField1 = 13;
        locField1 = 14;
        locField1 = 15;
        locRef1.methodOne();
        locRef1.methodTwo();
        locRef1.methodThree();
    }

    private void notDetected2(int value, MultipleRefCarrierOne one) {
    }

    private void notDetected3() {
        this.locRef1.cycleRef1.cycleRef2.cycleRef1.cycleRef1.cycleRef2 = null;
        this.locRef1 = null;
    }

    private void notDetected4() {
        //system must go to other
        System.out.print(true);
        System.out.print(true);
        System.out.print(true);
        System.out.print(true);
        locRef1.methodOne();
        locRef1.methodTwo();
    }

    private void notDetected5() {
        //system must go to other
        System.console();
        System.console();
        System.console();
        System.console();
        locRef2.methodTwo();
        locRef2.methodOne();
    }

    private void notDetected6() {
        //system must go to other
        System.out.append('c').print("AA");
        System.out.append('c').print("AA");
        System.out.append('c').print("AA");
        System.out.append('c').print("AA");
        locRef1.methodOne();
        locRef1.methodTwo();
    }

    private void detection1(int value, MultipleRefCarrierOne one) {
        one.methodOne();
        one.methodTwo();
        one.methodThree();
    }

    private void detection2(int value, MultipleRefCarrierOne one) {
        locRef1.methodOne();
        locRef1.methodTwo();
        locRef1.methodThree();
    }

    private void detection3() {
        this.locRef1.cycleRef1.cycleRef2.cycleRef1.cycleRef2.cycleRef1 = null;
        this.locRef1.cycleRef2.methodTwo();
        this.locRef2.cycleRef2.methodOne();
        this.locRef1 = null;
    }

    private void detection4() {
        this.locRef1.cycleRef1.cycleRef2.cycleRef1.cycleRef2.cycleRef1 = null;
        this.locRef1.cycleRef1.cycleRef2.cycleRef1 = null;
        this.locRef1.cycleRef1.cycleRef2.cycleRef1 = this.locRef2.cycleRef1;
        this.locRef1 = null;
        this.locField1 = 11;
    }

    private void detection5() {
        locRef1.refCycleMethod1().refCycleMethod1().refCycleMethod1().refCycleMethod1();
        locRef2.refCycleMethod2().refCycleMethod2().refCycleMethod2().refCycleMethod2().refCycleMethod2()
                .refCycleMethod2();
    }

    private void detection6() {
        locRef1.cycleRef2.refCycleMethod1().refCycleMethod2().refCycleMethod1().refCycleMethod2();
        locRef2.refCycleMethod2().refCycleMethod1().refCycleMethod2().refCycleMethod1().refCycleMethod2().refCycleMethod1();
    }

    public class InnerClass {
        private void notDetected7() {
            locRef1.ref = null;
            localMethod1();
            localMethod1();
        }

        private void notDetected8() {
            locRef1.ref = null;
            locRef1.ref = null;
            innerMethod();
            innerMethod();
        }

        private void detection7() {
            locRef1.ref = locRef1.ref;
            locRef1.ref = locRef1.ref;
            localMethod1();
        }

        private void innerMethod() {
        }
    }

    private int notDetected9() {
        locRef1.<ReferenceClass>templated().getRef();
        locRef2.<ReferenceClass>templated().getRef();
        return 0;
    }

    private int detection8() {
        // T
        locRef1.refCycleMethod1().<MultipleRefCarrierOne>templated().refCycleMethod1().refCycleMethod1().refCycleMethod1().refCycleMethod1().refCycleMethod1();
        return 0;
    }

    private Integer notDetected10() {
        List<List<Integer>> tst = new ArrayList<>(new ArrayList<>());
        List<Integer> tst2 = tst.get(0);
        return tst2.get(0);
    }

    private void detection9() {
        doSomeBase();
        locRef1.ref = null;
        locRef1.ref = null;
        locRef1.refCycleMethod1();
    }

    private void notDetected11() {
        doSomeBase();
        doSomeBase();
        doSomeBase();
        (new BaseClass()).doSomeBase();
        locRef1.ref = null;
        locRef1.ref = null;
    }

    private void notDetected12() {
        baseField = 12;
        baseField = 12;
        locRef1.ref = null;
        locRef1.ref = null;
    }

    private void notDetected13() {
        (this).baseField = 12;
        (this).baseField = 12;
        locRef1.ref = null;
        locRef1.ref = null;
        locRef1.ref = null;
    }

    private int detection10() {
        // T
        locRef1.refCycleMethod1().<MultipleRefCarrierOne>templated();
        return 0;
    }

    private void detection11() {
        (this.locRef1.cycleRef1) = new MultipleRefCarrierOne();
        (this.locRef1.cycleRef2) = null;
        (this.locRef1.cycleRef1).methodOne();
        this.locRef1 = null;
    }

    private void notDetected14() {
        (locRef1) = null;
        (locRef1) = null;
        (this.getLocRef1()).cycleRef1 = null;
        (this.getLocRef1()).cycleRef1 = null;
    }

    private void detection12() {
        ((this.getLocRef1()).cycleRef1) = null;
        ((this.getLocRef1().refCycleMethod1()).refCycleMethod1()).cycleRef1 = null;
        this.locRef1.cycleRef1 = null;
    }

    private void detection13() {
        locRef1 = null;
        Object ref = new MultipleRefCarrierOne();
        ((MultipleRefCarrierOne) (ref)).refCycleMethod1();
        ((MultipleRefCarrierOne) (ref)).refCycleMethod1();
        ((MultipleRefCarrierOne) (ref)).refCycleMethod1();
        ((MultipleRefCarrierOne) this.locRef2.refCycleMethod1MultipleRefCarrierOne()).refCycleMethod1();
    }

    private int detection14() {
        // T
        locRef1.cycleRef1.<MultipleRefCarrierOne>templated();
        locRef1.cycleRef1.<MultipleRefCarrierOne>templated();
        return 0;
    }

    private int detection15() {
        (new MultipleRefCarrierOne()).cycleRef1 = null;
        locRef1.cycleRef1 = null;
        return 0;
    }

    private void notDetected15() {
        // enum counts
    }

    private int detection16() {
        ((BaseClass) new BaseCase()).baseField = 0;
        ((BaseClass) new BaseCase()).baseField = 0;
        BaseClass a = new BaseCase();
        a.doSomeBase();
        a.doSomeBase();
        a.doSomeBase();
        return 0;
    }

    private int detection17() {
        ((BaseClass) new BaseCase()).doSomeBase();
        ((BaseClass) new BaseCase()).doSomeBase();
        BaseClass a = new BaseCase();
        a.doSomeBase();
        a.doSomeBase();
        a.doSomeBase();
        return 0;
    }

    private void notDetected16() {
        (new BaseCase()).baseField = 0;
        (new BaseCase()).baseField = 0;
        this.locRef1.ref = null;
        this.locRef1.ref = null;
    }

    private String detection18(MultipleRefCarrierOne.EnumCounts unit) {
        switch (unit) {
            case ONE:
                return "nanos";
            case TWO:
                return "micros"; // s
            case THREE:
                return "ms";
            case FOUR:
                return "s";
            case FIVE:
                return "min";
            case SIX:
                return "h";
            case SEVEN:
                return "d";
            default:
                throw new AssertionError();
        }
    }

    private void notDetected17(MultipleRefCarrierOne.EnumCounts unit) {
        //enum counts
    }

    @Override
    void overrideMe() {
        //
    }

    private String detection19() {
        overrideMe();
        overrideMe();
        locRef1.ref = null;
        locRef1.ref = null;
        locRef1.ref = null;
        locRef1.ref = null;
        return "";
    }

    private String notDetected18() {
        overrideMe();
        overrideMe();
        return "";
    }

    private String detection20() {
        MultipleRefCarrierOne var = new MultipleRefCarrierOne();
        var.refCycleMethod1();
        var.refCycleMethod1();
        return "";
    }

    private String notDetected19() {
        BaseCase var = new BaseCase();
        var.localMethod1();
        var.localMethod1();
        return "";
    }

    private void notDetected20() {
        MultipleRefCarrierOne var = new MultipleRefCarrierOne();
        var.baseCase.localMethod1();
        var.baseCase.localMethod1();
    }

    private void detection21() {
        MultipleRefCarrierOne var = new MultipleRefCarrierOne();
        var.baseCase.localMethod1();
        var.baseCase.localMethod1();
        var.refCycleMethod1();
        var.refCycleMethod1();
        var.refCycleMethod1();
        var.refCycleMethod1();
    }

    private void notDetected21() {
        MultipleRefCarrierOne var1 = new MultipleRefCarrierOne();
        locRef2.refCycleMethod1();
        locRef2.refCycleMethod1();
    }

    private void detection22() {
        locRef1.refCycleMethod1();
        locRef2.refCycleMethod1();
        locRef1.refCycleMethod1();
        locRef2.refCycleMethod1();
        locRef1.refCycleMethod1();
        locRef2.refCycleMethod1();
        doSomeBase();
        doSomeBase();
        localMethod1();
        localMethod1();
        getLocRef1().refCycleMethod1().cycleRef1.refCycleMethod1().methodOne();
        getLocRef1().refCycleMethod2().methodOne();
        getLocRef1().refCycleMethod1().refCycleMethod1().cycleRef1.cycleRef1.refCycleMethod1().methodOne();
        getLocRef1().ref = null;
        locRef1.ref = null;
        locRef1.ref = null;
    }

    private void detection23() {
        int value = locRef1.refField + locRef1.refField;
    }

    private void detection24() {
        int value = locRef1.getInt() + (locRef1.cycleRef1.getInt());
    }

    public void notDetected33() {
        super.overrideMe();
        super.overrideMe();
        super.overrideMe();
    }

    private void detection41() {
        MultipleRefCarrierOne.EnumCounts enum111;
        enum111 = MultipleRefCarrierOne.EnumCounts.ONE;
        enum111 = MultipleRefCarrierOne.EnumCounts.TWO;
        enum111 = MultipleRefCarrierOne.EnumCounts.THREE;
        enum111 = MultipleRefCarrierOne.EnumCounts.FOUR;
    }
}
