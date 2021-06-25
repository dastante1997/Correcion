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
        String direccion = "";
        int x = 0;
        int y = 0;
        int i = 0;
        int valor = 0;
        punto[0] = new puntoalertorio(x, y);
        for (i = 1; i < n+1; i++) {
            System.out.println("Ingrese numero cualquiera: " + i + ":");
            valor = datos.nextInt();
            direccion = trayectoria();
            //System.out.println(direccion);
            if (direccion == "Izquierda") {
                x = punto[i-1].getX();
                x = x-valor;
            }
            else if (direccion == "Derecha") {
                x = punto[i-1].getX();
                x= x+valor;
            }

            else if (direccion == "Arriba") {
                y = punto[i-1].getY() ;
                y = y+valor;
            }
            if (direccion == "Abajo") {
                y = punto[i-1].getY();
                y = y-valor;
            }
            
            punto[i] = new puntoalertorio(x, y);
            System.out.println("Direccion: "+ direccion);
            System.out.println("Coordenadas: " + x +" "+ y);        
        }
    }
 
    public static String trayectoria() {
        String[] direcciones = {"Izquierda", "Derecha", "Arriba", "Abajo"};
        int numAleatorio = numeroRandomico(0, direcciones.length - 1);
        //System.out.println(numAleatorio);
        return direcciones[numAleatorio];
    }

   

    public static void distanciaRecorrida(int n, puntoalertorio punto[]){
          int recorridox=0;
        int recorridoy=0;
        double dtotal=0;
        for (int i =0; i < n; i++) {
            recorridox = punto[i+1].getX()-punto[i].getX();
            double recorridoxf = Math.pow(recorridox, 2);
            recorridoy = punto[i+1].getY()-punto[i].getY();
            double recorridoyf = Math.pow(recorridoy, 2);      
            dtotal = dtotal + Math.sqrt(recorridoxf + recorridoyf);
       }
       System.out.println("La trayectoria del punto es: " + dtotal);
    
    }    
}
