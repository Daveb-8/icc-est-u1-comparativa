import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
     
        //long nanoTime = System.nanoTime();
        //long currentTimeMillis = System.currentTimeMillis();
        //System.out.println("Nano Time: " + nanoTime);
        //System.out.println("Current Time" + currentTimeMillis);

        // operaciones para guardar funciones dentro de variables
        // Se guarda en una variable una funcion a ejecutar (lambda)
        // La funcion solo se ejecuta no puede retornar nada
        //Runnable x = () -> System.out.println("Ejectuando Tarea");
        // Callable <T> X es para que esa funcion retorne algo
        //System.out.println("Ejecucion de la funcion Runnable");
        //x.run();

        //mas lineas de codigo en la variable
        //Runnable y = () -> {
        //    System.out.println("Ejectuando Tarea 1");
        //    System.out.println("Ejectuando Tarea 2");
        //};
        //System.out.println("Ejecucion de la funcion Runnable");
        //y.run();

        //List<Integer> list = new ArrayList<>();
        //MetodosOrd m0 = new MetodosOrd();
       
        //m0.burbuja(list); //ejecucion directa de la funcion
        
        //Runnable burbujaOrden = () -> m0.burbuja(list); //se guarda la funcion dentro de variable pero no se ejecuta hasta llamarla
        //burbujaOrden.run();

        Generador g = new Generador();
        Benchmark b = new Benchmark();
        
        List<Integer> lista = g.generate(100000);
        //System.out.println(lista);

        Runnable x = () ->  g.generate(100);
        // Toda la funcion en x puede ser ingresada como parametro en el metodo .medir()
        Results benGenList = b.medir(x, "Generacion de Listado", "100");
        System.out.println(benGenList);



}

}
