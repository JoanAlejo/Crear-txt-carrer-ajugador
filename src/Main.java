import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== REGISTRO DE JUGADOR DE FUTBOL ===");

        System.out.print("Nombre del jugador: ");
        String nombre = sc.nextLine();

        System.out.print("Nacionalidad: ");
        String nacionalidad = sc.nextLine();

        System.out.print("Posicion: ");
        String posicion = sc.nextLine();

        System.out.print("Cuantos equipos ha tenido: ");
        int numEquipos = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        String infoEquipos = "";

        // ciclo para pedir equipos y goles
        for (int i = 1; i <= numEquipos; i++) {
            System.out.println("\nEquipo #" + i);

            System.out.print("Nombre del equipo: ");
            String equipo = sc.nextLine();

            System.out.print("Goles en este equipo: ");
            int golesEquipo = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            infoEquipos += "Equipo: " + equipo + " - Goles: " + golesEquipo + "\n";
        }

        System.out.print("Titulos ganados: ");
        String titulos = sc.nextLine();

        TextFileWriter writer = new TextFileWriter("jugador.pdf");

        try {
            writer.openFile();

            writer.writeToFile("=== HOJA DE VIDA FUTBOLISTICA ===\n\n");
            writer.writeToFile("Nombre: " + nombre + "\n");
            writer.writeToFile("Nacionalidad: " + nacionalidad + "\n");
            writer.writeToFile("Posicion: " + posicion + "\n\n");

            writer.writeToFile("=== EQUIPOS Y GOLES ===\n");
            writer.writeToFile(infoEquipos + "\n");

            writer.writeToFile("Titulos: " + titulos + "\n");

            writer.writeToFile("\nGenerado con Java.");

            System.out.println("Archivo creado correctamente.");

        } catch (IOException e) {
            System.out.println("Error al escribir: " + e.getMessage());
        } finally {
            try {
                writer.closeFile();
            } catch (IOException e) {
                System.out.println("Error al cerrar: " + e.getMessage());
            }
        }

        sc.close();
    }
}
