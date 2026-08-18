1. ¿Qué sucede con el cliente si el servidor no está ejecutándose al momento de intentar conectar? Muestre la excepción que lanza Java.
Respuesta:
 Si el servidor no está encendido, la conexión TCP falla inmediatamente porque no hay ningún proceso escuchando en ese puerto. Java lanza la excepción java.net.ConnectException: Connection refused.  
2. Identifique en su código qué línea bloquea la ejecución del programa hasta que ocurre un evento de red.
Respuesta:
En el Servidor, la línea Socket socket = servidor.accept(); bloquea el hilo principal esperando que ingrese un cliente.
También las líneas entrada.readUTF() en ambos lados se bloquean a la espera de que lleguen los bytes a través de la red.
3. Proponga qué cambios serían necesarios si dos compañeros de clase quisieran ejecutar el Cliente en una notebook y el Servidor en otra conectadas al Wi-Fi del aula.
Respuesta:
En el Cliente: Cambiar la variable String host = "127.0.0.1"; por la IP privada real de la netbook que actúa como servidor (ejemplo: String host = "192.168.1.50";).
Configuración de Red/Firewall: En la netbook del Servidor hay que permitir el tráfico entrante en el puerto TCP 5500 en el Firewall del sistema operativo para evitar que bloquee la conexión entrante.