public class Benchmark {

    public static Results medir(Runnable accion, String nombre, String sample) {
        // tiempo actual
        long tA= System.nanoTime();
        // accion 
        accion.run();
        // tiempo final
        long tF = System.nanoTime();
        // retornar el tiempo de duracion 
        Results results = new Results(nombre, (tF - tA), sample);
        return results;



    }

    public Object mSort(int[] listacopias4) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mSort'");
    }   

}
