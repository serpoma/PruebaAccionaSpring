# PruebaAccionaSpring

##DESCRIPCIÓN

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

##API

Las llamadas al API REST son las siguientes:

Recoge los X ultimos Tweets y los persiste en una base de datos H2

   http://localhost:8080/api/v1/mytweets/collect
   
Lectura de todos los Tweets que actualmente se encuentran en la Base de datos

   http://localhost:8080/api/v1/mytweets/read
   
 Valida un Tweet. Hay que pasarle al final de la URL el ID de dicho Tweet.
   
   http://localhost:8080/api/v1/mytweets/validate/{idTweet}


