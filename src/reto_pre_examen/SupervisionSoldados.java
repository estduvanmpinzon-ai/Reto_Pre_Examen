package reto_pre_examen;

import java.util.Scanner;

class Lectura {
    private static final Scanner inp = new Scanner(System.in);

    public static int nextInt(String mss) {
        System.out.print(mss);
        return inp.nextInt();
    }
}

class FilaIndia {
    private int[] fila;
    private int cantidad = 0;

    public void add(int soldado) {
        if (fila == null) {
            fila = new int[100];
        }
        fila[cantidad] = soldado;
        cantidad++;
    }

    private int posicion(int soldado) {
        for (int i = 0; i < cantidad; i++) {
            if (fila[i] == soldado) {
                return i;
            }
        }
        return -1;
    }

    public void revisar(int[] comandantes, int[] subordinados) {
        for (int i = 0; i < comandantes.length; i++) {
            int posCom = posicion(comandantes[i]);
            int posSub = posicion(subordinados[i]);

            if (posSub < posCom) {
                System.out.println("NO. " + comandantes[i] + "-" + subordinados[i]);
                return;
            }
        }

        System.out.println("SI");
    }
}

public class SupervisionSoldados {
    public static void main(String[] args) {
        FilaIndia filaI = new FilaIndia();
        int comandantes[], subordinados[];

        int n = Lectura.nextInt("Cuántos soldados en la fila: ");

        for (int i = 0; i < n; i++) {
            filaI.add(Lectura.nextInt("Siguiente soldado: "));
        }

        int s = Lectura.nextInt("Cuántos supervisados: ");

        comandantes = new int[s];
        subordinados = new int[s];

        for (int i = 0; i < s; i++) {
            comandantes[i] = Lectura.nextInt("Siguiente soldado supervisor: ");
            subordinados[i] = Lectura.nextInt("Siguiente soldado subordinado: ");
        }

        filaI.revisar(comandantes, subordinados);
    }
}