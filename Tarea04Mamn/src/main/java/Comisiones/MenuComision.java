/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comisiones;

import Negocio.CatalogoEmpleadosImpl;
import Negocio.CatalogoNegocio;
import java.util.Scanner;

/**
 *
 * @author Marjorie
 */
public class MenuComision {
    CatalogoNegocio Cat = new CatalogoNegocio();
    private static final CatalogoEmpleadosImpl Ca = new CatalogoEmpleadosImpl();
    private static final String nombreArchivo = "C:\\Users\\Usuario\\Desktop\\Semana 7\\Textos\\Comision.txt";
    
    public void Menu(){
    Scanner Lector=new Scanner(System.in);
        String op = "";
        int op2 = 0;
        
        do {      
        System.out.println("- MENU - \n"
                + "1) Archivo \n"
                + "2) Ingresar informacion \n"
                + "3) Venta mayor y menor \n"
                + "4) Venta total \n"
                + "5) Editar \n"
                + "6) Buscar \n"
                + "7) Tabla \n"
                + "8) Salir \n");
        System.out.println("Elije la opción que deseas: "); op=Lector.nextLine();
        
        switch(op){
             case "1":
                Ca.IniciarArchivo(nombreArchivo);
                break;
            case "2":
                Cat.AgregarInformacion();
                Ca.CargarInformacion(nombreArchivo);
                Ca.Calculos();
                break;
            case "3":
                Ca.VentaMayor();
                System.out.println("\n");
                Ca.VentaMenor();
                break;
            case "4":
                Ca.VentaMayorTotal();
                break;
            case "5":
               Ca.Editar();
                break;
            case "6":
                Ca.Buscar();
                break;
            case "7":
                Ca.ImprimirInformacion();
                break;
          }
        } while(!op.equals("8"));
        
        System.out.println("Deseas salir\n"
                + "9 Salir\n"
                + "1 Menu");
        System.out.println("Opcion: "); op2 = Lector.nextInt();
         
        if (op2==9) {
            System.exit(0);
        }
        if (op2==1) {
            Menu();
        }
    }
}