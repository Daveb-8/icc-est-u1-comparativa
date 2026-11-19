import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MetodosSort {

    


    public MetodosSort() {

    }
    public void bsort(int[]arreglo){
      
        for(int i = 0; i < arreglo.length -1 ; i++) {
            System.out.println("Pasada" + i);
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
            };}
        }
    
    public void bubbleSort(List<Integer> list){
        for(int i = 0; i < list.size() -1 ; i++) {
            boolean combinaciones = false;
            for(int j = 1; j < list.size() ; j++) {
                //COMPARACION IF
                if (list.get(j) > list.get(j+1)) {
                    combinaciones = true;
                    //INTERCAMBIO
                    int temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1,temp); 
                }
            }
            if(!combinaciones){
                break;
            }
        }
    }
    public void insertionSort(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            int key = list.get(i);
            int j = i-1;
            while (j >= 0 && list.get(j) < key) {
                list.set(j+1, list.get(j));
                j--;   
            }
            list.set(j+1 , key);
        }
    }
  
    public void selectionSort(List<Integer> list) {
        for(int i = 0 ; i < list.size() ; i ++) {
            int min = i;
            for (int j = i + 1 ; j < list.size() ; j++) {
                if (list.get(j) < list.get(min)) {
                    min = j;
                }
            //Intercambio
            int temp = list.get(min);
            list.set(min,list.get(i));
            list.set(i, temp);

            }   
        }
    }

    public void mergeSort(List<Integer> list) {
        if (list == null || list.size() <= 1) {
            return;
        }

        int medio = list.size() / 2;

        // Se crean sublistas independientes para las mitades izquierda y derecha
        List<Integer> izquierda = new ArrayList<>(list.subList(0, medio));
        List<Integer> derecha = new ArrayList<>(list.subList(medio, list.size()));

        mergeSort(izquierda);
        mergeSort(derecha);

        mezclar(list, izquierda, derecha);

    }

    private static void mezclar(List<Integer> destino, List<Integer> izquierda, List<Integer> derecha) {
        int i = 0; // índice en 'izquierda'
        int j = 0; // índice en 'derecha'
        int k = 0; // índice en 'destino'

        // Compara y copia el menor elemento de cada mitad
        while (i < izquierda.size() && j < derecha.size()) {
            if (izquierda.get(i) <= derecha.get(j)) {
                destino.set(k++, izquierda.get(i++));
            } else {
                destino.set(k++, derecha.get(j++));
            }
        }

        // Copia los elementos restantes de 'izquierda' (si quedaron)
        while (i < izquierda.size()) {
            destino.set(k++, izquierda.get(i++));
        }

        // Copia los elementos restantes de 'derecha' (si quedaron)
        while (j < derecha.size()) {
            destino.set(k++, derecha.get(j++));
        }
    }
    
    
    
    public  void mSort(int[] arreglo) {
        if (arreglo == null || arreglo.length <= 1) {
            return;
        }

        int medio = arreglo.length / 2;

        // Copiamos las dos mitades a arreglos auxiliares
        int[] izquierda = Arrays.copyOfRange(arreglo, 0, medio);
        int[] derecha = Arrays.copyOfRange(arreglo, medio, arreglo.length);

        mSort(izquierda);
        mSort(derecha);

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






