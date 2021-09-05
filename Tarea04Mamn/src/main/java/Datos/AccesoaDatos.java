/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Dominio.mdEmpleado;
import Excepciones.AccesoDatos;
import Excepciones.EscrituraDatos;
import Excepciones.LecturaDatos;
import java.util.List;

/**
 *
 * @author Marjorie
 */
public interface AccesoaDatos {
    
    boolean existe(String nombreArchivo) throws AccesoDatos;
    public List<mdEmpleado> listar(String nombreArchivo) throws LecturaDatos;
    void escribir(String Info, String nombreArchivo, boolean anexar)throws EscrituraDatos;
    public void crear(String nombreArchivo)throws AccesoDatos;
    public void borrar(String nombreArchivo)throws AccesoDatos;     
}
