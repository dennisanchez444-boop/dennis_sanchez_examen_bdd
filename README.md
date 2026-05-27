# Examen Dennis_Sanchez
[Link video parte 2](https://1drv.ms/v/c/82712d29564bcc57/IQAr7fJUCTFeRpr9JNracfFrAa84rgPGvyWhOlrRn6WgCYM?e=Dqx87N "videoParte2")
## Parte 3 - Mantenimiento y Extensibilidad

Se realizó la modificación del sistema para incluir el campo destino en la entidad vuelos.

### Cambios realizados:

- ALTER TABLE vuelos ADD COLUMN destino VARCHAR(100);
- Se modificó la entidad Vuelo.java agregando el atributo destino.
- Se actualizó el método update del servicio para incluir el nuevo campo.
- Se actualizaron los JSON de Postman.

ALTER TABLE vuelos ADD COLUMN destino VARCHAR(100);