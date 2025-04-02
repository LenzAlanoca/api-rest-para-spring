Este es un proyeto sobre APIREST  usando spring boot inicializado desde visual estudio y un modulo de mvn para evitar su instalacion en local
RECOMENDACIONES
-cambiar los datos en el archivo ".env" para su funcionamiento ya que estos dependen de tus credenciales a postgres

-verificar si tus puertos estan ocpupados para cambiar de puertos edita el archivo "application.properties" y cambia del puerto 8080 a uno desocupado

-cambia en el archivo "pom.xml" la version de java si la tuya no es la 24 exactamente en la siguiente linea: 

"
<properties>
		<java.version>24</java.version>
	</properties>

"
Este proyecto es gestion de estudiantes con todos lso microservicios basicos como ser put,post,get,delete, usando DTOs para la encapsulacion de datos de la entidades, por otro lado se utilizo postgress como gestor de base de datosy las dependendencias necesarias estan agregadas en el pom.xml

debes crear una bdd llamada "estudiandb" pero eso es configurable si modificas el .env

-No es necesario crear las tablas si no existe la tabla se creara automaticamente al momento de encener el dashboard

-cualquier consulta del proyecto comunicate al correo >>>>> : laalanoca3@umsa.bo 

GRACIAS¡¡¡¡
