# Previous Tasks

A list of README files of previous projects required for learning native android development using java.

## Task 1

```markdown
# Conversor de Moneda - Patrón MVVM

## Descripción de la aplicación

Esta es una aplicación móvil desarrollada en Android (Java) que permite realizar conversiones numéricas entre Dólares (USD) y Euros (EUR). La aplicación está diseñada bajo el patrón de arquitectura MVVM y cuenta con las siguientes características:

1. **Gestión del Tipo de Cambio:** Permite al usuario establecer y actualizar el valor de conversión actual de la moneda de forma dinámica.
2. **Conversión Bidireccional:** A través de opciones (RadioButtons), el usuario puede elegir si desea calcular el equivalente de Dólares a Euros, o de Euros a Dólares.
3. **Validación de Entradas:** El sistema verifica que los campos no estén vacíos y valida que los valores ingresados tengan un formato numérico correcto, notificando al usuario mediante alertas visuales (setError y Toasts) en caso de error.

## Integrantes

Esta actividad se realizó de manera individual.

- **Apellido**: Angel.
- **Nombre**: Emanuel.
- **Número de Documento**: 44600506.

## Detalles Técnicos y Arquitectura

La aplicación fue desarrollada implementando estrictamente el patrón de arquitectura **MVVM (Model - View - ViewModel)**, separando las responsabilidades en tres capas fundamentales:

- **View (`MainActivity`):** Se encarga única y exclusivamente de gestionar la interfaz gráfica y capturar las interacciones del usuario. Se utilizó `ViewBinding` para enlazar los componentes de la vista. Esta capa no contiene lógica de negocio; simplemente observa los datos expuestos por el ViewModel para actualizar la pantalla (por ejemplo, mostrando el resultado de la conversión o los mensajes de error).
- **ViewModel (`MainActivityViewModel`):** Actúa como puente entre la Vista y el Modelo. Recibe los datos crudos de la vista, realiza las validaciones lógicas necesarias y utiliza `MutableLiveData` (para `rate`, `conversionResult` y `errorMessage`) para exponer el estado actual a la vista de manera reactiva. Aquí se decide qué método del Modelo invocar según la opción seleccionada por el usuario.
- **Model (`ConversionModel`):** Es una clase Java pura que representa la lógica de negocio central. Contiene los algoritmos matemáticos encargados de realizar el cálculo de conversión entre divisas utilizando la tasa de cambio provista. Es completamente independiente y no tiene referencias al framework de Android.

*Proyecto académico desarrollado para la Universidad de La Punta (ULP).*
```

## Task 2

```markdown
# BroadcastReceiver e Intents Implícitos

## Descripción de la aplicación

Cuando la aplicación está en ejecución y el usuario bloquea y posteriormente desbloquea la pantalla del dispositivo, el sistema desencadena las siguientes acciones:

1. **Notificación Visual (Toast):** Muestra un mensaje emergente en pantalla con el texto *"Screen Unlocked!"*.
2. **Registro de Depuración (Logcat):** Imprime un mensaje en la consola de Android Studio bajo la etiqueta `UNLOCK RECEIVER` indicando que el evento fue capturado exitosamente.
3. **Intent Implícito (Llamada):** Abre la aplicación de marcador telefónico por defecto del sistema (Dialer) con el número `2664553747` pre-cargado, listo para llamar.

## Integrantes

Esta actividad se realizó de manera individual.

- **Apellido**: Angel.
- **Nombre**: Emanuel.
- **Número de Documento**: 44600506.

## Detalles Técnicos y Arquitectura

- **Gestión del Ciclo de Vida:** El registro (`registerReceiver`) del `UnlockScreenReceiver` se realiza en el método `onCreate()` y su respectivo desregistro (`unregisterReceiver`) en el método `onDestroy()` del `MainActivity`. Esta decisión arquitectónica garantiza que la aplicación siga escuchando el evento de desbloqueo incluso cuando la Activity pasa por `onStop()` al apagarse la pantalla.
- **Flags de Intent:** Para abrir la aplicación de llamadas desde un `BroadcastReceiver` (el cual carece de una interfaz gráfica o pila de Activities propia), se añadió la bandera `Intent.FLAG_ACTIVITY_NEW_TASK` al Intent implícito, evitando excepciones de ejecución y asegurando que el Dialer se abra en una nueva tarea.
- **Acción Segura:** Se utilizó `Intent.ACTION_DIAL` en lugar de `ACTION_CALL` para no requerir permisos invasivos al usuario, permitiéndole confirmar la llamada manualmente (además de porque la actividad menciona a `ACTION_DIAL`).

*Proyecto académico desarrollado para la Universidad de La Punta (ULP).*
```

## Task 3

```markdown
# android-tp3 - Aplicación de Búsqueda de Libros - Patrón MVVM

## Descripción de la aplicación

Esta es una aplicación móvil desarrollada en Android (Java) que permite buscar información sobre libros. La aplicación está diseñada bajo el patrón de arquitectura MVVM (Model-View-ViewModel) y cuenta con las siguientes características:

1. **Búsqueda por título:** Permite al usuario ingresar el título de un libro y obtener información detallada sobre él.
2. **Validación de Entradas:** El sistema verifica que los campos no estén vacíos y muestra mensajes de error apropiados cuando la búsqueda no produce resultados.
3. **Interfaz Responsiva:** La aplicación muestra una vista de detalle con información completa del libro encontrado, incluyendo título, autor, año de publicación, cantidad de páginas, géneros, descripción y una imagen de portada.

## Integrantes

Esta actividad se realizó de manera individual.

- **Apellido:** Emanuel.
- **Nombre:** Angel.
- **Número de Documento:** 44600506.

## Detalles Técnicos y Arquitectura

La aplicación fue desarrollada implementando el patrón de arquitectura **MVVM (Model - View - ViewModel)**, separando las responsabilidades en tres capas fundamentales:

- **View (`SearchActivity` y `DetailsActivity`):** Se encarga única y exclusivamente de gestionar la interfaz gráfica y capturar las interacciones del usuario. Se utiliza `ViewBinding` para enlazar los componentes de la vista. Esta capa no contiene lógica de negocio; simplemente observa los datos expuestos por el ViewModel para actualizar la pantalla (por ejemplo, mostrando el libro encontrado o los mensajes de error).
- **ViewModel (`SearchActivityViewModel` y `DetailsActivityViewModel`):** Actúa como puente entre la Vista y el Modelo. Recibe los datos crudos de la vista, realiza las validaciones lógicas necesarias y utiliza `MutableLiveData` para exponer el estado actual a la vista de manera reactiva. Aquí se decide qué método del Modelo invocar según las acciones del usuario.
- **Model (`Book` y `BookRepository`):** Representa la lógica de negocio central. La clase `Book` es un modelo de datos puro que contiene la información del libro, mientras que `BookRepository` maneja la colección de libros y proporciona métodos para buscarlos. Es completamente independiente y no tiene referencias al framework de Android.

_Proyecto académico desarrollado para la Universidad de La Punta (ULP)._

```

Alongside other kind of tasks in which components like <ListView> and <RecyclerView> are being used.
