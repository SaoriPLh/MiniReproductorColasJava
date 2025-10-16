package com.example;




public class Nodito {
    private Paiss ifo ;
    private Nodito sig;


    public Nodito(Paiss info) {
        this.ifo = info;
        this.sig = null;
    }

    public Nodito(){

        
    }
    public Paiss getIfo() {
        return ifo;
    }


    public void setIfo(Paiss ifo) {
        this.ifo = ifo;
    }


    public Nodito getSig() {
        return sig;
    }


    public void setSig(Nodito sig) {
        this.sig = sig;
    }
}
