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

        // Copiamos las dos mitades en arreglos auxiliares
        int[] izquierda = new int[medio];
        int[] derecha = new int[arreglo.length - medio];


        for(int i = 0; i < medio; i++) {
                izquierda[i] = arreglo[i];
        }
        for(int i = medio; i < arreglo.length; i++) {
                 derecha[i-medio] = arreglo[i];
            
        }
        mergeSort(izquierda);
        mergeSort(derecha);  
        merge(izquierda, derecha, arreglo);
    }

    private static void merge(int[] izquierda, int[] derecha, int[] arreglo) {
        //indices
        int i = 0; 
        int izq = 0; 
        int drch = 0;

        while (izq < izquierda.length && drch < derecha.length) {
            if (izquierda[izq] <= derecha[drch]) {
                arreglo[i] = izquierda[izq];
                i++;
                izq++;
            } else {
                arreglo[i] = derecha[drch];
                i++;
                drch++;
            }
        }
        while (izq < izquierda.length) {
            arreglo[i] = izquierda[izq];
            i++;
            izq++;
        }
        while (drch < derecha.length) {
            arreglo[i] = derecha[drch];
            i++;
            drch++;
        }
    }
}







