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

        for (int j = 0; j < numeros.length; j++) {
            for (int i = 0; i < numeros.length - 1; i++) {
                if (numeros[i] > numeros[i + 1]) {
                    //si se cumple, intercambio los valores de i e i+1
                    int aux = numeros[i + 1];
                    numeros[i + 1] = numeros[i];
                    numeros[i] = aux;
                }
            }
        }
    }

    public void insercionDirecta(int[] numeros) {
        //la mejor opcion para usarlo es cuando el array esta casi ordenado
        //es como el de la burbuja pero da solo una vuelta. Desplaza.
        for (int i = 2; i < numeros.length; i++) {//la i empieza en 2 xk presupone q el primer eleemento esta ordenado
            int aux = numeros[i];//numero que toca ordenar
            int j = 0;//la j se declara fuera del bucle para que exista fuera de alli tb ya que si no queda constante, busca la nueva posicion
            for (j = i - 1; j >= 0 && numeros[j] > aux; j--) {//para no dejar la primera posicion sin comparar
                //si el anterior ordenado es menor, no comprueba más

                numeros[j + 1] = numeros[j];//intercambio de numeros, de mayor a menor
            }
            numeros[j + 1] = aux;
        }
    }
    int[] lista1 = {13, 47, 44, 36, 32, 61, 31, 555, 666, 1988, 1987, 46};

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //  //los arrays se imprimen de forma diferente
        AlgoritmosOrdenacion ordenacion = new AlgoritmosOrdenacion();
        System.out.println("lista sin ordenar:"
                + Arrays.toString(ordenacion.lista1));

        ordenacion.ordenacionBurbuja(ordenacion.lista1);
        System.out.println("Lista ordenada:" + Arrays.toString(ordenacion.lista1));
    }

}
