ACCESO A DATOS / PROGRAMACIÓN DE SERVICIOS Y PROCESOS - 2º DAM
UD04. VALIDACIÓN DE DATOS Y MANEJO DE ERRORES

E01. PRÁCTICA GUIADA DE MANEJO DE ERRORES Y VALIDACIÓN

AD-RA04. Define la estructura de clases necesaria para manejar la información asociada a los errores y fallos de. validación, internacionalizando dichos mensajes. 

PSP-RA04. Maneja los errores de la aplicación de forma global y coherente, devolviendo los mensajes y códigos de respuesta adecuados, validando los datos recibidos en las peticiones.
Criterios de evaluación
Ejercicio/s
AD04.a Se ha creado una estructura de clases para manejar la información asociada a los errores.
ÚNICO
AD04.c Se han utilizado las clases para manejar la información asociada a los errores para los fallos de validación.
ÚNICO
PSP04.b Se han implementado las clases necesarias para manejar los errores de forma global, devolviendo el mensaje y código de respuesta adecuado. 
ÚNICO
PSP04.c Se han identificado las diferentes clases y anotaciones para la validación que ofrece Spring.
ÚNICO


ESTE EJERCICIO ES OBLIGATORIO, PERO NO TIENE CALIFICACIÓN
Siguiendo los pasos que se describen en los ejemplos 23 y 24 del repositorio de la asignatura, debes implementar una api que sirva para gestionar estaciones de servicio y su ubicación.
De cada estación de servicio, queremos saber:
Nombre. Será una cadena de caracteres obligatoria y no puede estar vacía.
Marca (Repsol, BP, …). Será una cadena de caracteres pero puede estar vacía.
Ubicación. Será una cadena de caracteres con formato latitud, longitud, al estilo de Google Maps. Es obligatorio.
TieneAutolavado. Será un atributo booleano. No es obligatorio, aunque entonces por defecto deberá tener valor false.
PrecioGasoilNormal. Será un número decimal, que debe ser positivo o cero. Es obligatorio.
PrecioGasolina95Octanos.  Será un número decimal, que debe ser positivo o cero. Es obligatorio.
PrecioGasoilEspecial. Será un número decimal, que debe ser positivo o cero. No es obligatorio.
PrecioGasolina98. Será un número decimal, que debe ser positivo o cero. No es obligatorio.
Servicios. Será un texto largo con la descripción de los servicios que posee la gasolinera. No es obligatorio.
FechaApertura. Será una fecha del pasado.

Los pasos que puedes seguir para realizar este ejercicio son los siguientes (ojo, son una sugerencia y puedes cocinarlo a tu gusto):
Debes crear la parte más básica del API: entidad, repositorio y controlador. En este último recuerda que debes seguir las normas clásicas: petición GET para obtener todas las estaciones de servicio y para obtener una por su ID, petición POST de creación, petición PUT de edición, petición DELETE para eliminar.
En este caso, te recomiendo que el servicio lo hagas tú mismo a mano, y no te apoyes en el servicio base (al menos, por ahora). Plantéate en este caso qué situaciones de error se pueden producir al invocar cada método, y manéjalos con excepciones definidas en Spring o por ti mismo.
Comprueba con POSTMAN que con datos correctos, tu aplicación funciona correctamente.
Añade, paso a paso según el ejemplo 23, el código de manejo de errores. No copies y pegues el código, sino que puedes ir transcribiendo el mismo. Te animo a que te plantees alguna posible variante en la estructura del mensaje del error que te pueda venir bien.
Añade las anotaciones de validación necesarias según la especificación del ejercicio. ¿Crees que es bueno hacerlo directamente en la entidad, o sería preferible crear un DTO y añadirlas al mismo?
Completa el código de manejo de errores para unificarlo con la validación, como en el ejemplo 24. No copies y pegues el código, sino que puedes ir transcribiendo el mismo.
Los mensajes de error deben estar en un fichero de properties, así que tendrás que añadir el código necesario.
Añade a la colección de POSTMAN peticiones erróneas tanto en la creación como en la edición de estaciones de servicio.

Sería bueno que anotaras las dudas que vas teniendo.

AMPLIACIÓN
Te puedes animar a modificar el servicio base, para que incluya el lanzamiento de las excepciones, de forma que cualquier servicio que lo extienda ya incorpore ese comportamiento.
También te puedes animar con la internacionalización, tratando de crear los errores en inglés, francés u otro idioma que te guste. Puedes intentar probar a ejecutar tu api en otros idiomas echando un vistazo aquí: https://www.danvega.dev/blog/2017/06/21/spring-boot-properties-setting-locale/


