package com.aurea.antipatterns.featureenvy.usecase;

/**
 * This class must be ignored as is a data class
 * Created by valb3r on 03.06.16.
 */
public class GetSetOnlyClass {
    private int intVal;
    private String strVal;
    private ReferenceClass refVal;

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

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
