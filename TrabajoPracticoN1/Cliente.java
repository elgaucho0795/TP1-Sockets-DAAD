import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        String host = "127.0.0.1"; // IP local (localhost)
        int puerto = 5500;

        try (Scanner scanner = new Scanner(System.in)) {
            // Pedir los datos al usuario
            System.out.print("Ingrese el primer numero entero: ");
            int num1 = scanner.nextInt();

            System.out.print("Ingrese la operacion (+, -, *, /): ");
            String operacion = scanner.next();

            System.out.print("Ingrese el segundo numero entero: ");
            int num2 = scanner.nextInt();

            // Empaquetar la informacion en formato "num1;operacion;num2"
            String cadenaAEnviar = num1 + ";" + operacion + ";" + num2;

            System.out.println("\nConectando al servidor...");
            
            // Intentar conectar con el servidor
            Socket socket = new Socket(host, puerto);

            // Canales de entrada y salida
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
            DataInputStream entrada = new DataInputStream(socket.getInputStream());

            // Enviar la cadena
            salida.writeUTF(cadenaAEnviar);

            // Recibir y mostrar la respuesta
            String respuesta = entrada.readUTF();
            System.out.println("Respuesta del servidor: " + respuesta);

            // Cerrar el socket
            socket.close();

        } catch (IOException e) {
            System.out.println("Error en la comunicacion con el servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}