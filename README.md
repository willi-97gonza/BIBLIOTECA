# 📚 Sistema de Gestión de Biblioteca – README

Este proyecto implementa un **sistema de gestión de biblioteca** usando Programación Orientada a Objetos (POO) en Java.  
El código permite administrar libros, usuarios y préstamos con reglas de negocio realistas, validaciones y excepciones personalizadas.

---

## 🚀 Objetivo del Sistema

El programa permite:

- Registrar libros con datos validados.
- Registrar usuarios con ID autogenerado y correo válido.
- Realizar préstamos aplicando reglas (máximo 3 libros por usuario).
- Verificar disponibilidad de libros.
- Calcular multas por retrasos.
- Generar reportes básicos.

Todo esto siguiendo buenas prácticas de POO.

---

## 📦 Estructura del Proyecto

src/
└── biblioteca/
├── BibliotecaApp.java
├── Biblioteca.java
├── Libro.java
├── Usuario.java
├── Prestamo.java
├── EstadoPrestamo.java
├── LibroNoDisponibleException.java
└── UsuarioSinCupoException.java

Cada archivo tiene una responsabilidad clara y está organizado por paquetes.

---

## 🧩 Descripción de las Clases

### ✅ Libro
Representa un libro dentro de la biblioteca.

Funciones principales:
- Validar ISBN de 13 dígitos.
- Verificar disponibilidad.
- Controlar préstamos y devoluciones.
- Contabilizar cuántas veces ha sido prestado.

---

### ✅ Usuario
Modelo de un usuario del sistema.

Funciones:
- ID autogenerado con `AtomicInteger`.
- Validación de correo.
- Manejo de multas con BigDecimal.
- Control de libros prestados (máx. 3).

---

### ✅ Prestamo
Representa el préstamo de un libro.

Funciones:
- Maneja fecha de préstamo y devolución.
- Calcula multa de retraso (500 por día extra).
- Controla estado del préstamo (ACTIVO, DEVUELTO, VENCIDO).

---

### ✅ EstadoPrestamo
Enum que define:
ACTIVO
DEVUELTO
VENCIDO

---

### ✅ LibroNoDisponibleException
Se lanza cuando se intenta prestar un libro sin ejemplares disponibles.

---

### ✅ UsuarioSinCupoException
Se lanza cuando un usuario intenta prestar más de 3 libros o supera multas permitidas.

---

### ✅ Biblioteca
Es el “centro del sistema”.

Funciones:
- Registrar libros y usuarios.
- Realizar préstamos y devoluciones.
- Generar reportes:
  - Top 5 libros más prestados.
  - Usuarios con multas pendientes.
- Gestionar colecciones usando:
  - `HashMap`
  - `ArrayList`
  - `Streams` (compatible con Java 8/11)

---

### ✅ BibliotecaApp
Es la clase principal con el menú.

Opciones:
1. Agregar libro  
2. Registrar usuario  
3. Realizar préstamo  
4. Salir  

Usa un `Scanner` para interactuar con el usuario.

---

## ▶️ Cómo Compilar y Ejecutar

### 1. Compilar todos los archivos
Desde la carpeta **src** donde está la carpeta `biblioteca`:

```bash
javac biblioteca/*.java
```
### 2. Ejecutar el programa
```bash
java biblioteca.BibliotecaApp
```