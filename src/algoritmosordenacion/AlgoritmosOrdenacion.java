/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosordenacion;

import java.util.Arrays;

/**
 *
 * @author Rocio Soriano
 */
public class AlgoritmosOrdenacion {

    public void ordenacionBurbuja(int[] numeros) {
        /**
         * metodo que recibe un array de numeros y lo ordenará a través del
         * algoritmo de la Burbuja
         */
        for (int j = 0; j < numeros.length; j++) { //se hace en un bucle for para que de todas vueltas necesarias
            for (int i = 0; i < numeros.length; i++) {
                if (numeros[i] > numeros[i + 1]) {
                    //si se cumple. intercambio los valores de i e i+1

                    int aux = numeros[i + 1];// se añade un aux para no pisar valores
                    numeros[i + 1] = numeros[i];
                    numeros[i] = aux;
                }
            }
        }
    }
int[]lista1 = {13,47,44,36,32,61,31,555,666,1988,1987,46};
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        AlgoritmosOrdenacion ordenacion= new AlgoritmosOrdenacion();
           //los arrays se imprimen de forma diferente
        System.out.println("Lista sin ordenar:" +Arrays.toString(ordenacion.lista1));
        ordenacion.ordenacionBurbuja(ordenacion.lista1);
        System.out.println("Lista ordenada:" +Arrays.toString(ordenacion.lista1));
    }

}
