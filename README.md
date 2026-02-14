# HT3 - Ordenamientos

Hoja de trabajo 3 de Algoritmos y Estructura de Datos. Implementa 5 algoritmos de ordenamiento y mide sus tiempos con un profiler.

Por:
Héctor Duarte - 25939
Edgar Guevara - 251154

---

## Cómo correr el programa

Entra a la carpeta donde están los archivos y corre esto en la terminal:

```bash
# Compilar
javac *.java

# Correr normal
java Main

# Correr con profiler (JDK 9 en adelante)
java -XX:StartFlightRecording=duration=60s,filename=resultado.jfr Main
```

El programa va a pausar al inicio y pedirte que presiones Enter. Ese momento es para que abras VisualVM y te conectes antes de que empiece a ordenar.

---

## Algoritmos implementados

| Algoritmo  | Complejidad promedio | Elegido por |
|------------|----------------------|-------------|
| Gnome Sort | O(n²)                | requerido   |
| Merge Sort | O(n log n)           | requerido   |
| Quick Sort | O(n log n)           | requerido   |
| Radix Sort | O(nk)                | requerido   |
| Shell Sort | O(n log² n)          | la pareja   |

---

## Cómo correr las pruebas JUnit

Necesitas bajar estos dos archivos JAR y agregarlos al proyecto (o usar IDE que los integre:

- junit-4.13.2.jar → https://search.maven.org/artifact/junit/junit/4.13.2/jar
- hamcrest-core-1.3.jar → https://search.maven.org/artifact/org.hamcrest/hamcrest-core/1.3/jar

En IntelliJ: File → Project Structure → Libraries → + → agregar los dos JAR.
Luego clic derecho en `SortTest.java` → Run.

---

## Cómo usar el profiler

Usamos Java Flight Recorder (JFR), que viene incluido con el JDK:

```bash
java -XX:StartFlightRecording=duration=60s,filename=resultado.jfr Main
```

Esto genera un archivo `resultado.jfr`. Para verlo visualmente descarga JDK Mission Control en https://adoptium.net/jmc y abre el archivo desde ahí.

---

## Git

```bash
git init
git add .
git commit -m "v1 - estructura inicial"
git commit -m "v2 - algoritmos implementados"
git commit -m "v3 - pruebas JUnit"
git commit -m "v4 - medicion de tiempos con profiler"
```
