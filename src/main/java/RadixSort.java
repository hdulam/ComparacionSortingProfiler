/**
 * Radix Sort: ordena dígito por dígito del menos significativo al más significativo.
 * Complejidad: O(nk) donde k = número de dígitos del valor máximo
 * Nota: trabaja con Integer (necesita operar aritméticamente con los valores).
 */
public class RadixSort {

    /**
     * Ordena un arreglo de Integer usando Radix Sort.
     * @param arr arreglo de Integer (solo valores >= 0)
     */
    public static void sort(Integer[] arr) {
        if (arr == null || arr.length <= 1) return;

        // Encontrar el valor máximo para saber cuántos dígitos hay
        int max = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
        }

        // Aplicar counting sort para cada posición de dígito
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    private static void countingSort(Integer[] arr, int exp) {
        int n = arr.length;
        Integer[] output = new Integer[n];
        int[] count = new int[10]; // dígitos 0-9

        // Contar ocurrencias del dígito en posición 'exp'
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // Posiciones acumulativas
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Construir arreglo de salida (de derecha a izquierda para estabilidad)
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Copiar resultado al arreglo original
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }
}
