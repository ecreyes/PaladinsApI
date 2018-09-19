# Readme

La clase principal se llama "Demo", solo hay que ejecutarla e imprimirá la url para crear la sesión y asi obtener el session_id.

## Update
El siguiente código imprimirá la url para obtener la sessión id en el navegador.
```java
String url = Paladins.getUrltoSession();
System.out.println(url);
```
una vez obtenida la sessionid se comentan esas dos lineas para no generar error.

Ahora supongamos que necesitamos generar la siguiente url:
```bash
/getchampions[ResponseFormat]/{developerId}/{signature}/{session}/{timestamp}/{languageCode}
```
habria que utilzar lo siguiente:
```java
//se setea la session obtenida anteriormente.
Paladins.setSessionID("E0C06B2114304CC49BE7AE1A15B62F3A");
//se agrega el método
String url_random = Paladins.getUrl("getchampions");
System.out.println(url_random);
```
La url que generaría seria de la forma:
```bash
/getchampions[ResponseFormat]/{developerId}/{signature}/{session}/{timestamp}
```
ya que la mayoria o todos de los metodos usan ese formato + algo.
En la url generada faltaria agregar el `/9` y se obtienen todos los datos.
