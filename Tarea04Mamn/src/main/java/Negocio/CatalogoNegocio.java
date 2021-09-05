/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.util.Scanner;

/**
 *
 * @author Marjorie
 */
public class CatalogoNegocio {
    Scanner Lector = new Scanner(System.in);
    private static final CatalogoEmpleadosImpl Cat = new CatalogoEmpleadosImpl();
    private static final String nombreArchivo = "C:\\Users\\Usuario\\Desktop\\Semana 7\\Textos\\Comision.txt";
    
    public void AgregarInformacion(){
        String Nombre = "", Guardar = "";
        Double Enero=0.0,Febrero=0.0,Marzo=0.0,VentasT=0.0,Promedio=0.0;
        System.out.println("Numero de personas a ingresar: ");
        int C = Lector.nextInt();
        for (int i = 0; i <C; i++) {          
            System.out.println("Ingresa el nombre:");
            Nombre=Lector.nextLine();
            Nombre=Lector.nextLine();
            System.out.println("Ingresa las ventas de Enero:");
            Enero=Lector.nextDouble();
            System.out.println("Ingresa las ventas de Febrero:");
            Febrero=Lector.nextDouble();
            System.out.println("Ingresa las ventas de Marzo:");
            Marzo=Lector.nextDouble();
            VentasT=(Enero+Febrero+Marzo);
            Promedio =(VentasT/3);
            Guardar=(Nombre+";"+Enero+";"+Febrero+";"+Marzo+";"+VentasT+";"+Promedio+";");
            Cat.AgregarInformacion(Guardar, nombreArchivo);
            }
    }
}
