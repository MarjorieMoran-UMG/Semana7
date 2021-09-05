/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.AccesoaDatos;
import Datos.AccessoaDatosImpl;
import Dominio.mdEmpleado;
import Excepciones.AccesoDatos;
import Excepciones.LecturaDatos;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Marjorie
 */
public class CatalogoEmpleadosImpl implements CatalogoEmpleados {

    List<mdEmpleado> C = new ArrayList<mdEmpleado>();
    Scanner Lector = new Scanner(System.in);
    double SEnero, SFebrero,SMarzo;
    
    private final AccesoaDatos A;
    
    public CatalogoEmpleadosImpl (){
        this.A = new AccessoaDatosImpl();
    }
    
    @Override
    public void AgregarInformacion(String Info, String nombreArchivo) {
        boolean anexar = false;
        try {
            anexar = A.existe(nombreArchivo);
            A.escribir(Info,nombreArchivo, anexar);
        } catch (AccesoDatos ex) {
            System.out.println("Existe un error");
            ex.printStackTrace();
        }
    }

    @Override
    public void IniciarArchivo(String nombreArchivo) {
         try {
            if(A.existe(nombreArchivo)){
                A.borrar(nombreArchivo);
                A.crear(nombreArchivo);
            } else {
                A.crear(nombreArchivo);
            }
        } catch (AccesoDatos ex) {
            System.out.println("Existe un error");
            ex.printStackTrace();
        }
    }

    @Override
    public void CargarInformacion(String nombreArchivo) {
         try {
            C = A.listar(nombreArchivo);
        } catch (LecturaDatos ex){
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        } 
    }

    @Override
    public void Calculos() {
        SEnero = 0.0; SFebrero = 0.0; SMarzo = 0.0;
        for (mdEmpleado emp : C){
             SEnero+=emp.getEnero();
             SFebrero+=emp.getFebrero();
             SMarzo+=emp.getMarzo();
             emp.setVentasTotales(emp.getEnero() + emp.getFebrero() + emp.getMarzo());
             emp.setPromedio(emp.getVentasTotales() / 3);
             emp = new mdEmpleado();
        } 
    }

    @Override
    public void ImprimirInformacion() {
        System.out.println("\n..Nombre..Enero..Febrero..Marzo..Total..Promedio");
        for(mdEmpleado emp : C){
            System.out.println(".."+emp.getNombre()+"..Q"+emp.getEnero()+"..Q"+emp.getFebrero()+"..Q"+emp.getMarzo()+"..Q"+emp.getVentasTotales()+"..Q"+emp.getPromedio());     
        }
        System.out.println("\nVentas totales de los meses:");
        System.out.println("Enero: Q"+SEnero);
        System.out.println("Febrero: Q"+SFebrero);
        System.out.println("Marzo: Q"+SMarzo+"\n");
    }

    @Override
    public void VentaMenor() {
        String Ene="", Feb="", Mar="";
         Double ene=1000000000000.0, feb=1000000000000.0, mar=1000000000000.0;
         for (mdEmpleado emp : C) {
             if (ene >emp.getEnero()) {
                 ene =emp.getEnero();
                 Ene =emp.getNombre();
             }
             if (feb >emp.getFebrero()) {
                 feb =emp.getFebrero();
                 Feb =emp.getNombre();
             }
             if (mar >emp.getMarzo()) {
                 mar =emp.getMarzo();
                 Mar =emp.getNombre();
             }
         }
         System.out.println("Persona con Menor venta en Enero "+Ene+" Total: Q"+ene);
         System.out.println("Persona con Menor venta en Febrero "+Feb+" Total: Q"+feb);
         System.out.println("Persona con Menor venta en Marzo "+Mar+" Total: Q"+mar);
    }

    @Override
    public void VentaMayor() {
        String Ene="", Feb="", Mar="";
         Double ene=0.0, feb=0.0, mar=0.0;
         for (mdEmpleado emp : C) {
             
             if (ene <emp.getEnero()) {
                 ene =emp.getEnero();
                 Ene =emp.getNombre();
             }
             if (feb <emp.getFebrero()) {
                 feb =emp.getFebrero();
                 Feb =emp.getNombre();
             }
             if (mar <emp.getMarzo()) {
                 mar =emp.getMarzo();
                 Mar =emp.getNombre();
             }
         }
         System.out.println("Persona con Mayor venta en Enero "+Ene+" Total: Q"+ene);
         System.out.println("Persona con Mayor venta en Febrero "+Feb+" Total: Q"+feb);
         System.out.println("Persona con Mayor venta en Marzo "+Mar+" Total: Q"+mar);         
    }

    @Override
    public void VentaMayorTotal() {
        String Mayor = "";
        Double NumMayor = 0.0;
        for(mdEmpleado emp: C){
            if (NumMayor<emp.getVentasTotales()) {
                NumMayor =emp.getVentasTotales();
                Mayor =emp.getNombre();
                
            }
        }
        System.out.println("Persona con Mayor venta "+Mayor+" con un Total Q"+NumMayor);
    }

    @Override
    public void Editar() {
        int ele=0, ele1=0, a=0, indice=0 ;
        String Name = "";
        double cant = 0.0;
        
        System.out.println("¿Deseas hacer alguna modificacion?\n"
                + "1) En el Nombre\n"
                + "2) En la Cantidad");
        ele = Lector.nextInt();
        
        if (ele==1) {
            System.out.println("¿Cual nombre deseas modificar? ");
            for (mdEmpleado emp : C) {
                System.out.println("Indice "+a+" = "+emp.getNombre());
                a++;
            }
            System.out.println("Cual es el indice del nombre a modificar ");
            indice=Lector.nextInt();
            System.out.println("Ingresa el nuevo nombre ");
            Name=Lector.nextLine();
            Name=Lector.nextLine();
            C.get(indice).setNombre(Name);
                       
        }
        
        if (ele==2) {
            System.out.println("¿Que mes deseas modificar? \n"
                    + "1) Enero\n"
                    + "2) Febrero\n"
                    + "3) Marzo");
            ele1=Lector.nextInt();
            if (ele1==1) {
                for(mdEmpleado emp: C){
                    System.out.println("El Indice "+a+" = "+emp.getEnero()+" le pertenece a "+emp.getNombre());
                    a++;
                }
            System.out.println("¿Cual es el indice de la cantidad de Enero a modificar? ");
            indice=Lector.nextInt();
            System.out.println("Ingresa la nueva cantidad: ");
            cant=Lector.nextDouble();
            C.get(indice).setEnero(cant);
                
            }
            if (ele1==2) {
               for(mdEmpleado emp: C){
                   System.out.println("Indice "+a+" = "+emp.getFebrero()+" le pertenece a "+emp.getNombre());
                    a++; 
                } 
           System.out.println("¿Cual es el indice de la cantidad de Febrero a modificar? ");
            indice=Lector.nextInt();
            System.out.println("Ingresa la nueva cantidad: ");
            cant=Lector.nextDouble();
            C.get(indice).setFebrero(cant);
            }
            
            if (ele1==3) {
                for(mdEmpleado emp: C){
                   System.out.println("Indice "+a+" = "+emp.getMarzo()+" le pertenece a "+emp.getNombre());
                    a++; 
                }
            System.out.println("¿Cual es el indice de la cantidad de Marzo a modificar?");
            indice=Lector.nextInt();
            System.out.println("Ingresa la nueva cantidad: ");
            cant=Lector.nextDouble();
            C.get(indice).setMarzo(cant);
            }
            Calculos();           
        }     
    }

    @Override
    public void Buscar() {
        String Nombre = "", Mes = "";
        Double Busqueda = 0.0;
        System.out.println("Ingresa la cantidad de Ventas: ");
        Busqueda = Lector.nextDouble();
        for (mdEmpleado emp : C) {
             
            if(emp.getEnero()==Busqueda){
                Mes = "Enero";
                Nombre = emp.getNombre();
            }
            
            if(emp.getFebrero()==Busqueda){
                Mes = "Febrero";
                Nombre = emp.getNombre();
            }
            
            if(emp.getMarzo()==Busqueda){
                Mes = "Marzo";
                Nombre = emp.getNombre();
            }
            
        }       
        System.out.println("Su nombre es: "+Nombre);
        System.out.println("El mes de la venta es: "+Mes);
    }
}
