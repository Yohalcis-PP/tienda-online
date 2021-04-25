# tienda-online
APIs para tienda online

Link documentación con swagger: http://localhost:9090/swagger-ui.html#/
Link Base de datos en memoría con H2: http://localhost:9090/h2-console/login.jsp?jsessionid=faa21bc36a71ea5d8b035e8d7eb8f93d

Detalles: 
Para realizar una compra, es necesario que existan los productos y el cliente en base de datos, de lo contrario existen APIs habilitadas para crear producto y cliente

Deudas tecnicas: 
Implementar DTOs faltantes para el adaptador Web
Refactoring a los nombres de las clases del dominio.
Se implementó una arquitectura de adaptadores con enfasis en el dominio, pero puede mejorar facilmente a una arquitectura hexagonal mas plana
Validaciones de los datos enviados del cliente para consumir las APIs
Se peude implementar Lombok para reducir codigos tipo Constructor, Getters y Setters
La implementación de Mappers(MapStruct) e Hibernate(JPA) pueden ser menos Lite.

**No se tuvo en cuenta el stock de cada producto** Deuda tecnica urgente

Para eliminar una compra que excedfió las 12H, se crea una factura por el 10% de la compra, al mismo cliente, y se elimina la anterior.


Bugs:
El editar compra no funciona según debe ser, aunque la logíca está implementada de buena forma,
Se identificó el problema con relación a Hibernate, al momento de editar en cascada, sin embargo la ausencia de tiempo restante no permitió que se resolviera adecuadamente y se opto por implementar lo siguiente:

como solución para poder mostrar lo lógica de negocio, se implementó el actualizar de una forma inadecuada, poco escalable y poco sostenible, es deber mejorar esta parte, pues no se actualiza, en verdad se elimina y se crea un nuevo registro, simulando el Update, pero con el gran problema que pierde el Id, y por ende se convierte en un proceso inestable.

