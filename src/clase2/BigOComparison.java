package clase2;
/*
import java.util.Arrays;: Importa la clase Arrays de la biblioteca estándar de Java.
Esta clase contiene métodos estáticos para manipular arrays, como el método sort que utilizamos para ordenar un array.
 */
import java.util.Arrays;

public class BigOComparison {

    /*
    * public static void main(String[] args) {: El método main es el punto de entrada del programa.
    Aquí es donde comienza la ejecución.
    * int[] array = generateArray(1000000);: Se crea un array de enteros de tamaño 1,000,000 utilizando un método llamado generateArray.
    Este método llena el array con valores del 0 al 999,999.
    * int target = 999999;: Define el valor objetivo que se va a buscar en el array.
    * int repetitions = 10;: Define el número de veces que se ejecutará cada algoritmo para calcular el tiempo promedio.
    * long linearTime = measureAverageTime(() -> linearSearch(array, target), repetitions);: Mide el tiempo promedio que toma realizar una búsqueda lineal en el array. Este tiempo se guarda en la variable linearTime.
    * System.out.println("Tiempo medio de búsqueda lineal: " + linearTime + " ns");: Imprime el tiempo promedio de la búsqueda lineal en la consola.
    * Arrays.sort(array);: Ordena el array para prepararlo para la búsqueda binaria. La búsqueda binaria solo funciona en arrays ordenados.
    * long binaryTime = measureAverageTime(() -> binarySearch(array, target), repetitions);: Mide el tiempo promedio que toma realizar una búsqueda binaria en el array. Este tiempo se guarda en la variable binaryTime.
    * System.out.println("Tiempo medio de búsqueda binaria: " + binaryTime + " ns");: Imprime el tiempo promedio de la búsqueda binaria en la consola.
     */
    public static void main(String[] args) {
        int[] array = generateArray(1000000);
        int target = 999999; // Valor a buscar
        int repetitions = 10;

        // Medición del tiempo de la búsqueda lineal
        long linearTime = measureAverageTime(() -> linearSearch(array, target), repetitions);
        System.out.println("Tiempo medio de búsqueda lineal: " + linearTime + " ns");

        // El array debe estar ordenado para la búsqueda binaria
        Arrays.sort(array);

        // Medición del tiempo de la búsqueda binaria
        long binaryTime = measureAverageTime(() -> binarySearch(array, target), repetitions);
        System.out.println("Tiempo medio de búsqueda binaria: " + binaryTime + " ns");
    }


    // Genera un array de tamaño dado con valores de 0 a size-1
    /*
    * private static int[] generateArray(int size): Es un método privado que genera y devuelve un array de enteros de tamaño size.
    * int[] array = new int[size];: Se crea un nuevo array de enteros del tamaño especificado.
    * for (int i = 0; i < size; i++) { array[i] = i; }: Se llena el array con valores del 0 hasta size - 1.
    * return array;: Retorna el array generado.
     */
    private static int[] generateArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    // Búsqueda lineal: O(n)
    /*
    * private static int linearSearch(int[] array, int target): Es un método privado que realiza una búsqueda lineal en el array.
    * for (int i = 0; i < array.length; i++) {: Un bucle que recorre cada elemento del array.
    * if (array[i] == target) { return i; }: Si el elemento actual es igual al valor objetivo (target), devuelve el índice donde se encontró.
    * return -1;: Si no se encuentra el valor objetivo en el array, retorna -1.
     */
    private static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Búsqueda binaria: O(log n)
    /*
    * private static int binarySearch(int[] array, int target): Es un método privado que realiza una búsqueda binaria en un array ordenado.
    * int left = 0; y int right = array.length - 1;: Define los límites izquierdo (left) y derecho (right) del array.
    * while (left <= right) {: Un bucle que continúa hasta que los límites se crucen.
    * int mid = left + (right - left) / 2;: Calcula el punto medio entre los límites izquierdo y derecho.
    * if (array[mid] == target) { return mid; }: Si el valor medio es igual al objetivo, devuelve el índice medio.
    * if (array[mid] < target) { left = mid + 1; } else { right = mid - 1; }: Si el valor medio es menor que el objetivo, mueve el límite izquierdo (left) hacia la derecha. Si es mayor, mueve el límite derecho (right) hacia la izquierda.
    * return -1;: Si no se encuentra el valor objetivo, retorna -1.
     */
    private static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // Método para medir el tiempo promedio de ejecución
    /*
    * private static long measureAverageTime(Runnable algorithm, int repetitions): Este método mide el tiempo promedio de ejecución de un algoritmo específico.
    * long totalTime = 0;: Inicializa una variable para acumular el tiempo total de ejecución.
    * for (int i = 0; i < repetitions; i++) {: Un bucle que repite la ejecución del algoritmo repetitions veces.
    * long startTime = System.nanoTime();: Captura el tiempo de inicio en nanosegundos.
    * algorithm.run();: Ejecuta el algoritmo que se pasó como parámetro.
    * long endTime = System.nanoTime();: Captura el tiempo de finalización en nanosegundos.
    * totalTime += (endTime - startTime);: Calcula el tiempo que tardó en ejecutarse el algoritmo y lo suma al totalTime.
    * return totalTime / repetitions;: Devuelve el tiempo promedio de ejecución dividiendo el tiempo total entre el número de repeticiones.
     */
    private static long measureAverageTime(Runnable algorithm, int repetitions) {
        long totalTime = 0;
        for (int i = 0; i < repetitions; i++) {
            long startTime = System.nanoTime();
            algorithm.run();
            long endTime = System.nanoTime();
            totalTime += (endTime - startTime);
        }
        return totalTime / repetitions;
    }
}
