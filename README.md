# Semana08_Excepciones_Hilos

## Descripción
Este proyecto simula retiros bancarios concurrentes usando hilos en Java y manejo de excepciones personalizadas.

## Sincronización vs. No sincronización

Cuando los métodos `depositar` y `retirar` de la clase `CuentaBancaria` están sincronizados (`synchronized`), se garantiza que solo un hilo puede modificar el saldo a la vez. Esto evita condiciones de carrera y asegura que el saldo nunca sea negativo ni incorrecto, aunque varios cajeros intenten retirar dinero simultáneamente.

Si los métodos NO estuvieran sincronizados, varios hilos podrían acceder y modificar el saldo al mismo tiempo, provocando inconsistencias. Por ejemplo, dos cajeros podrían ver el mismo saldo y ambos retirar más dinero del que realmente hay, dejando la cuenta en saldo negativo o incorrecto.

**Conclusión:**
- **Sin sincronizar:** Resultados inesperados, saldo incorrecto, posibles errores.
- **Sincronizado:** Operaciones seguras, saldo correcto, comportamiento predecible.

## Ejecución
Al ejecutar el programa, se crean tres hilos (cajeros) que intentan retirar dinero de la misma cuenta. Se imprime cada intento y el saldo final.

