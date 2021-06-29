package testalertorio;

import alertorio.puntoalertorio;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class pruebapuntoalertorio {
 static Scanner datos = new Scanner(System.in);

    public static void main(String[] args) {

        int nroMovimiento;

        System.out.println("¿Ingrese el numero de movimientos: ");
        nroMovimiento = datos.nextInt();
        puntoalertorio[] puntos = new puntoalertorio[nroMovimiento+1];
        generarMovimientoalertorio(nroMovimiento, puntos);
        distanciaRecorrida(nroMovimiento, puntos);
    }
    public static int numeroRandomico(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
    public static void generarMovimientoalertorio(int n, puntoalertorio punto[]) {
        String sentido = "";
        int a = 0;
        int b = 0;
        int i = 0;
        int valor = 0;
        punto[0] = new puntoalertorio(a, b);
        for (i = 1; i < n+1; i++) {
            System.out.println("Ingrese el movimientos: " + i + ":");
            valor = datos.nextInt();
            sentido = trayectoria();
            //System.out.println(direccion);
            if (sentido == "Izquierda") {
                a = punto[i-1].getX();
                a = a-valor;
            }
            else if (sentido== "Derecha") {
                a = punto[i-1].getX();
                a= a+valor;
            }

            else if (sentido== "Arriba") {
                b = punto[i-1].getY() ;
                b = b+valor;
            }
            if (sentido == "Abajo") {
                b = punto[i-1].getY();
                b = b-valor;
            }
            
            punto[i] = new puntoalertorio(a, b);
            System.out.println("trayectoria: "+ sentido);
            System.out.println("Coordenada: " + a +" "+ b);        
        }
    }
 
    public static String trayectoria() {
        String[] direcciones = {"Izquierda", "Derecha", "Arriba", "Abajo"};
        int numAleatorio = numeroRandomico(0, direcciones.length - 1);
        //System.out.println(numAleatorio);
        return direcciones[numAleatorio];
    }

   

    public static void distanciaRecorrida(int n, puntoalertorio punto[]){
          int recorridoa=0;
        int recorridob=0;
        double dtotal=0;
        for (int i =0; i < n; i++) {
            recorridoa = punto[i+1].getX()-punto[i].getX();
            double recorridoaf = Math.pow(recorridoa, 2);
            recorridob = punto[i+1].getY()-punto[i].getY();
            double recorridobf = Math.pow(recorridob, 2);      
            dtotal = dtotal + Math.sqrt(recorridoaf + recorridobf);
       }
       System.out.println("La trayectoria del punto es: " + dtotal);
    
    }    
}
