package org.example;

public class Cabina {
    private static int contador = 1;
    private int id;
    private int llamadaLocal = 0;
    private int llamadaLargaDistancia = 0;
    private int llamadaCelular = 0;
    private int minutoLocal = 0;
    private int minutoLargaDistancia = 0;
    private int minutoCelular = 0;

    public Cabina() {
        this.id = contador++;
    }

    public Cabina(int id, int llamadaLocal, int llamadaLargaDistancia, int llamadaCelular, int minutoLocal, int minutoLargaDistancia, int minutoCelular) {
        this.id = id;
        this.llamadaLocal = llamadaLocal;
        this.llamadaLargaDistancia = llamadaLargaDistancia;
        this.llamadaCelular = llamadaCelular;
        this.minutoLocal = minutoLocal;
        this.minutoLargaDistancia = minutoLargaDistancia;
        this.minutoCelular = minutoCelular;
    }

    public int getId() {
        return id;
    }

    public void registrarLlamada(int tipo, int minutos) {
        switch (tipo) {
            case 1 -> {
                llamadaLocal++;
                minutoLocal += minutos;
            }
            case 2 -> {
                llamadaLargaDistancia++;
                minutoLargaDistancia += minutos;
            }
            case 3 -> {
                llamadaCelular++;
                minutoCelular += minutos;
            }
            default -> System.out.println("Tipo de llamada inválido.");
        }
    }

    public void reiniciar() {
        llamadaLocal = 0;
        llamadaLargaDistancia = 0;
        llamadaCelular = 0;
        minutoLocal = 0;
        minutoLargaDistancia = 0;
        minutoCelular = 0;
        System.out.println("La Cabina " + id + " ha sido reiniciada.");
    }

    public int getTotalLlamadas() {
        return llamadaLocal + llamadaLargaDistancia + llamadaCelular;
    }

    public int getTotalMinutos() {
        return minutoLocal + minutoLargaDistancia + minutoCelular;
    }

    public int getCostoTotal() {
        return (minutoLocal * 50) + (minutoLargaDistancia * 350) + (minutoCelular * 150);
    }

    @Override
    public String toString() {
        return "Cabina{" +
                "id=" + id +
                ", llamadaLocal=" + llamadaLocal +
                ", llamadaLargaDistancia=" + llamadaLargaDistancia +
                ", llamadaCelular=" + llamadaCelular +
                ", minutoLocal=" + minutoLocal +
                ", minutoLargaDistancia=" + minutoLargaDistancia +
                ", minutoCelular=" + minutoCelular +
                '}';
    }
}
