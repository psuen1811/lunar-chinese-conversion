package com.suanla.ziwei.lunar;

/**
 * Created by psuen on 3/22/14.
 */
public class SolarTerms {
    private int sectionalTerm;
    private int principleTerm;

    public SolarTerms() {
    }

    public SolarTerms(int sectionalTerm, int principleTerm) {
        this.sectionalTerm = sectionalTerm;
        this.principleTerm = principleTerm;
    }

    public int getSectionalTerm() {
        return sectionalTerm;
    }

    public void setSectionalTerm(int sectionalTerm) {
        this.sectionalTerm = sectionalTerm;
    }

    public int getPrincipleTerm() {
        return principleTerm;
    }

    public void setPrincipleTerm(int principleTerm) {
        this.principleTerm = principleTerm;
    }
}
