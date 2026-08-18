import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        int puerto = 5500;

        try (ServerSocket servidor = new ServerSocket(puerto)) {
            System.out.println("Servidor iniciado. Esperando conexiones en el puerto " + puerto + "...");

            // El servidor se queda esperando que un cliente se conecte
            Socket socket = servidor.accept(); 
            System.out.println("Cliente conectado desde: " + socket.getInetAddress());

            // Canales de entrada (para recibir) y salida (para enviar)
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());

            // Leer el mensaje del cliente
            String mensajeRecibido = entrada.readUTF();
            System.out.println("Mensaje recibido: " + mensajeRecibido);

            // Parsear el mensaje enviado como "num1;operacion;num2"
            String[] partes = mensajeRecibido.split(";");
            
            if (partes.length == 3) {
                int num1 = Integer.parseInt(partes[0]);
                String operacion = partes[1];
                int num2 = Integer.parseInt(partes[2]);

                String resultadoStr = "";

                switch (operacion) {
                    case "+":
                        resultadoStr = "Resultado: " + (num1 + num2);
                        break;
                    case "-":
                        resultadoStr = "Resultado: " + (num1 - num2);
                        break;
                    case "*":
                        resultadoStr = "Resultado: " + (num1 * num2);
                        break;
                    case "/":
                        if (num2 == 0) {
                            resultadoStr = "ERROR: Division por cero";
                        } else {
                            resultadoStr = "Resultado: " + ((double) num1 / num2);
                        }
                        break;
                    default:
                        resultadoStr = "ERROR: Operacion invalida";
                        break;
                }

                // Enviar el resultado de vuelta al cliente
                salida.writeUTF(resultadoStr);
            } else {
                salida.writeUTF("ERROR: Formato invalido");
            }

            // Cierre de conexiones
            socket.close();
            System.out.println("Servidor finalizado.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}