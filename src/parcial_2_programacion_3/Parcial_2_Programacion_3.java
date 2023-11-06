package parcial_2_programacion_3;

import java.util.InputMismatchException;

public class Parcial_2_Programacion_3 {

    public static void main(String[] args) {
        //Caso de prueba 1
        String[] array1 = {
            "ATATAT",
            "ATATAT",
            "ATATAT",
            "ATATAT",
            "ATATAT",
            "ATATAT"
        };
        /*
        //Caso de prueba 2
        String[] array1 = {
            "CGCGCG",
            "CGCGCG",
            "CGCGCG",
            "CGCGCG",
            "CGCGCG",
            "CGCGCG"
        };
        */
        /*
        //Caso de prueba 3
        String[] array1 = {
            "ACGTAC",
            "TACGTA",
            "GTACGT",
            "CGTACG",
            "TGCTAG",
            "AGCTGA"
        };
        */
        //Caso erroneo de prueba 4 (Se excede de los limetes de la matriz 6x6)
        /*
        String[] array1 = {
            "ATCGATTT",
            "TAGCTA",
            "CGATCG",
            "GCTAGC",
            "TCGATCCC",
            "ACTAGT"
        };
        */
        //Caso erroneo de prueba 5 (Hay caracteres que no corresponden al ADN)
        /*
        String[] array1 = {
            "AAAYAA",
            "TTTTTT",
            "COCCCC",
            "GGGGGG",
            "ATCGLT",
            "TAGCTA"
        };
        */
        /*
        //Caso erróneo de prueba 6 (Se excede del límite y tiene caracteres que no corresponden)
        String[] array1 = {
            "OPOPOPOP",
            "POPOPO",
            "LKLKLKE3S",
            "KLKLKL",
            "ASASAS9",
            "ZXZXZX"
        };
        */

        //Asigno el array de prueba (Si se desea probar otra posibilidad se debe asignar alguno de los casos de prueba aquí)
        String[] array = array1;

        //Valido que el array de Strings solo contenga 6 palabras de longitud 6
        if (validarDimensiones(array)) {
            throw new InputMismatchException("¡ERROR! El ADN deben ser 6 palabras de longitud 6");
        }

        char[][] letras = new char[6][6];

        //Divido los Strings en una matriz de caracteres
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                letras[i][j] = array[i].charAt(j);
            }
        }

        //Valido que solo sean los caracteres mencionados
        if (validarCaracteres(letras)) {
            throw new InputMismatchException("¡ERROR! Se encontro un valor no válido en el ADN");
        }

        //Muestro el gen por pantalla
        System.out.println("Gen a analizar...");
        for (int i = 0; i < letras.length; i++) {
            for (int j = 0; j < letras.length; j++) {
                System.out.print(letras[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println("");

        //Inicializo los contadores en 0
        int contadorLetra = 0;
        int contadorPatron = 0;

        //Recorro la matriz
        for (int i = 0; i < letras.length; i++) {
            for (int j = 0; j < letras.length; j++) {
                char letraActual = letras[i][j];
                //Verificación de patron horizontal con la letra actual
                if (j + 3 < letras.length) {
                    for (int k = 0; k < 4; k++) {
                        if (letraActual == letras[i][j + k]) {
                            contadorLetra++;
                        }
                    }
                    if (contadorLetra == 4) {
                        contadorPatron++;
                    }
                    contadorLetra = 0;
                }
                //Verificación de patron vertical con la letra actual
                if (i + 3 < letras.length) {
                    for (int k = 0; k < 4; k++) {
                        if (letraActual == letras[i + k][j]) {
                            contadorLetra++;
                        }
                    }
                    if (contadorLetra == 4) {
                        contadorPatron++;
                    }
                    contadorLetra = 0;
                }
                //Verificación de patron diagonal con la letra actual
                if (i + 3 < letras.length && j + 3 < letras.length) {
                    for (int k = 0; k < 4; k++) {
                        if (letraActual == letras[i + k][j + k]) {
                            contadorLetra++;
                        }
                    }
                    if (contadorLetra == 4) {
                        contadorPatron++;
                    }
                    contadorLetra = 0;
                }
                //Verificacion de patron diagonal inverso con la letra actual
                if (i + 3 < letras.length && j - 3 >= 0) {
                    for (int k = 0; k < 4; k++) {
                        if (letraActual == letras[i + k][j - k]) {
                            contadorLetra++;
                        }
                    }
                    if (contadorLetra == 4) {
                        contadorPatron++;
                    }
                    contadorLetra = 0;
                }
            }
        }

        System.out.println("El patron del gen mutante se encontro " + contadorPatron + " vez/veces");
        if (contadorPatron > 1) {
            System.out.println("Por lo tanto la persona es mutante");
        } else {
            System.out.println("Por lo tanto la persona no es mutante");
        }
    }

    public static boolean validarCaracteres(char[][] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] != 'A' && array[i][j] != 'T' && array[i][j] != 'C' && array[i][j] != 'G') {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean validarDimensiones(String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].length() != 6) {
                return true;
            }
        }
        return false;
    }

}
