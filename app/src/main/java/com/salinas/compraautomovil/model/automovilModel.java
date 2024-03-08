package com.salinas.compraautomovil.model;

public class automovilModel {

    //Datos del TDA
    private int marca;
    private int origen;
    private double costo;
    private double impuesto;


    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    public int getOrigen() {
        return origen;
    }

    public void setOrigen(int origen) {
        this.origen = origen;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    //Operaciones
    public String calcularCostoAutomovil(){
        String resultadoCostoAutomovil="";
        double total, ganancia;

        if(origen==1) {
            impuesto=costo*0.20;
        } else {
            if(origen==2) {
                impuesto = costo*0.30;
            }if(origen==3) {
                impuesto = costo*0.15;
            } else {
                if(origen==4) {
                    impuesto = costo*0.08;
                }
            }
        }
        ganancia=costo*0.22;
        total=(costo+impuesto)+ganancia;

        resultadoCostoAutomovil="Marca Num." + marca
                +"\nCosto: " + costo  + " $ "
                +"\nImpuesto a pagar: " +  impuesto  + " $ "
                +"\nGanancias: " + ganancia + " $ "
                +"\nTotal: " + total + " $ ";

        return resultadoCostoAutomovil;

    }


}
