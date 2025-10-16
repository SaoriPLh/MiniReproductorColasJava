package com.example;




public class NodoCola {
    private int ifo ;
    private NodoCola sig;


    public NodoCola(int info) {
        this.ifo = info;
        this.sig = null;
    }

    public NodoCola(){

        
    }
    public int getIfo() {
        return ifo;
    }


    public void setIfo(int ifo) {
        this.ifo = ifo;
    }


    public NodoCola getSig() {
        return sig;
    }


    public void setSig(NodoCola sig) {
        this.sig = sig;
    }
}
