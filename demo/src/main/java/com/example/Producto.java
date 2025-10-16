package com.example;

public class Producto {

    private String nombre;
    private float cantidad;
    private boolean comprado;
    private float totalCompra;

    
    public Producto(String nombre, float cantidad) {

    
        this.nombre = nombre;
        this.cantidad = cantidad;
            this.comprado = false;
    }


    public String info(){

        String info = "Nombre producto :"+this.getNombre()+"\n";
        info += "Cantidad :"+this.getCantidad()+"\n";
        info += "Comprado :"+this.isComprado()+"\n";
        info += "Total Compra:"+this.getTotalCompra()+"\n";

        return info;
    }


    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public float getCantidad() {
        return cantidad;
    }
    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }
    public boolean isComprado() {
        return comprado;
    }
    public void setComprado(boolean comprado) {
        this.comprado = comprado;
    }
    public float getTotalCompra() {
        return totalCompra;
    }
    public void setTotalCompra(float totalCompra) {
        this.totalCompra = totalCompra;
    }
    

}
