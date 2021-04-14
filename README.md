# PruebaAccionaSpring

## DESCRIPCIÓN

Implementar un Microservicio que consuma Tweets y basado en unos criterios de configuración los persista en una base de datos para su gestión a través de una API REST.

Restricciones:

   * Solo se deben persistir aquellos tweets cuyos usuarios superen un número N de seguidores (default 1500). 
   * Solo se deben persistir aquellos tweets cuyo idioma esté en una lista de idiomas permitidos (default español, francés, italiano). 
   * De cada tweet deben almacenarse los siguientes datos: usuario, texto, localización, validación. 
   * El API REST debe permitir:
      * Consultar los tweets. 
      * Marcar un tweet como validado. 
      * Consultar los tweets validados por usuario. 
      * Consultar una clasificación de los N hashtags más usados (default 10). 
      * Utilizar Spring Boot para la implementación. 
      * Realizar la persistencia en memoria.
      
Subir el microservicio a un repositorio Git de su preferencia.

Links útiles http://twitter4j.org/en/ (Utilizar streaming API) 
https://developer.twitter.com/en/docs/tweets/data-dictionary/overview/tweet-object

## API

Las llamadas al API REST son las siguientes:

**Recoge los X ultimos Tweets y los persiste en una base de datos H2**

       http://localhost:8080/api/v1/mytweets/collect
   
**Lectura de todos los Tweets que actualmente se encuentran en la Base de datos**

       http://localhost:8080/api/v1/mytweets/read
   
 **Valida un Tweet. Hay que pasarle al final de la URL el ID de dicho Tweet.**
   
       http://localhost:8080/api/v1/mytweets/validate/{idTweet}
       
**Lectura de los Tweets validados de un usuario concreto.**

       http://localhost:8080/api/v1/mytweets/readValidated/{userName}
       
**Lectura de los N hashtags mas usados de los Tweets guardados de la base de datos.**

      http://localhost:8080/api/v1/mytweets/findTopHashtags
      

## Modelo de Datos

Los Tweets se mapean en Spring con este formato dentro de una clase propia llamada "MyTweets":

      @Id
      private String id;
      private String username;
      @Column(columnDefinition="varchar(300)")
      private String text;
      private String lang;
      private boolean isValidated = false;	
      private String hashTags="";
      
## Conexión Base de Datos H2 (en application.properties)

	spring.datasource.url=jdbc:h2:tcp://localhost/~/mydb;
	spring.datasource.driverClassName=org.h2.Driver
	spring.datasource.username=sa
	spring.datasource.password=
	spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
	spring.h2.console.enabled=true
	
## Conexión a Twitter (<font color="red"> HAY QUE ESPECIFICAR LAS CLAVES PARA LA CONEXIÓN: LAS HE DEJADO VACIAS, PARA QUE PONGAN LAS QUE USTEDES TENGAN</font>
 	En el fichero twitter4j.properties 

## Consideraciones de diseño

La aplicación se ha diseñado atendiendo al patrón MVC: Existe un Controller que es la puerta de entrada a la API del servicio REST, un Service que lleva toda la parte de Negocio, y un Repository que es la parte encargada de la gestión de la base de datos.

Se ha creado una clase especifica llamada "MyTwitterPropertiesConfig.java" que contiene las propiedades que se tienen en cuenta para ciertos aspectos de la aplicación (y que se tienen en cuenta en la clase Service). Tiene 3 propiedades:

  **// No se recogeran Tweets que no tengan al menos 1500 followers.**
 	
	private Integer numMinFollowers = 1500;
  
  **// Solo se recogeran Tweets de estos idiomas**
	
	private List<String> listLocationPermitted =  Arrays.asList("es", "fr", "it");
  
  **//Numero máximo HashTags mas usados.**
	
	private Integer numHashtagsMoreUsed = 10;	
	





	


