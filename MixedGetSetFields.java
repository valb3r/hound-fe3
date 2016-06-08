package com.aurea.antipatterns.featureenvy.usecase;

/**
 * This class must be ignored as is a data class
 * Created by valb3r on 03.06.16.
 */
public class MixedGetSetFields {
    private int intVal;
    private String strVal;
    private ReferenceClass refVal;

    public int refIntVal;
    public String refStrVal;
    public ReferenceClass refRefVal;

    public int getIntVal() {
        return intVal;
    }

    public void setIntVal(int intVal) {
        this.intVal = intVal;
    }

    public String getStrVal() {
        return strVal;
    }

    public void setStrVal(String strVal) {
        this.strVal = strVal;
    }

    public ReferenceClass getRefVal() {
        return refVal;
    }

    public void setRefVal(ReferenceClass refVal) {
        this.refVal = refVal;
    }
}
