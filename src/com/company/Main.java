package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("BIENVENIDO AL TRUCO DE CARTAS");

        //INICIALIZAR LOS VALORES DE LOS ELEMENTOS QUE VAN A SER SELECCIONADOS
        ///Variable contadora para los elementos
        int numero = 0;
        Object[][] elementos = new Object[7][3];
        for (int i = 0; i < elementos.length; i++) {
            for (int j = 0; j < elementos[i].length; j++) {
                numero++;
                elementos[i][j] = (char) (50 + numero);
                //Elementos de 21 cartas
                elementos[i][j] = (numero);
            }
        }

        //La columna seleccionada para el usuario será 1, 2, 3
        int columnaSeleccionada = 0;
        int numeroDeSelecciones = 0;
        do {
            mostrarCartas(elementos);
            System.out.println("Por favor digita la columna en la que se encuentra el elemento que has pensado(1,2,3):");
            columnaSeleccionada = scanner.nextInt();
            numeroDeSelecciones++;
            System.out.println("Su columna selecciona fue " + columnaSeleccionada);
            //Cuando se haya seleccionado por tercera vez la columna entonces se
            //rombpe el ciclo porque no es necesario seguir revolviendo
            if (numeroDeSelecciones == 3) {
                break;
            }

            //Se declara un vector unidimensional para recoger todos los elementos
            Object[] cartasRecogidas = new Object[elementos.length * elementos[0].length];

            //Se declara un vector para especificar el orden para recorger las columnas
            //teniendo en cuenta que siempre la columna seleccionada debe recogerse de segunda
            //y no importa la columna que se elija para recoger de primera o tercera.
            int[] ordenParaRecorgerColumnas = new int[3];
            if (columnaSeleccionada == 1) {
                ordenParaRecorgerColumnas[0] = 2;
                ordenParaRecorgerColumnas[1] = columnaSeleccionada;
                ordenParaRecorgerColumnas[2] = 3;
            } else if (columnaSeleccionada == 2) {
                ordenParaRecorgerColumnas[0] = 1;
                ordenParaRecorgerColumnas[1] = columnaSeleccionada;
                ordenParaRecorgerColumnas[2] = 3;
            } else if (columnaSeleccionada == 3) {
                ordenParaRecorgerColumnas[0] = 1;
                ordenParaRecorgerColumnas[1] = columnaSeleccionada;
                ordenParaRecorgerColumnas[2] = 2;
            }
            //Se recogen todos los elementos y se añaden al vector unidimensional
            int posElementosRecogidos = -1;
            for (int i = 0; i < ordenParaRecorgerColumnas.length; i++) {
                int columnaParaRecoger = ordenParaRecorgerColumnas[i];
                for (int itFila = 0; itFila < elementos.length; itFila++) {
                    posElementosRecogidos++;
                    Object numeroCarta = elementos[itFila][columnaParaRecoger - 1];
                    cartasRecogidas[posElementosRecogidos] = numeroCarta;
                }
            }
            /////se vuelven a colocar las cartas en columnas
            posElementosRecogidos = -1;
            for (int i = 0; i < elementos.length; i++) {
                for (int j = 0; j < elementos[i].length; j++) {
                    posElementosRecogidos++;
                    elementos[i][j] = cartasRecogidas[posElementosRecogidos];
                }
            }
        } while (true);
        //Siempre el elemento seleccionado se ubica en la cuarta fila(index 3) de la columna seleccionada
        System.out.println("Su elemento seleccionado fue " + (elementos[3][columnaSeleccionada - 1]));

    }

    static void mostrarCartas(Object[][] cartas) {
        for (int i = 0; i < cartas.length; i++) {
            for (int j = 0; j < cartas[i].length; j++) {
                System.out.print(cartas[i][j] + "\t");
            }
            System.out.println("");
        }
    }
}

