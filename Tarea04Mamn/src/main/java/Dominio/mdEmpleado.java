/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author Marjorie
 */
public class mdEmpleado {
    
    private String NombreEmpleado;
    private double Enero;
    private double Febrero;
    private double Marzo;
    private double TotalesVentas;
    private double Promedio;
    
    public String getNombre() {
        return NombreEmpleado;
    }
   
    public void setNombre(String NombreEmpleado) {
        this.NombreEmpleado = NombreEmpleado;
    }

    public double getEnero() {
        return Enero;
    }

    public void setEnero(double Enero) {
        this.Enero = Enero;
    }
   
    public double getFebrero() {
        return Febrero;
    }
   
    public void setFebrero(double Febrero) {
        this.Febrero = Febrero;
    }

    public double getMarzo() {
        return Marzo;
    }

    public void setMarzo(double Marzo) {
        this.Marzo = Marzo;
    }

    public double getVentasTotales() {
        return TotalesVentas;
    }

    public void setVentasTotales(double TotalesVentas) {
        this.TotalesVentas = TotalesVentas;
    }

    public double getPromedio() {
        return Promedio;
    }

    public void setPromedio(double Promedio) {
        this.Promedio = Promedio;
    }    
}
