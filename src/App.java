import java.util.ArrayList;
import java.util.Arrays;
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
       
        
        //List<Integer> lista = g.generate(100000);
        //System.out.println(lista);

        //Runnable x = () ->  g.generate(100);
        // Toda la funcion en x puede ser ingresada como parametro en el metodo .medir()
        // Results benGenList = b.medir(x, "Generacion de Listado", "100");
        //System.out.println(benGenList);

        //Los 3 arreglos bases
        // 10000
        //List<Integer> bubblesort = g.generate(100000);
        // 50000
        //List<Integer> selectionsort = g.generate(100000);
        // 100000
        //List<Integer> insertionsort = g.generate(100000);

        //1 = List <List<Integer>> listas = List.of(lista,1lista2,lista2);
        //2 = List<Integer>[] listas = new List<Integer>[]{lista1};
        MetodosSort m = new MetodosSort();
        // Crear las listas de datos
        int[] listaoriginals1 = g.generar(10000);
        int[] listaoriginals2 = g.generar(50000);
        int[] listaoriginals3 = g.generar(100000);

        System.out.println("Caso Bubble sort");
        int[] listacopias1 = listaoriginals1;
        m.bsort(listacopias1);
        int[] listacopias2= listaoriginals2;
        m.bsort(listacopias2);
        int[] listacopias3 = listaoriginals3;
        m.bsort(listacopias3);

        System.out.println("Caso MergeSort");
        int[] listacopias4 = listaoriginals1;
        m.mSort(listacopias4);
        int[] listacopias5 = listaoriginals1;
        m.mSort(listacopias5);
        int[] listacopias6 = listaoriginals1;
        m.mSort(listacopias6);

        //List<Integer> list2c1 = list2.clone();
        //List<Integer> list2cri1 = Arrays.copyOf(list2,list2.size());

        Results resultaM1S1 = Benchmark.medir( () -> b.mSort(listacopias1), "Burbuja", "10.000");
        Results resultaM1S2 = Benchmark.medir( () -> b.mSort(listacopias2), "Burbuja", "50.000");
        Results resultaM1S3 = Benchmark.medir( () -> b.mSort(listacopias3), "Burbuja", "100.000");

        Results resultaM2S1 = Benchmark.medir( () -> b.mSort(listacopias4), "Burbuja", "10.000");
        Results resultaM2S2 = Benchmark.medir( () -> b.mSort(listacopias5), "Burbuja", "50.000");
        Results resultaM2S3 = Benchmark.medir( () -> b.mSort(listacopias6), "Burbuja", "100.000");

        System.out.println(resultaM1S1);
        System.out.println(resultaM1S2);
        System.out.println(resultaM1S3);
        System.out.println(resultaM2S1);
        System.out.println(resultaM2S2);
        System.out.println( resultaM2S3);









}

}
