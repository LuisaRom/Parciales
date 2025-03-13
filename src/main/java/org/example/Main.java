package org.example;

import org.example.Cabina;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private List<Cabina> cabinas = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main app = new Main();
        app.inicializarCabinas();
        app.menuPrincipal();
    }

    private void inicializarCabinas() {
        cabinas.add(new Cabina());
        cabinas.add(new Cabina());
        cabinas.add(new Cabina());
    }

    private void menuPrincipal() {
        int opcion;
        do {
            System.out.println("BIENVENIDO A LAS CABINAS");
            System.out.println("1. Registrar una llamada");
            System.out.println("2. Mostrar información de una cabina");
            System.out.println("3. Reiniciar una cabina");
            System.out.println("4. Ver información final");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> registrarLlamada();
                case 2 -> mostrarInformacionCabina();
                case 3 -> reiniciarCabina();
                case 4 -> mostrarConsolidadoTotal();
                case 5 -> System.out.println("Saliste de la Cabina");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }

    private void registrarLlamada() {
        Cabina cabina = seleccionCabina();
        if (cabina == null) return;

        System.out.println("SELECCION LLAMADAS");
        System.out.println("1. Local ($50/min)");
        System.out.println("2. Larga distancia ($350/min)");
        System.out.println("3. Celular ($150/min)");
        System.out.print("Seleccione el tipo de llamada: ");
        int tipoLlamada = scanner.nextInt();

        System.out.print("Ingrese la duración en minutos: ");
        int minutos = scanner.nextInt();

        cabina.registrarLlamada(tipoLlamada, minutos);
        System.out.println("Llamada registrada con éxito.");
    }

    private void mostrarInformacionCabina() {
        Cabina cabina = seleccionCabina();
        if (cabina != null) {
            System.out.println(cabina);
        }
    }

    private void reiniciarCabina() {
        Cabina cabina = seleccionCabina();
        if (cabina != null) cabina.reiniciar();
    }

    private Cabina seleccionCabina() {
        if (cabinas.isEmpty()) {
            System.out.println("No hay cabinas registradas.");
            return null;
        }

        System.out.print("Ingrese ID de la cabina: ");
        int id = scanner.nextInt();

        for (Cabina cabina : cabinas) {
            if (cabina.getId() == id) {
                return cabina;
            }
        }

        System.out.println("Cabina no encontrada.");
        return null;
    }

    private void mostrarConsolidadoTotal() {
        int totalLlamadas = 0, totalMinutos = 0, totalCosto = 0;

        for (Cabina cabina : cabinas) {
            totalLlamadas += cabina.getTotalLlamadas();
            totalMinutos += cabina.getTotalMinutos();
            totalCosto += cabina.getCostoTotal();
        }

        System.out.println("CONSOLIDADO TOTAL");
        System.out.println("Total de llamadas: " + totalLlamadas);
        System.out.println("Total de minutos: " + totalMinutos);
        System.out.println("Costo total: $" + totalCosto);
    }


}
