package clase2;

public class FibonacciComparison {
    public static void main(String[] args) {
        int n = 30; // Valor de n en la serie de Fibonacci
        int repetitions = 10; // Número de repeticiones para calcular la media de tiempo

        // Medición del tiempo del método iterativo básico
        long basicTime = measureAverageTime(() -> fibonacciBasic(n), repetitions);
        System.out.println("Tiempo medio de Fibonacci Iterativo Básico: " + basicTime + " ns");

        // Medición del tiempo del método iterativo optimizado
        long optimizedTime = measureAverageTime(() -> fibonacciOptimized(n), repetitions);
        System.out.println("Tiempo medio de Fibonacci Iterativo Optimizado: " + optimizedTime + " ns");
    }

    // Método iterativo básico para calcular Fibonacci
    private static int fibonacciBasic(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }

    // Método iterativo optimizado para calcular Fibonacci
    private static int fibonacciOptimized(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            b = a + b;
            a = b - a;
        }
        return b;
    }

    // Método para medir el tiempo promedio de ejecución
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

