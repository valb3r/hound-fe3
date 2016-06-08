package com.aurea.antipatterns.featureenvy.usecase;

/**
 * As per Marc's reply
 * Created by valb3r on 03.06.16.
 */
/*
+Treat inner classes as part of the outer class so any features that the inner class calls on the enclosing class are counted as references to itself
+Treat anonymous classes as inner classes of the class that declares them
+Any hardcoded literal should count as a call to self  (under Member variables have the phrase “Local literals” and point the arrow at that phrase)
+Any constants (static fields) should count as a call to self
+Count constructors as features
+Filter out ValueObjects and Structs (C#) - identify classes that only have fields, setters and getters.
 */

public class NewRules extends BaseClass{

    int locRef1;
    int locRef2;
    MultipleRefCarrierOne ref1;
    MultipleRefCarrierTwo ref2;

    public static String localStatic = "AAAAA";

    public MultipleRefCarrierOne getRef1() {
        return new MultipleRefCarrierOne();
    }

    public MultipleRefCarrierTwo getRef2() {
        return new MultipleRefCarrierTwo();
    }

    interface AnonClassIface {
        AnonClassIface detection25();
        AnonClassIface notDetected22();
    }

    public void wrapperForDetection25() {
        (new AnonClassIface() {
            @Override
            public AnonClassIface notDetected22() {
                locRef1 = 0;
                locRef2 = 0;
                ref1.methodOne();
                return this;
            }
            @Override
            public AnonClassIface detection25() {
                locRef1 = 0;
                ref1.methodOne();
                ref1.refField = ref1.refField;
                ref1.refField = ref1.refField;
                return (AnonClassIface) this;
            }
        }).detection25();
    }

    //constructors as features:
    public void detection26() {
        MultipleRefCarrierOne o1 = new MultipleRefCarrierOne();
        MultipleRefCarrierOne o2 = new MultipleRefCarrierOne();
        MultipleRefCarrierOne o3 = new MultipleRefCarrierOne();
        MultipleRefCarrierOne o4 = new MultipleRefCarrierOne();
        ref1 = ref1;
    }

    public void detection27() {
        ref1 = new MultipleRefCarrierOne();
        ref1.cycleRef1 = new MultipleRefCarrierOne();
        ref1.cycleRef1 = new MultipleRefCarrierOne();
        getInt();
    }

    public void notDetected23() {
        ref1 = new MultipleRefCarrierOne();
        ref1 = new MultipleRefCarrierOne();
        ref1 = new MultipleRefCarrierOne();
    }

    public void detection28() {
        ref1.staticOne = ref1.toString();
        ref1.staticOne = ref1.toString();
        ref1.staticOne = ref1.toString();
    }

    public void notDetected24() {
        // were statics
    }

    public void notDetected25() {
        //were statics
    }

    public void notDetected26() {
        //were statics
    }

    public String getStr() {
        return "This is a string";
    }

    public Integer getInt() {
        return 10;
    }

    public ReferenceClass getRefClass() {
        return new ReferenceClass();
    }

    //POJO's

    public void detection29() {
        GetSetOnlyClass gt = new GetSetOnlyClass();
        gt.setIntVal(gt.getIntVal());
        gt.setStrVal(gt.getStrVal());
        gt.setRefVal(gt.getRefVal());
        ref1.cycleRef1 = ref1.cycleRef1;
        ref1.cycleRef1 = ref1.cycleRef1;
        ref1.cycleRef1 = ref1.cycleRef1;
        ref1.methodOne();
        ref1.methodOne();
        ref1.methodOne();
    }

    public void detection30() {
        MixedGetSetFields gt = new MixedGetSetFields();
        gt.setIntVal(gt.getIntVal());
        gt.setStrVal(gt.getStrVal());
        gt.setRefVal(gt.getRefVal());
        gt.setIntVal(gt.refIntVal);
        gt.setStrVal(gt.refStrVal);
        gt.setRefVal(gt.refRefVal);
        ref1.cycleRef1 = ref1.cycleRef1;
        ref1.cycleRef1 = ref1.cycleRef1;
        ref1.cycleRef1 = ref1.cycleRef1;
        ref1.cycleRef1 = ref1.cycleRef1;
        ref1.cycleRef1 = ref1.cycleRef1;
        ref1.cycleRef1 = ref1.cycleRef1;
        ref1.methodOne();
        ref1.methodOne();
        ref1.methodOne();
    }

    public void detection31() {
        FieldsOnlyClass gt = new FieldsOnlyClass();
        gt.refIntVal = gt.refIntVal;
        ref1.methodOne();
        ref1.methodOne();
        ref1.methodOne();
        ref1.methodOne();
        ref1.methodOne();
    }

    public void notDetected27() {
        FieldsOnlyClass gt = new FieldsOnlyClass();
        gt.refRefVal = gt.refRefVal;
        gt.refIntVal = gt.refIntVal;
        gt.refStrVal = gt.refStrVal;
    }

    public void notDetected28() {
        MixedGetSetFields gt = new MixedGetSetFields();
        gt.refRefVal = gt.getRefVal();
        gt.refIntVal = gt.getIntVal();
        gt.refStrVal = gt.getStrVal();
        gt.setIntVal(gt.refIntVal);
        gt.setRefVal(gt.refRefVal);
    }

    public void notDetected29() {
        GetSetOnlyClass gt = new GetSetOnlyClass();
        gt.setIntVal(gt.getIntVal());
        gt.setRefVal(gt.getRefVal());
    }

    private class InnerClassNew {
        public int inner;
        public void someMethod() {}
    }

    // inner class as this
    public void detection32() {
        InnerClassNew n = new InnerClassNew();
        this.ref1.cycleRef1 = ref1.cycleRef1;
        this.ref1.cycleRef1 = ref1.cycleRef1;
    }

    public void notDetected30() {
        InnerClassNew n = new InnerClassNew();
        n.inner = n.inner;
        n.someMethod();
        this.ref1.cycleRef1 = null;
        this.ref1.cycleRef1 = null;
        this.ref1.cycleRef1 = null;
    }

    public void notDetected31() {
        getRefClass().getRef().getRef().someArg2Method(999, 999);
    }

    public void notDetected32() {
        getRefClass().getRef().getRef().someArg2Method(null, null);
    }

    public void detection33() {
        ReferenceClass refClass = getRefClass();
        refClass.someArgMethod(999);
        refClass.someMethod();
        refClass.someMethod();
        refClass.someMethod();
    }

    @Override
    public void detectionOverridden34() {
        ref1.cycleRef1 = ref1.cycleRef1;
        ref1.cycleRef1 = ref1.cycleRef1;
    }

    public void detection35() {
        getRefClass().getRef().getRef().someMethod();
    }

    public void notDetected34() {
        getRefClass().getRef().getRef().someArg2BMethod(true, false);
    }

    public void notDetected35() {
        getRefClass().getRef().getRef().someArg2SMethod("FOO", "BAR");
    }

    public void detection36() {
        ReferenceClass ref1 = new ReferenceClass();
        ref1.someMethod();
        ref1.someMethod();
    }

    public void notDetected36() {
        ReferenceClass ref1 = new ReferenceClass();
        ReferenceClass ref2 = new ReferenceClass();
        ReferenceClass ref3 = new ReferenceClass();
        getInt();
        getInt();
    }

    public void detection37() {
        ReferenceClass ref1 = new ReferenceClass();
        ReferenceClass ref2 = new ReferenceClass();
        ReferenceClass ref3 = new ReferenceClass();
        MultipleRefCarrierOne r1 = new MultipleRefCarrierOne();
    }

    public void detection38() {
        String a;
        a = MultipleRefCarrierOne.staticOne;
        a = MultipleRefCarrierOne.staticOne;
        a = MultipleRefCarrierOne.staticOne;
    }

    public void detection39() {
        String s;
        s = ref1.staticFinalOne;
        s = ref1.staticFinalOne;
        s = ref1.staticFinalOne;
        s = ref1.staticFinalOne;
        ref2.cycleRef1 = ref2.cycleRef1;
    }

    public void detection40() {
        String s;
        s = MultipleRefCarrierOne.staticFinalOne;
        s = MultipleRefCarrierOne.staticFinalOne;
        s = MultipleRefCarrierOne.staticFinalOne;
        s = MultipleRefCarrierOne.staticFinalOne;
        ref2.cycleRef1 = ref2.cycleRef1;
    }

    public void detection41() {
        ReferenceClass r = getRefClass();
        r.staticMtd();
        r.staticMtd();
        r.staticMtd();
    }

    public void detection42() {
        ReferenceClass.staticMtd();
        ReferenceClass.staticMtd();
        ReferenceClass.staticMtd();
    }

    public void notDetected37() {
        String s;
        s = this.localStatic;
        s = this.localStatic;
        s = this.localStatic;
        ref2.cycleRef1 = ref2.cycleRef1;
    }

}
