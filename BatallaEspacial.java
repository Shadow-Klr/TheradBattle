public class BatallaEspacial {
    public static void main(String[] args) throws InterruptedException {
        int numNavesPorEquipo = 1; // puedes aumentar para más naves

        NaveEstelar[] zorgs = new NaveEstelar[numNavesPorEquipo];
        NaveEstelar[] blips = new NaveEstelar[numNavesPorEquipo];

        Thread[] hilosZorg = new Thread[numNavesPorEquipo];
        Thread[] hilosBlip = new Thread[numNavesPorEquipo];

        // Crear naves
        for (int i = 0; i < numNavesPorEquipo; i++) {
            zorgs[i] = new NaveEstelar("Zorg", "Nave Zorg");
            blips[i] = new NaveEstelar("Blip", "Nave Blip");
        }

        // Iniciar hilos
        for (int i = 0; i < numNavesPorEquipo; i++) {
            hilosZorg[i] = new Thread(zorgs[i]);
            hilosBlip[i] = new Thread(blips[i]);
            hilosZorg[i].start();
            hilosBlip[i].start();
        }

        // Esperar a que terminen
        for (int i = 0; i < numNavesPorEquipo; i++) {
            hilosZorg[i].join();
            hilosBlip[i].join();
        }

        // Determinar ganador
        int totalZorg = 0;
        int totalBlip = 0;
        for (int i = 0; i < numNavesPorEquipo; i++) {
            totalZorg += zorgs[i].getPosicion();
            totalBlip += blips[i].getPosicion();
        }

        System.out.println("\n--- Fin de la batalla ---");
        if (totalZorg > totalBlip) {
            System.out.println("Esta batalla la ha ganado Nave Zorg");
        } else if (totalBlip > totalZorg) {
            System.out.println("Esta batalla la ha ganado Nave Blip");
        } else {
            System.out.println("¡Empate galáctico!");
        }
    }
}
