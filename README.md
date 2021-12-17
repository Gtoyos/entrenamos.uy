# entrenamos.uy

entrenamos.uy es una plataforma social de actividades deportivas a través de Internet, cuenta con una amplia cantidad de funcionalidades, de donde se destacan:

* Registro de usuarios, actividades, clases y cuponeras.
* Funcionalidades sociales: Seguir/Dejar de seguir usuarios, calificar clases y marcar actividades favoritas.
* Comprar clases y cuponeras.
* Sorteo de premios y generación de comprobantes. 

Este proyecto se implementó como un sistema distribuido. Existe un servidor central el cual almacena todos los datos de la plataforma y un servidor web el cual despliega el servicio
desde una aplicación web. La comunicación entre el servidor central y el servidor web es a través de web services (SOAP). Adicionalmente, el servidor central contiene una interfaz
gráfica hecha en Swing para realizar actividades de administración.

## Instalación

Se requiere [maven](https://maven.apache.org/) para la compilación del servidor central y [ant](https://ant.apache.org/) para la compilación del servidor web. Se provee un script, compile.sh para facilitar el proceso. Una vez ejecutado
el script genera en el directorio de trabajo, dependiendo de las opciones del script, ``servidor.jar`` y ``web.war``. El primero puede ejecutarse como un jar normal utilizando el comando ``java -jar servidor.jar``
El segundo puede ser desplegando utilizando un servidor web (e.g [tomcat](https://tomcat.apache.org/)).

## Configuración

La primera vez que se ejecutan los componentes se genera una carpeta ``.entrenamosUy`` en el directorio del usuario con archivos de configuración de cada componente. En este archivo deben
especificarse los puertos donde se publicará el servicio en el servidor central y al archivo de configuración del servidor web debe especificarse la URL del servicio web publicado.


## Información

Este proyecto tuvo como finalidad integrar e incorporar conocimientos avanzados para la construcción de sistemas de software de mediano y gran porte. Este proyecto fue realizado en el contexto del
curso de taller de programación de la Facultad de Ingeniería (UDELAR).

#### Integrantes

    Alexis Baladón - alexis.baladon@fing.edu.uy
    Guillermo Toyos - guillermo.toyos@fing.edu.uy
    Jorge Machado - jorge.machado.ottonelli@fing.edu.uy
    Juan José Mangado - juan.mangado@fing.edu.uy
    Mathias Ramilo - mathias.ramilo@fing.edu.uy


