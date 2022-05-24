package JavaExamen;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        //pedirTexto();
        //pedirNumero();

        Boolean end = false;
        ArrayList<String> stringArray = new ArrayList<String>();

        Scanner read = new Scanner(System.in); // Sirve para leer lo que el usuario pone por consola.

        System.out.println("# INSTRUCCIONES");
        System.out.println("1. Añadir un elemento al final del array");
        System.out.println("2. Insertar elemento en una posición concreta");
        System.out.println("3. Elimina un elemento concreto de la lista");
        System.out.println("4. Mostrar los elementos de la lista");
        System.out.println("5. Encuentra un elemento en la lista");
        System.out.println("6. Salir");
        System.out.println("-----------------------------------");

        while (!end){

            Integer opcion = pedirNumero("Elige una de las opciones: ");
            System.out.println("");

            switch (opcion){
                case 1:
                    String element = pedirTexto("Escribe un elemento para el array: ");
                    stringArray.add(element);
                    break;
                case 2:
                    String element2 = pedirTexto("Escribe el elemento que quieras añadir: ");
                    Integer position2 = pedirNumero("Donde quieres añadirlo: ");
                    stringArray.add(position2, element2);
                    break;
                case 3:
                    System.out.println("# Instrucciones: ");
                    System.out.println("1) Eliminar por posición: ");
                    System.out.println("2) Eliminar por el valor: ");
                    Integer opcion2 = pedirNumero("Selecciona una opcion: ");
                    switch (opcion2){
                        case 1:
                            Integer posicion3 = pedirNumero("Escribe la posicion: ");
                            stringArray.remove(posicion3);
                            break;
                        case 2:
                            String valor = pedirTexto("Escribe un valor: ");
                            stringArray.remove(valor);
                            break;
                        default:
                            System.out.println("No existe esa opción");
                    }
                    break;
                case 4:
                    for (String i:stringArray){
                        System.out.println(i);
                    }
                    break;
                case 5:
                    String valor = pedirTexto("Escribe un valor: ");
                    boolean encontrado = false;
                    for(int i = 0; i < stringArray.size(); i++){
                        if(stringArray.get(i).equals(valor)){
                            System.out.println("El elemento es: "+stringArray.get(i)+" y la posicion es: "+i);
                            encontrado = true;
                        }
                    }

                    if(!encontrado) System.out.println("No se ha encontrado el elemento");

                    break;
                case 6:
                    end = true;
                    break;
                default: {
                    System.out.println("Este numero no existe");
                }
            }
        }
    }

    public static int pedirNumero(String mensaje){
        Scanner read = new Scanner(System.in); // Sirve para leer lo que el usuario pone por consola.
        //System.out.print("Donde quieres añadirlo: ");
        //Integer result = read.nextInt();
        int respuesta = 0;
        boolean error;
        do {
            try {
                System.out.print(mensaje);
                respuesta = read.nextInt();
                error=false;
            } catch (InputMismatchException e) {
                error=true;
                System.out.println("Error en la entrada de datos, vuelve a probar.");
                read.next();
            }
        }while(error);

        return respuesta;
    }

    public static String pedirTexto(String mensaje){

        Scanner read = new Scanner(System.in); // Sirve para leer lo que el usuario pone por consola.
        String respuesta = "";
        boolean error;

        do {
            try {
                System.out.print(mensaje);
                respuesta = read.next();
                error=false;
            } catch (InputMismatchException e) {
                error=true;
                System.out.println("Error en la entrada de datos, vuelve a probar.");
                read.next();
            }
        }while(error);

        return respuesta;
    }
}
