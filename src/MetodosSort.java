import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

 /* Algoritmos  de ordenamientos implementados 
  * sin el uso de .sort como Array.sort.
  */

public class MetodosSort {

    public MetodosSort() {

    }
    public void bubbleSort(int[]arreglo){
      
        for(int i = 0; i < arreglo.length -1 ; i++) {
            boolean combinaciones = false;
            for(int j = 1; j < arreglo.length   ; j++) {
                //COMPARACION IF
                if (arreglo[j-1] > arreglo[j]) {
                    combinaciones = true;
                    //INTERCAMBIO
                    int temp = arreglo[j-1];
                    arreglo[j-1] = arreglo[j];
                    arreglo[j] = temp;
                }
            }
            if(!combinaciones){
                break;
            };
        }
    } 
  
    public  void mergeSort(int[] arreglo) {
        if (arreglo == null || arreglo.length <= 1) {
            return;
        }

        int medio = arreglo.length / 2;

        // Copiamos las dos mitades a arreglos auxiliares
        int[] izquierda = Arrays.copyOfRange(arreglo, 0, medio);
        int[] derecha = Arrays.copyOfRange(arreglo, medio, arreglo.length);

        mergeSort(izquierda);
        mergeSort(derecha);

        mezclar(arreglo, izquierda, derecha);
    }

    private static void mezclar(int[] destino, int[] izquierda, int[] derecha) {
        int i = 0; // índice en 'izquierda'
        int j = 0; // índice en 'derecha'
        int k = 0; // índice en 'destino'

        while (i < izquierda.length && j < derecha.length) {
            if (izquierda[i] <= derecha[j]) {
                destino[k++] = izquierda[i++];
            } else {
                destino[k++] = derecha[j++];
            }
        }

        while (i < izquierda.length) {
            destino[k++] = izquierda[i++];
        }

        while (j < derecha.length) {
            destino[k++] = derecha[j++];
        }
    }
}






