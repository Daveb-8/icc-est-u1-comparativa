import java.util.ArrayList;
import java.util.List;

public class Generador {

    //generador arreglos
    public static int[] generar(int length) {
        // if para valores negativos de la muestra (revisar)
        if (length < 0) {
            int [] vacio = new int[length];
            System.out.println("El tamanio de la muestra no puede ser negativo");
            return vacio;
            
        }else {
            int[] arreglo = new int[length];
            for (int i = 0; i < length; i++) {
                arreglo[i] = (int) (Math.random() * length);
            }
            return arreglo;
        }
    }
/* genera un listado de tamanio size
   con numeros aleatorios de 0 - size

   public static List<Integer> generate(int size) {
    List<Integer> lista = new ArrayList<>();
     for(int i = 0; i < size; i++) {
        lista.add((int) (Math.random() * size));
      
     }
     return lista;
}
*/

}


