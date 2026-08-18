# TP N° 1: Arquitectura Cliente-Servidor y Sockets TCP

**Materia:** Desarrollo de Aplicaciones para Ambientes Distribuidos  
**Alumno:** Héctor Guillermo Gil Caro  

## Descripción del Proyecto
Aplicación distribuida en Java que implementa un modelo Cliente-Servidor mediante la API `java.net`. El cliente solicita dos números enteros y una operación matemática por consola, los envía empaquetados al servidor (ejemplo: `15;+;30`), y este realiza el cálculo devolviendo el resultado o gestionando errores como la división por cero.

---

## Instrucciones de Ejecución

1. Compilar los archivos Java ubicados en la carpeta .
2. **Ejecutar el Servidor:**
   ```bash
   java Servidor
**Ejecutar el Cliente:**
   java Cliente