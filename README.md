Nombre del Proyecto
Una breve descripción de lo que hace tu proyecto de pruebas Java.

Comenzando
Instrucciones para obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas.

Prerrequisitos
Java JDK 8
Maven
Instalación
Pasos para configurar el entorno de desarrollo.

Ejecutando las Pruebas
Descripción de cómo ejecutar las pruebas automatizadas.

Pruebas de StringUtil
repeat_string_once: Verifica que el método repeat de StringUtil repita una cadena una vez.
repeat_string_multiple_times: Asegura que repeat repita correctamente una cadena varias veces.
repeat_string_negative_times: Prueba que repeat lance una excepción cuando se intenta repetir una cadena un número negativo de veces.
Pruebas de PasswordUtil
weak_when_has_less_than_8_letters: Comprueba que la contraseña es débil si tiene menos de 8 letras.
medium_when_has_letters_and_numbers: Verifica que la contraseña es media si contiene letras y números.
strong_when_has_letters_numbers_and_characters: Asegura que la contraseña es fuerte si tiene letras, números y caracteres especiales.
Pruebas de DateUtil
return_true_when_year_is_divisible_by_400: Confirma que un año es bisiesto si es divisible por 400.
return_false_when_year_is_divisible_by_100_but_no_by_400: Verifica que un año no es bisiesto si es divisible por 100 pero no por 400.
Pruebas de Player y Dice
loose_when_dice_number_is_too_low: Prueba que el jugador pierde si el número del dado es bajo.
wins_when_dice_number_is_big: Asegura que el jugador gana si el número del dado es alto.
Pruebas de PaymentProcessor
payment_is_correct: Verifica que el pago se procesa correctamente.
payment_is_wrong: Asegura que el procesador de pagos identifica cuando hay un error.
Pruebas de MovieService
return_movies_by_genre: Comprueba que se devuelven películas por género.
return_movies_by_length: Asegura que se devuelven películas según su duración.
Despliegue
Instrucciones adicionales sobre cómo desplegar el proyecto.

Construido con
Maven - Manejador de dependencias
Java - Lenguaje de programación
Contribuyendo
Instrucciones para contribuir al proyecto.

Versionado
Uso de SemVer para el versionado.

Autores
Tu Nombre
Licencia
Este proyecto está bajo la Licencia XYZ.

Reconocimientos
Agradecimientos a quienes inspiraron o ayudaron en el proyecto.
