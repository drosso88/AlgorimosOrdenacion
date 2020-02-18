/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosordenacion;

import java.util.Arrays;
import java.util.Random;

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

    public void shellShort(int[] numeros) {
        int salto, aux;
        boolean intercambio;

        for (salto = numeros.length / 2; salto != 0; salto /= 2) { //parte el array entre dos y aqui es donde preordena
            intercambio = true; //variable que nos permite saber si estamos en el while o no
            while (intercambio) {// este bucle while es el que hace la insercion directa
                intercambio = false;
                for (int i = salto; i < numeros.length; i ++){//mueve la horquilla y si hay algun cambio pone intercambio a true
                    //for (int i = salto; i < numeros.length; i +=salto)//jorge lo puso asi, el bucle de arriba es el mio
                    if (numeros[i - salto] > numeros[i]) {
                        // si los dos numeros estan desordenados entre si y los intercambio y los identifico
                        aux = numeros[i];
                        numeros[i] = numeros[i-salto];
                        numeros[i-salto] = aux;
                        intercambio = true;
                    }
                }
            }
        }  
    }

    //crea un array de tantos numeros aleatorios como le pasemos en la variable 
    public int[] generaNumerosRandom(int dimension) {

        int[] numeros = new int[dimension];
        Random r = new Random();
        for (int i = 0; i < dimension; i++) {
            numeros[i] = r.nextInt();
        }
        return numeros;
    }
    int[] lista1 = {13, 47, 44, 36, 32, 61, 31, 555, 666, 1988, 1987, 46};

    int[] arrayParaBurbuja;
    int[] arrayParaInsercion; 
    int[] arrayParaShell;

    

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

        //empiezo las pruebas de rendimientos de los algoritmos
        int rangoPrueba = 10000;//numero de datos con los que probamos
        int[] numeros = ordenacion.generaNumerosRandom(rangoPrueba);
        ordenacion.arrayParaBurbuja = new int[rangoPrueba];
        ordenacion.arrayParaInsercion = new int[rangoPrueba];
        ordenacion.arrayParaShell = new int[rangoPrueba];
        
        for (int i = 0; i < rangoPrueba; i++) {
            ordenacion.arrayParaBurbuja[i] = numeros[i];
            ordenacion.arrayParaInsercion[i] = numeros[i];
             ordenacion.arrayParaShell[i] = numeros[i];
            //tenemos dos copias exactas  del array de datos aleatorio
        }
        System.out.println("Empieza la burbuja: (vete a por un cafe)");
        long tiempoInicio = System.currentTimeMillis();

        ordenacion.ordenacionBurbuja(ordenacion.arrayParaBurbuja);
        long tiempoFinal = System.currentTimeMillis();
        System.out.println("la burbuja ha tardado" + (tiempoFinal - tiempoInicio));

        ///////////////////////////////////////////////////////
        System.out.println("Empieza la Insercion directa");
        tiempoInicio = System.currentTimeMillis();

        ordenacion.insercionDirecta(ordenacion.arrayParaInsercion);
        tiempoFinal = System.currentTimeMillis();
        System.out.println("Insercion directa ha tardado" + (tiempoFinal - tiempoInicio));
        
        ///////////////////////////////////////////////////
        
        
        System.out.println("Empieza la Shell Short");
        tiempoInicio = System.currentTimeMillis();

        ordenacion.shellShort(ordenacion.arrayParaShell);
        tiempoFinal = System.currentTimeMillis();
        System.out.println("Shell Short ha tardado" + (tiempoFinal - tiempoInicio));

    }

}
