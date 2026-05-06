# android-tp4 - Gestión de Productos - Patrón MVVM

## Video de Demostración

https://github.com/user-attachments/assets/c4330f1e-cb90-4a20-9334-220140fbf264

## Flujo mostrado en el video

1. **Estado Inicial**: Lista de productos vacía.
2. **Carga de Productos**: Se agregan varios productos satisfactoriamente.
3. **Listado de Productos**: Los productos se muestran en orden alfabético.
4. **Robuztes y Duplicación**: Se valida campos vacíos y duplicación de códigos.
5. **Botón de Salir**: Se muestra un diálogo de confirmación para salir de la aplicación.

## Descripción de la aplicación

Esta es una aplicación móvil desarrollada en Android (Java) para la gestión interna de productos. La aplicación permite registrar nuevos artículos y visualizar un catálogo organizado, implementando el patrón de arquitectura MVVM (Model-View-ViewModel) y componentes modernos de navegación.

### Características principales:

1.  **Carga de Productos:** Formulario para registrar productos con código único, descripción y precio.
2.  **Validación Robusta:** El sistema valida campos vacíos y evita la duplicación de códigos de producto, notificando al usuario mediante `TextInputLayout` errors y `Toasts`.
3.  **Listado Dinámico:** Visualización de productos en un `RecyclerView` con un diseño basado en `CardView`. Los productos se muestran ordenados alfabéticamente por descripción.
4.  **Navegación Adaptativa:** Implementación de `Navigation Component` con soporte para `Navigation Drawer` (en pantallas grandes/tablets) y `BottomNavigationView` (en dispositivos móviles), permitiendo una experiencia de usuario fluida.
5.  **Confirmación de Salida:** Diálogo de alerta personalizado para confirmar el cierre de la aplicación.

## Integrantes

Esta actividad se realizó de manera individual.

- **Apellido:** Angel.
- **Nombre:** Emanuel.
- **Número de Documento:** 44600506.

## Detalles Técnicos y Arquitectura

La aplicación fue desarrollada implementando el patrón de arquitectura **MVVM (Model - View - ViewModel)**, asegurando una separación clara de responsabilidades:

-   **View (`MainActivity`, `CargarFragment`, `ListarFragment`):** Gestiona la interfaz de usuario y la navegación. Utiliza `ViewBinding` para un acceso seguro a los componentes gráficos. Observa los cambios en el estado del ViewModel a través de `LiveData`.
-   **ViewModel (`CargarViewModel`, `ListarViewModel`):** Contiene la lógica de presentación y gestión de estado. Procesa la validación de datos para la carga y prepara la lista ordenada para la visualización, sobreviviendo a cambios de configuración.
-   **Model (`Producto`):** Representa la entidad de negocio. Es una clase POJO (Plain Old Java Object) que define las propiedades y el comportamiento básico del producto.

### Componentes Utilizados:
- **Navigation Component:** Para gestionar los fragmentos y la navegación entre secciones.
- **RecyclerView + Adapter:** Para la visualización eficiente de colecciones de datos.
- **Material Design:** Uso de `TextInputLayout`, `CardView` y `FloatingActionButton`.

_Proyecto académico desarrollado para la Universidad de La Punta (ULP)._
