# FerreMJ - Sistema de Gestión para Ferretería

## 🛠 Descripción del sistema

**FerreMJ** es una aplicación (de consola escrita en Java) que permite gestionar eficientemente el inventario de una ferretería. El sistema permite:

- Agregar productos al inventario.
- Clonar productos similares rápidamente.
- Detectar productos con bajo stock.
- Integrar productos provenientes de proveedores externos.

Todo esto está construido aplicando patrones de diseño para mejorar la escalabilidad, reutilización de código y mantenimiento.

---

## ❗ Problema a resolver

Las ferreterías muchas veces enfrentan problemas como:

- Registrar productos similares repetidamente desde cero.
- No recibir alertas cuando el stock de productos está bajo.
- Dificultad para integrar productos externos a su sistema.
- Gestión de inventario inconsistente por falta de control centralizado.

**FerreMJ** aborda estos problemas aplicando una solución basada en 4 patrones de diseño.

---

## 🧩 Patrones de diseño utilizados y justificación

### 🔷 Singleton – `GestorInventario`

**¿Por qué este patrón y no otro?**  
Se usó Singleton para garantizar que haya **una única instancia del gestor de inventario**, ya que tener múltiples instancias causaría descoordinación en la administración de productos. (No se requiere crear múltiples variantes del gestor).

**¿Cómo se usó?**  
Se implementó con un constructor privado, un atributo estático y un método `obtenerInstancia()`.

**¿Dónde se usó?**

```java
public class GestorInventario {
    private static GestorInventario instancia;

    private GestorInventario() {}

    public static GestorInventario obtenerInstancia() {
        if (instancia == null) {
            instancia = new GestorInventario();
        }
        return instancia;
    }
}
```

---

### 🔷 Adapter – `AdaptadorProducto`

**¿Por qué este patrón y no otro?**  
Se eligió Adapter porque permite **convertir objetos de una clase externa (`ProductoExterno`) a una clase interna (`Producto`) sin modificar sus estructuras originales**. No se usó Bridge porque no había necesidad de desacoplar múltiples implementaciones y abstracciones.

**¿Cómo se usó?**  
Se creó una clase `AdaptadorProducto` que hereda de `Producto` y recibe un `ProductoExterno` en su constructor.

**¿Dónde se usó?**

```java
public class AdaptadorProducto extends Producto {
    public AdaptadorProducto(ProductoExterno externo) {
        super(externo.getTitulo(), externo.getCantidad());
    }
}
```

---

### 🔷 Observer – `Producto` y `ObservadorStock`

**¿Por qué este patrón y no otro?**  
Observer permite que **uno o varios objetos (observadores)** se actualicen automáticamente cuando cambia el estado de otro objeto (`Producto`). (Porque la relación es directa entre productos y observadores sin necesidad de un objeto central que coordine o intermedie entre ellos).

**¿Cómo se usó?**  
La clase `Producto` mantiene una lista de observadores y los notifica cuando su stock baja de cierto límite.

**¿Dónde se usó?**

```java
public void setStock(int stock) {
    this.stock = stock;
    if (stock < 2) {
        notificarObservadores();
    }
}

private void notificarObservadores() {
    for (Observador o : observadores) {
        o.actualizar(this);
    }
}
```

---

### 🔷 Prototype – `Producto.clonar()`

**¿Por qué este patrón y no otro?**  
Prototype permite **crear rápidamente copias de un producto existente**, útil cuando se desea registrar productos muy similares. (No es necesario construir objetos paso a paso con múltiples configuraciones).

**¿Cómo se usó?**  
La clase `Producto` implementa `Cloneable` y define un método `clonar()` que retorna una copia del producto, modificando su nombre y reiniciando observadores.

**¿Dónde se usó?**

```java

public Producto clonar() {
    try {
        Producto clon = (Producto) super.clone();
        clon.observadores = new ArrayList<>();
        clon.nombre = this.nombre + " (Clon xd)";
        return clon;
    } catch (CloneNotSupportedException e) {
        throw new RuntimeException(e);
    }
}
```

---
## ▶️ Instrucciones de compilación y ejecución

### Requisitos

- JDK 8 o superior
- IDE como NetBeans, Eclipse, IntelliJ o terminal con `javac` y `java`

### Compilación por consola

Desde la raíz del proyecto, ejecuta:

```bash
javac -d bin src/**/*.java
```

Esto compilará todos los archivos fuente y los dejará en la carpeta `bin`.

### Ejecución

```bash
java -cp bin src.Main
```

---

