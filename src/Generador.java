import java.util.ArrayList;
import java.util.List;

public class Generador {
    
    // genera un listado de tamanio size
    // con numeros aleatorios de 0 - size
    public static List<Integer> generate(int size) {
        List<Integer> lista = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            lista.add((int) (Math.random() * size));
      
        }
        return lista;
    }


}
