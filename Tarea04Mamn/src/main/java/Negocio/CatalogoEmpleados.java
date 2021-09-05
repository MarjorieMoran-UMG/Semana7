/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Marjorie
 */
public interface CatalogoEmpleados {
    
    public void AgregarInformacion(String Info,String nombreArchivo);
    public void IniciarArchivo(String nombreArchivo);
    public void CargarInformacion(String nombreArchivo);
    public void Calculos();
    public void ImprimirInformacion();
    public void VentaMenor();
    public void VentaMayor();
    public void VentaMayorTotal();
    public void Editar();
    public void Buscar();
}
