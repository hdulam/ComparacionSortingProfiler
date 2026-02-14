import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

/**
 * Pruebas unitarias JUnit 4 para todos los algoritmos de ordenamiento.
 */
public class SortTest {

    // ─── ARREGLOS DE PRUEBA ───────────────────────────────────────────────────

    private Integer[] desordenado()  { return new Integer[]{5, 3, 8, 1, 9, 2, 7, 4, 6, 0}; }
    private Integer[] ordenado()     { return new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}; }
    private Integer[] unElemento()   { return new Integer[]{42}; }
    private Integer[] vacio()        { return new Integer[]{}; }
    private Integer[] duplicados()   { return new Integer[]{3, 1, 4, 1, 5, 9, 2, 6, 5, 3}; }
    private Integer[] invertido()    { return new Integer[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}; }

    /** Verifica que el arreglo esté ordenado de menor a mayor */
    private void assertOrdenado(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            assertTrue("Posicion " + i + ": " + arr[i] + " > " + arr[i+1], arr[i] <= arr[i+1]);
        }
    }

    //GNOME SORT

    @Test public void testGnome_desordenado() { Integer[] a = desordenado(); GnomeSort.sort(a); assertOrdenado(a); }
    @Test public void testGnome_yaOrdenado()  { Integer[] a = ordenado();    GnomeSort.sort(a); assertOrdenado(a); }
    @Test public void testGnome_invertido()   { Integer[] a = invertido();   GnomeSort.sort(a); assertOrdenado(a); }
    @Test public void testGnome_duplicados()  {
        Integer[] a = duplicados(); Integer[] e = duplicados();
        Arrays.sort(e); GnomeSort.sort(a); assertArrayEquals(e, a);
    }
    @Test public void testGnome_unElemento()  { Integer[] a = unElemento();  GnomeSort.sort(a); assertEquals(42, (int) a[0]); }
    @Test public void testGnome_vacio()       { Integer[] a = vacio();       GnomeSort.sort(a); assertEquals(0, a.length); }

    //MERGE SORT 
    
    @Test public void testMerge_desordenado() { Integer[] a = desordenado(); MergeSort.sort(a); assertOrdenado(a); }
    @Test public void testMerge_yaOrdenado()  { Integer[] a = ordenado();    MergeSort.sort(a); assertOrdenado(a); }
    @Test public void testMerge_invertido()   { Integer[] a = invertido();   MergeSort.sort(a); assertOrdenado(a); }
    @Test public void testMerge_duplicados()  {
        Integer[] a = duplicados(); Integer[] e = duplicados();
        Arrays.sort(e); MergeSort.sort(a); assertArrayEquals(e, a);
    }
    @Test public void testMerge_unElemento()  { Integer[] a = unElemento();  MergeSort.sort(a); assertEquals(42, (int) a[0]); }
    @Test public void testMerge_vacio()       { Integer[] a = vacio();       MergeSort.sort(a); assertEquals(0, a.length); }

    //QUICK SORT

    @Test public void testQuick_desordenado() { Integer[] a = desordenado(); QuickSort.sort(a); assertOrdenado(a); }
    @Test public void testQuick_yaOrdenado()  { Integer[] a = ordenado();    QuickSort.sort(a); assertOrdenado(a); }
    @Test public void testQuick_invertido()   { Integer[] a = invertido();   QuickSort.sort(a); assertOrdenado(a); }
    @Test public void testQuick_duplicados()  {
        Integer[] a = duplicados(); Integer[] e = duplicados();
        Arrays.sort(e); QuickSort.sort(a); assertArrayEquals(e, a);
    }
    @Test public void testQuick_unElemento()  { Integer[] a = unElemento();  QuickSort.sort(a); assertEquals(42, (int) a[0]); }
    @Test public void testQuick_vacio()       { Integer[] a = vacio();       QuickSort.sort(a); assertEquals(0, a.length); }

    //RADIX SORT

    @Test public void testRadix_desordenado() { Integer[] a = desordenado(); RadixSort.sort(a); assertOrdenado(a); }
    @Test public void testRadix_yaOrdenado()  { Integer[] a = ordenado();    RadixSort.sort(a); assertOrdenado(a); }
    @Test public void testRadix_invertido()   { Integer[] a = invertido();   RadixSort.sort(a); assertOrdenado(a); }
    @Test public void testRadix_duplicados()  {
        Integer[] a = duplicados(); Integer[] e = duplicados();
        Arrays.sort(e); RadixSort.sort(a); assertArrayEquals(e, a);
    }
    @Test public void testRadix_unElemento()  { Integer[] a = unElemento();  RadixSort.sort(a); assertEquals(42, (int) a[0]); }
    @Test public void testRadix_numerosGrandes() {
        Integer[] a = new Integer[]{9999, 1234, 5678, 100, 9, 0};
        RadixSort.sort(a); assertOrdenado(a);
    }

    //SHELL SORT

    @Test public void testShell_desordenado() { Integer[] a = desordenado(); ShellSort.sort(a); assertOrdenado(a); }
    @Test public void testShell_yaOrdenado()  { Integer[] a = ordenado();    ShellSort.sort(a); assertOrdenado(a); }
    @Test public void testShell_invertido()   { Integer[] a = invertido();   ShellSort.sort(a); assertOrdenado(a); }
    @Test public void testShell_duplicados()  {
        Integer[] a = duplicados(); Integer[] e = duplicados();
        Arrays.sort(e); ShellSort.sort(a); assertArrayEquals(e, a);
    }
    @Test public void testShell_unElemento()  { Integer[] a = unElemento();  ShellSort.sort(a); assertEquals(42, (int) a[0]); }
    @Test public void testShell_vacio()       { Integer[] a = vacio();       ShellSort.sort(a); assertEquals(0, a.length); }
}
